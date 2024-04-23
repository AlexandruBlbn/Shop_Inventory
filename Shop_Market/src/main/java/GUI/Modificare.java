package GUI;

import Auth.Detalii.Auth_Method;
import Queries.Query_Select_Inv;
import Queries.Query_Update_Inv_2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Set;
import java.util.TreeSet;

public class Modificare extends JDialog {
    private Connection conn = null;
    private Statement stn = null;
    private ResultSet rezult = null;

    private JPanel panou;
    private JComboBox boxMagazin;
    private JComboBox boxTip;
    private JComboBox boxFel;
    private JComboBox boxBrand;
    private JComboBox boxPropietate;
    private JComboBox boxOras;
    private JTable table1;
    private JButton acasaButton;
    private JButton cautareButton;
    private JButton efectuareModificareButton;
    private Auth_Method detalii;

    private String magaz;
    private String tip_prod;
    private String fel_;
    private String brand_;
    private String propietate;
    private String cantitate;
    private String oras_;



    public String getMagaz() {
        return magaz;
    }

    public void setMagaz(String magaz) {
        this.magaz = magaz;
    }

    public String getTip_prod() {
        return tip_prod;
    }

    public void setTip_prod(String tip_prod) {
        this.tip_prod = tip_prod;
    }

    public String getFel_() {
        return fel_;
    }

    public void setFel_(String fel_) {
        this.fel_ = fel_;
    }

    public String getBrand_() {
        return brand_;
    }

    public void setBrand_(String brand_) {
        this.brand_ = brand_;
    }

    public String getPropietate() {
        return propietate;
    }

    public void setPropietate(String propietate) {
        this.propietate = propietate;
    }

    public String getCantitate() {
        return cantitate;
    }

    public void setCantitate(String cantitate) {
        this.cantitate = cantitate;
    }

    public String getOras_() {
        return oras_;
    }

    public void setOras_(String oras_) {
        this.oras_ = oras_;
    }



    private Modificare_Part2 mods;
    private Valori values;

    public Modificare(Auth_Method detalii) {
        this.detalii = detalii;
        this.values = new Valori();
        setTitle("Meniu modificare");
        final String[] query = new String[1];
        setContentPane(panou);
        setMinimumSize(new Dimension(1000, 400));
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
        cautareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cautare();

            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int randSelect = table1.getSelectedRow();
                boxMagazin.setSelectedItem(table1.getValueAt(randSelect, 0).toString());
                setMagaz(boxMagazin.getSelectedItem().toString());

                boxTip.setSelectedItem(table1.getValueAt(randSelect, 1).toString());
                setTip_prod(boxTip.getSelectedItem().toString());

                boxFel.setSelectedItem(table1.getValueAt(randSelect, 2).toString());
                setFel_(boxFel.getSelectedItem().toString());

                boxBrand.setSelectedItem(table1.getValueAt(randSelect, 3).toString());
                setBrand_(boxBrand.getSelectedItem().toString());

                boxPropietate.setSelectedItem(table1.getValueAt(randSelect, 4).toString());
                setPropietate(boxPropietate.getSelectedItem().toString());

                boxOras.setSelectedItem(table1.getValueAt(randSelect, 6).toString());
                setOras_(boxOras.getSelectedItem().toString());

                setCantitate(table1.getValueAt(randSelect,5).toString());;
                values.setMagaz(magaz);
                values.setTip_prod(tip_prod);
                values.setFel_(fel_);
                values.setBrand_(brand_);
                values.setPropietate(propietate);
                values.setCantitate(cantitate);
                values.setOras_(oras_);

                Query_Update_Inv_2 select = new Query_Update_Inv_2();
                StringBuilder builder = new StringBuilder();
                String Tip = (String) boxTip.getSelectedItem();
                String FelArticol = (String) boxFel.getSelectedItem();
                String Brand = (String) boxBrand.getSelectedItem();
                String Proprietate = (String) boxPropietate.getSelectedItem();
                String Oras = (String) boxOras.getSelectedItem();

                select.Constructor(builder, String.valueOf(boxMagazin.getSelectedIndex()), Tip, FelArticol, Brand, Proprietate, Oras);

                String query = builder.toString();
                values.setQuery_Cond(query);
            }
        });


        efectuareModificareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modific();
            }
        });
        panou.setVisible(true);
    }

    private void modific() {
        dispose();
        Modificare_Part2 modifica = new Modificare_Part2(detalii, values);
        modifica.setVisible(true);
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


    public static void main(String[] args) {
        Auth_Method detalii = new Auth_Method();
        Modificare fereastra = new Modificare(detalii);
    }
}
