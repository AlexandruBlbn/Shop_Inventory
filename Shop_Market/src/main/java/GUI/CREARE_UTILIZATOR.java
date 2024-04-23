package GUI;

import Admin_Stuff.Generare_User_Angajat;
import Auth.Detalii.Auth_Method;
import Auth.Detalii.database_check;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;

public class CREARE_UTILIZATOR extends JDialog {
    private JTextField textMag;
    private JTextField textNume;
    private JTextField textParola;
    private JButton generareButton;
    private JPanel panou;
    private JButton acasaButton;

    Connection conn = null;
    Statement stn = null;

    private Auth_Method detalii;
    public CREARE_UTILIZATOR(Auth_Method detalii) {
        this.detalii = detalii;
        setTitle("Meniu introducere");
        setContentPane(panou);
        setMinimumSize(new Dimension(700, 500));
        setModal(true);
        setLocationRelativeTo(null);

        generareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generareUser();
            }
        });

        acasaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Menu menu = new Menu(null);
                menu.setVisible(true);
            }
        });
        setVisible(true);
    }

    private void generareUser() {
         String nume = textNume.getText();
         String parola = textParola.getText();
         String numar = textMag.getText();
        Generare_User_Angajat generare = new Generare_User_Angajat();
        String[] queries = generare.Generare_Angajat(nume, parola, numar);
        String creare = queries[0];
        String inserare = queries[1];
        String atribuire = queries[2];
        System.out.println(creare);
        System.out.println(inserare);

         database_check data = new database_check();
         try{
             conn = DriverManager.getConnection(data.getUrl(), detalii.getNume(), detalii.getParola());
             stn = conn.createStatement();
             stn.executeUpdate(creare);
             stn.executeUpdate(inserare);
             stn.executeUpdate(atribuire);

             System.out.println("Efectuat cu succes!");
             conn.close();
         }catch (SQLException ex){
             System.out.println("Eroare!");
             System.out.println(ex);
         }
    }
}
