package GUI;

import Auth.Detalii.Auth_Method;
import Auth.Detalii.database_check;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DeleteUser extends JDialog {
    private JTextField textNume;
    private JTextField textMagazin;
    private JButton STERGEREButton;
    private JButton INAPOIButton;
    private JPanel panou;

    Connection conn  = null;
    Statement stn = null;


    private Auth_Method detalii;

public DeleteUser(Auth_Method detalii){
         this.detalii = detalii;
    setTitle("ADMIN PANEL");
    setContentPane(panou);
    setMinimumSize(new Dimension(400, 400));
    setModal(true);
    setLocationRelativeTo(null);


    INAPOIButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            ADMIN admin = new ADMIN(detalii);
            admin.setVisible(true);
        }
    });
    STERGEREButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nume = textNume.getText();
            String numar = textMagazin.getText();
            String query = "DROP USER '" + nume + "'@'localhost';";
            String query1 = "DELETE  FROM ANGAJATII WHERE NUME = '" + nume + "' AND ID_Magazin = " + numar + " AND ROL = 'angajat_';";
            database_check data = new database_check();
            try{
                conn = DriverManager.getConnection(data.getUrl(), detalii.getNume(), detalii.getParola());
                stn = conn.createStatement();
                stn.executeUpdate(query);
                stn.executeUpdate(query1);
                System.out.println("Executie efectuata cu succes!");
            }catch (SQLException ex){
                System.out.println("EROARE!");
                System.out.println(ex);

            }
        }
    });

    setVisible(true);
}}
