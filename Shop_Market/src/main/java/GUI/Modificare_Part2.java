package GUI;

import Auth.Detalii.Auth_Method;
import Queries.Query_Update_Inv_2;
import Queries.Query_Update_Inv_ACT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;

public class Modificare_Part2 extends JDialog {
    private JPanel panou;

    Connection conn = null;
    Statement stn = null;
    ResultSet rezult = null;
    private JTextField textMagazin;
    private JTextField textTip;
    private JTextField textFel;
    private JTextField textBrand;
    private JTextField textPropietate;
    private JTextField textCantitate;
    private JTextField textOras;
    private JButton Anulare;
    private JButton Actualizeaza;

    private Auth_Method detalii;
    private Valori values;

    public Modificare_Part2(Auth_Method detalii, Valori values) {
        this.detalii = detalii;
        this.values = values;
        setTitle("Meniu modificare");
        setContentPane(panou);
        textMagazin.setText(values.getMagaz());
        textTip.setText(values.getTip_prod());
        textFel.setText(values.getFel_());
        textBrand.setText(values.getBrand_());
        textPropietate.setText(values.getPropietate());
        textCantitate.setText(values.getCantitate());
        textOras.setText(values.getOras_());
        setMinimumSize(new Dimension(650, 400));
        setModal(true);
        setLocationRelativeTo(null);
        Anulare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Menu meniu = new Menu(detalii);
                meniu.setVisible(true);
            }
        });
        Actualizeaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Query_Update_Inv_ACT select = new Query_Update_Inv_ACT();
                StringBuilder builder = new StringBuilder();
                String Tip = textTip.getText();
                String FelArticol = textFel.getText();
                String Brand = textBrand.getText();
                String Proprietate = textPropietate.getText();
                String Oras = textOras.getText();
                String cantitate = textCantitate.getText();
                String magazin = textMagazin.getText();

                select.Constructor(builder, magazin , Tip, FelArticol, Brand, Proprietate, cantitate,  Oras);
                String query = builder.toString();
                String Query_Final = "UPDATE inventar " + query + values.getQuery_Cond() + ";";
                System.out.println(Query_Final);
                int confirmare = JOptionPane.showConfirmDialog(null, "Ești sigur că vrei să faci această actualizare?", "Confirmare", JOptionPane.YES_NO_OPTION);
                if(confirmare == JOptionPane.YES_OPTION){
                    try{
                        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database_shop", detalii.getNume(), detalii.getParola());
                        stn = conn.createStatement();
                        stn.executeUpdate(Query_Final);
                        System.out.println("Executie efectuata cu succes!");
                        conn.close();
                        dispose();
                        Menu meniu = new Menu(detalii);
                        meniu.setVisible(true);
                    }catch (SQLException ex){
                        System.out.println("Eroare de executie!");
                        System.out.println(ex);
                    }
                }
                else {
                    System.out.println("Anulare actualizare date");
                }


            }
        });
        panou.setVisible(true);
    }

    public static void main(String[] args) {
        Auth_Method detalii = new Auth_Method();
        Valori mods = new Valori();
        Modificare_Part2 mod = new Modificare_Part2(detalii, mods);
    }
}
