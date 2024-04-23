package GUI;

import Auth.Detalii.Auth_Method;
import Auth.Detalii.database_check;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LOGIN extends JDialog {
    private JTextField fNume;
    private JPasswordField fParola;
    private JButton bLogare;
    private JButton bIesire;
    private JPanel LoginPanel;

    private Auth_Method detalii;

    public LOGIN(JFrame parent) {
        super(parent);
        detalii = new Auth_Method();
        setTitle("Logare");
        setContentPane(LoginPanel);
        setMinimumSize(new Dimension(450, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        bLogare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = fNume.getText();
                String parola = String.valueOf(fParola.getPassword());
                detalii.setNume(user);
                detalii.setParola(parola);
                Boolean verif = logare(user, parola);
                if (verif) {
                    System.out.println("Logare reusita pe numele: " + detalii.getNume());
                    inchidere();
                } else {
                    JOptionPane.showMessageDialog(LOGIN.this, "Nume sau parola incorecta!", "Eroare", JOptionPane.ERROR_MESSAGE);
                    System.out.println("*******\nESUARE CONECTARE\n*******");
                    System.out.println("\n DATE INTRODUSE: \n USER: " + user + "\n PAROLA: " + parola);
                }
            }
        });
        bIesire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("\n ************************* \n OPERATIUNE DE INCHIDERE \n ************************* ");
                System.exit(0);
            }
        });
        setVisible(true);
    }

    private void inchidere() {
        dispose();
        Menu meniu = new Menu(detalii);
        meniu.setVisible(true);
    }

    private Boolean logare(String user, String parola) {
        database_check log = new database_check();
        return log.Conexiune_Verificare(log.getUrl(), user, parola);
    }

    public static void main(String[] args) {
        LOGIN loginForm = new LOGIN(null);
    }
}
