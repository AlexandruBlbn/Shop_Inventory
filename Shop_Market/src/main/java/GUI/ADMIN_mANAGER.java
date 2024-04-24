package GUI;

import Admin_Stuff.Generare_User_Manager;
import Auth.Detalii.Auth_Method;
import Auth.Detalii.database_check;
import Queries.Query_Update_Inv_2;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeSet;

public class ADMIN_mANAGER extends JDialog {

    Connection conn = null;
    Statement stn = null;
    ResultSet rezult = null;
    private JPanel Vizualizare;
    private JComboBox boxNumar;
    private JButton inapoiButton;
    private JButton stergereButton;
    private JTable table1;
    private JButton creareButton;
    private JComboBox boxNume;
    private JPanel panou;
    private JButton cautareButton;

    private String nume;
    private String numar;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNumar() {
        return numar;
    }

    public void setNumar(String numar) {
        this.numar = numar;
    }

    private String delete;

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    private Auth_Method detalii;
    public ADMIN_mANAGER(Auth_Method detalii){
        this.detalii = detalii;
        setTitle("ADMIN PANEL");
        setContentPane(panou);
        setMinimumSize(new Dimension(800, 600));
        actualizareCombo(boxNume, "Nume");
        actualizareCombo(boxNumar, "ID_magazin");
        setModal(true);
        setLocationRelativeTo(null);

        cautareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cautare();

            }
        });
        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ADMIN admin = new ADMIN(detalii);
                admin.setVisible(true);
            }
        });


        stergereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                database_check data = new database_check();

                String query_Delete = "DELETE FROM ANGAJATII WHERE NUME = '" + boxNume.getSelectedItem() + "' AND ID_MAGAZIN = " + boxNumar.getSelectedItem() +
                        " AND ROL = 'MANAGER';";
                System.out.println(query_Delete);

                int rezultat = JOptionPane.showConfirmDialog(null, "Esti sigur ca doresti sa stergi acest utilizator?", "Confirmare", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (rezultat == JOptionPane.YES_OPTION){
                    try{
                        conn = DriverManager.getConnection(data.getUrl(), detalii.getNume(), detalii.getParola());
                        stn = conn.createStatement();
                        stn.executeUpdate("DROP USER '" + boxNume.getSelectedItem() + "'@'localhost';");
                        stn.executeUpdate(query_Delete);
                        System.out.println("Stergere efectuata cu succes!");
                    }catch (SQLException ex){
                        System.out.println(ex);
                    }
                }else{
                    System.out.println("Intrerupere stergere.");
                }
                }

        });
        creareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }
        });
        creareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Creare_Manager creare = new Creare_Manager(detalii);
                creare.setVisible(true);
            }
        });
        setVisible(true);
    }

    private void cautare() {
        table1.setModel(new DefaultTableModel());
        Generare_User_Manager select = new Generare_User_Manager();
        StringBuilder builder = new StringBuilder();
        String Nume = (String) boxNume.getSelectedItem();
        String Numar = (String) boxNumar.getSelectedItem();
        String query = "SELECT nume, ID_Magazin FROM ANGAJATII WHERE ROL = 'MANAGER';";

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
            String nr, nume;
            while (rezult.next()){
                nume = rezult.getString(1);
                nr = rezult.getString(2);
                String[] rand = {nume, nr};
                model.addRow(rand);
            }
            conn.close();

        }catch (SQLException ex){
            System.out.println(ex);
        }}

    private void actualizareCombo(JComboBox<String> model, String coloana) {
        String sql = "select distinct " + coloana + " from angajatii  WHERE rol = 'manager' order by " + coloana + ";";
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
            System.out.println(ex);
            ex.printStackTrace();
        }
    }
}
