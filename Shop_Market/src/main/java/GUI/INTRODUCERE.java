package GUI;

import Auth.Detalii.Auth_Method;
import Auth.Detalii.database_check;
import Queries.Query_Insert_Inv;
import com.mysql.cj.xdevapi.InsertStatement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class INTRODUCERE extends JDialog {

    Connection conn = null;
    Statement stn = null;
    ResultSet rzt = null;


    private JTextField mag;
    private JTextField tip;
    private JTextField fel;
    private JButton anulare;
    private JButton intro;
    private JTextField brand;
    private JTextField propietate;
    private JTextField cantitate;
    private JTextField oras;
    private JPanel introducere;

    private Auth_Method detalii;
    public INTRODUCERE(Auth_Method detalii){
        this.detalii = detalii;
        setTitle("Meniu introducere");
        setContentPane(introducere);
        setMinimumSize(new Dimension(700, 500));
        setModal(true);
        setLocationRelativeTo(null);
        intro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder queryBuilder = new StringBuilder();
                String magazin = mag.getText();
                String tip_ = tip.getText();
                String fel_ = fel.getText();
                String brand_ = brand.getText();
                String prop = propietate.getText();
                String cant = cantitate.getText();
                String oras_ = oras.getText();

                Query_Insert_Inv cons = new Query_Insert_Inv();
                cons.Constructor(queryBuilder, magazin, tip_, fel_, brand_, prop, cant, oras_);
                String query = queryBuilder.toString();
                try{
                    database_check data = new database_check();
                    conn = DriverManager.getConnection(data.getUrl(), detalii.getNume(), detalii.getParola());
                            stn = conn.createStatement();
                    stn.executeUpdate(query);
                    System.out.println("Introducere efectuata cu succes!");
                    conn.close();
                    dispose();
                    Menu meniu = new Menu(detalii);
                    meniu.setVisible(true);

                }catch (SQLException ex){
                    System.out.println("Eroare de introducere: ");
                    System.out.println(ex);
                }
            }
        });

        anulare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Menu meniu = new Menu(detalii);
                meniu.setVisible(true);
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        Auth_Method detalii = new Auth_Method();
        INTRODUCERE panou = new INTRODUCERE(detalii);
    }
}
