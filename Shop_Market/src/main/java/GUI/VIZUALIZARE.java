package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Set;
import java.util.TreeSet;

import Auth.Detalii.Auth_Method;
import Queries.Query_Select_Inv;

public class VIZUALIZARE extends JDialog {

    private Connection conn = null;
    private Statement stn = null;
    private ResultSet rezult = null;

    private JPanel Vizualizare;
    private JComboBox<String> boxMagazin;
    private JComboBox<String> boxTip;
    private JComboBox<String> boxFel;
    private JComboBox<String> boxBrand;
    private JComboBox<String> boxPropietate;
    private JComboBox<String> boxCantitate;
    private JComboBox<String> boxOras;
    private JButton acasaButton;
    private JButton cautareButton;
    private JTable table1;
    private JTable TablouMDL;
    private Auth_Method detalii;

    public VIZUALIZARE(Auth_Method detalii) {
        this.detalii = detalii;
        setTitle("Meniu Vizualizare");
        setContentPane(Vizualizare);
        setMinimumSize(new Dimension(800, 600));
        actualizareCombo(boxMagazin, "Nr_Magazin");
        actualizareCombo(boxTip, "tip");
        actualizareCombo(boxFel, "fel_articol");
        actualizareCombo(boxBrand, "brand");
        actualizareCombo(boxPropietate, "propietate");
        actualizareCombo(boxOras, "oras");

        setModal(true);
        setLocationRelativeTo(null);

        acasaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Menu meniu = new Menu(detalii);
                meniu.setVisible(true);
            }
        });


//        cautareButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                StringBuilder queryBuilder = new StringBuilder();
//                Query_Select_Inv select = new Query_Select_Inv();
//                select.Constructor(queryBuilder, boxMagazin.getSelectedIndex(), boxTip.getSelectedItem().toString(), boxFel.getSelectedItem().toString(), boxBrand.getSelectedItem().toString(),
//                        boxPropietate.getSelectedItem().toString(), boxOras.getSelectedItem().toString());
//                String query = queryBuilder.toString() + ";";
//                System.out.println("q" + query);
//                try{
//                    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database_shop", detalii.getNume(), detalii.getParola());
//                    stn = conn.createStatement();
//                    rezult = stn.executeQuery(query);
//
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });
        cautareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cautare();

            }
        });

        setVisible(true);
    }

    private void cautare() {
        table1.setModel(new DefaultTableModel());
        Query_Select_Inv select = new Query_Select_Inv();
        StringBuilder builder = new StringBuilder();
        String Tip = (String) boxTip.getSelectedItem();
        String FelArticol = (String) boxFel.getSelectedItem();
        String Brand = (String) boxBrand.getSelectedItem();
        String Proprietate = (String) boxPropietate.getSelectedItem();
        String Oras = (String) boxOras.getSelectedItem();

        select.Constructor(builder, boxMagazin.getSelectedIndex(), Tip, FelArticol, Brand, Proprietate, Oras);

        String query = builder.toString() + ";";
        String query2 = "SELECT * FROM inventar";
        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database_shop", detalii.getNume(), detalii.getParola());
            stn = conn.createStatement();
            rezult = stn.executeQuery(query);
            ResultSetMetaData rsmd = rezult.getMetaData();
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            int coloane = rsmd.getColumnCount();
            String[] nume_coloana = new String[coloane];
            for(int i = 0; i < coloane; i++)
                nume_coloana[i] = rsmd.getColumnName(i+1);
                model.setColumnIdentifiers(nume_coloana);
                String nr, tip, fel, brand, propietate, cantitate, oras;
                while (rezult.next()){
                    nr = rezult.getString(1);
                    tip = rezult.getString(2);
                    fel = rezult.getString(3);
                    brand = rezult.getString(4);
                    propietate = rezult.getString(5);
                    cantitate = rezult.getString(6);
                    oras = rezult.getString(7);
                    String[] rand = {nr, tip, fel, brand, propietate, cantitate, oras};
                    model.addRow(rand);
                }
                conn.close();

        }catch (SQLException ex){
            System.out.println(ex);
        }}

    //***************************************************
//optiuni ComboBox
    private void actualizareCombo(JComboBox<String> model, String coloana) {
        String sql = "select distinct " + coloana + " from inventar order by " + coloana;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database_shop", detalii.getNume(), detalii.getParola());
            stn = conn.createStatement();
            rezult = stn.executeQuery(sql);
            Set<String> valoriUnice = new TreeSet<>();
            model.addItem("");
            while (rezult.next()) {
                valoriUnice.add(rezult.getString(coloana));
            }

            for (String valoare : valoriUnice) {
                model.addItem(valoare);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
//***************************************************

    public static void main(String[] args) {
        Auth_Method detalii = new Auth_Method();
        VIZUALIZARE fereastra = new VIZUALIZARE(detalii);
    }

//    private void createUIComponents() {
//        String Header[] = {"Numar magazin", "Tip", "Fel articol", "Brand", "Propietati", "Cantitate", "Oras"};
//        DefaultTableModel model = new DefaultTableModel(0, 7);
//        model.setColumnIdentifiers(Header);
//        table1 = new JTable(model);
//        StringBuilder queryBuilder = new StringBuilder();
//        Query_Select_Inv select = new Query_Select_Inv();
//        select.Constructor(queryBuilder, boxMagazin.getSelectedIndex(), boxTip.getSelectedItem().toString(), boxFel.getSelectedItem().toString(), boxBrand.getSelectedItem().toString(),
//                boxPropietate.getSelectedItem().toString(), boxOras.getSelectedItem().toString());
//        String query = queryBuilder.toString() + ";";
//        System.out.println(query);
//        try{
//            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database_shop", detalii.getNume(), detalii.getParola());
//            stn = conn.createStatement();
//            rezult = stn.executeQuery(query);
//            while(rezult.next()){
//                Object[] row = {rezult.getInt("Nr_magazin"), rezult.getString("Tip"), rezult.getString("Fel_Articol"), rezult.getString("Brand"), rezult.getString("Propietate"), rezult.getInt("Cantitate"), rezult.getString("Oras")};
//                model.addRow(row);
//            }
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//

    }

