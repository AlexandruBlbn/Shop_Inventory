package GUI;

import Admin_Stuff.Generare_User_Manager;
import Auth.Detalii.Auth_Method;
import Auth.Detalii.database_check;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Creare_Manager extends JDialog {
    private JTextField textNume;
    private JTextField textParola;
    private JTextField textNumar;
    private JButton GENEREAZAButton;
    private JPanel panou;
    private JButton INAPOIButton;

    Connection conn = null;
    Statement stn = null;



    private Auth_Method detalii;
    public Creare_Manager(Auth_Method detalii){
        setTitle("GENERARE MANAGER");
        this.detalii = detalii;
        setContentPane(panou);
        setMinimumSize(new Dimension(500, 300));
        setModal(true);
        setLocationRelativeTo(null);
        GENEREAZAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                database_check data = new database_check();
                String nume = textNume.getText();
                String parola = textParola.getText();
                String numar = textNumar.getText();
                Generare_User_Manager generare = new Generare_User_Manager();
                String[] queries = generare.Generare_Manager(nume,parola,numar);
                String query1 = queries[0];
                String query2 = queries[1];
                String query3 = queries[2];
                String query4 = queries[3];
                String query5 = queries[4];

                try{
                    conn = DriverManager.getConnection(data.getUrl(), detalii.getNume(), detalii.getParola());
                    stn = conn.createStatement();
                    stn.executeUpdate(query1);
                    stn.executeUpdate(query2);
                    stn.executeUpdate(query3);
                    stn.executeUpdate(query4);
                    stn.executeUpdate(query5);
                    System.out.println("Efectuare cu succes!");
                }catch (SQLException ex){
                    System.out.println("Eroare!:");
                    System.out.println(ex);
                    ex.printStackTrace();
                }
            }
        });
        INAPOIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ADMIN_mANAGER admin = new ADMIN_mANAGER(detalii);
                admin.setVisible(true);
            }
        });
        setVisible(true);
    }
}
