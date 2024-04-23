package GUI;

import Auth.Detalii.Auth_Method;
import Auth.Detalii.database_check;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;

public class Menu extends JDialog {

    private JPanel MenuPanel;
    private JButton bStergere;
    private JButton bVizualizare;
    private JButton bModInventar;
    private JButton bCrUtilizator;
    private JButton bDelogare;
    private JButton bPanel;
    private JButton bInchidere;
    private JButton bIntroducere;
    private Auth_Method detalii;
    Connection conn = null;
    Statement stn = null;
    ResultSet rzt = null;
    public Menu(Auth_Method detalii) {
        setTitle("Meniu principal");
        this.detalii = detalii;
        setContentPane(MenuPanel);
        setMinimumSize(new Dimension(700, 500));
        setModal(true);
        setLocationRelativeTo(null);

        bInchidere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("\n ************************* \n OPERATIUNE DE INCHIDERE \n ************************* ");
                inchidere();
            }
        });

        bDelogare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delogare();
            }
        });

        bPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accesarePanou();
            }
        });

        bVizualizare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VIZUALIZARE vizual = new VIZUALIZARE(detalii);
            }
        });

        bModInventar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarePanou();
            }
        });
        
        bIntroducere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                introducerePanou();
            }
        });
        bStergere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stergerePanou();
            }
        });

        bCrUtilizator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creareUtilizator();
            }
        });

        setVisible(true);
    }

    private void creareUtilizator() {
        database_check date = new database_check();
        String query = "SELECT rol FROM ANGAJATII WHERE NUME = '" + detalii.getNume() + "';";
        try{
            conn = DriverManager.getConnection(date.getUrl(), detalii.getNume(), detalii.getParola());
            stn = conn.createStatement();
            rzt = stn.executeQuery(query);
            String rol = "Manager";
            while (rzt.next()){
                String valoareRol = rzt.getString("rol");
                if (valoareRol.equalsIgnoreCase(rol)) {
                    dispose();
                    CREARE_UTILIZATOR creare = new CREARE_UTILIZATOR(detalii);
                    creare.setVisible(true);
                }
            }
        } catch (
                SQLException ex){
            System.out.println(ex);
            System.out.println("DREPTURI INSUFICIENTE");

        }
    }

    private void stergerePanou() {
        database_check date = new database_check();
        String query = "SELECT rol FROM ANGAJATII WHERE NUME = '" + detalii.getNume() + "';";
        try{
            conn = DriverManager.getConnection(date.getUrl(), detalii.getNume(), detalii.getParola());
            stn = conn.createStatement();
            rzt = stn.executeQuery(query);
            String rol = "Manager";
            while (rzt.next()){
                String valoareRol = rzt.getString("rol");
                if (valoareRol.equalsIgnoreCase(rol)) {
                    dispose();
                    STERGERE stergere = new STERGERE (detalii);
                    stergere.setVisible(true);
                }
            }
        } catch (
                SQLException ex){
            System.out.println(ex);
            System.out.println("DREPTURI INSUFICIENTE");

        }
    }

    private void introducerePanou() {
            database_check date = new database_check();
    String query = "SELECT rol FROM ANGAJATII WHERE NUME = '" + detalii.getNume() + "';";
        try{
        conn = DriverManager.getConnection(date.getUrl(), detalii.getNume(), detalii.getParola());
        stn = conn.createStatement();
        rzt = stn.executeQuery(query);
        String rol = "Manager";
        while (rzt.next()){
            String valoareRol = rzt.getString("rol");
            if (valoareRol.equalsIgnoreCase(rol)) {
                dispose();
                INTRODUCERE introducere = new INTRODUCERE(detalii);
                introducere.setVisible(true);
            }
        }
    } catch (
    SQLException ex){
        System.out.println(ex);
        System.out.println("DREPTURI INSUFICIENTE");

    }
    }

    private void modificarePanou() {
        database_check date = new database_check();
        String query = "SELECT rol FROM ANGAJATII WHERE NUME = '" + detalii.getNume() + "';";
        try{
            conn = DriverManager.getConnection(date.getUrl(), detalii.getNume(), detalii.getParola());
            stn = conn.createStatement();
            rzt = stn.executeQuery(query);
            String rol = "Manager";
            while (rzt.next()){
                String valoareRol = rzt.getString("rol");
                if (valoareRol.equalsIgnoreCase(rol)) {
                    dispose();
                    Modificare modificare = new Modificare(detalii);
                    modificare.setVisible(true);
                }
            }
        } catch (
                SQLException ex){
            System.out.println(ex);
            System.out.println("DREPTURI INSUFICIENTE");

        }

    }

    private void accesarePanou() {
        database_check date = new database_check();
        String query = "SELECT * FROM ANGAJATII;";
        try{
            conn = DriverManager.getConnection(date.getUrl(), detalii.getNume(), detalii.getParola());
            stn = conn.createStatement();
            rzt = stn.executeQuery(query);
            dispose();
            ADMIN admin = new ADMIN(detalii);
            admin.setVisible(true);
        } catch (
                SQLException ex){
            System.out.println(ex);
            System.out.println("DREPTURI INSUFICIENTE");
        }
    }

    private void delogare() {
        int rezultat = JOptionPane.showConfirmDialog(this, "Doresti sa te deloghezi?", "Confirmare", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rezultat == JOptionPane.YES_OPTION) {
            System.out.println("\n ************************* \n DELOGARE \n ************************* ");
            dispose();
            LOGIN logare = new LOGIN(null);
            logare.setVisible(true);
        }
    }

    private void inchidere() {
        System.exit(0);
    }

    public static void main(String[] args) {
        Auth_Method detalii = new Auth_Method();
        Menu MenuPanel = new Menu(detalii);
    }
}
