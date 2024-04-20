package GUI;


import Auth.Detalii.Auth_Method;
import Auth.Detalii.database_check;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.function.BiPredicate;


public class LOGIN extends JDialog {
    private JTextField fNume;
    private JPasswordField fParola;
    private JButton bLogare;
    private JButton bIesire;
    private JPanel LoginPanel;
    private Auth_Method detalii;

    public LOGIN(JFrame parent) {
        super(parent);
        setTitle("Logare");
        setContentPane(LoginPanel);
        setMinimumSize(new Dimension(450, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        detalii = new Auth_Method();
        bLogare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = fNume.getText();
                String parola = String.valueOf(fParola.getPassword());
                Boolean verif = logare(user, parola);
                if(verif == true){
                    inchidere();
                }
                else {
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
        Menu meniu = new Menu();
        meniu.setVisible(true);
    }
////////////////

    public Boolean valoare;
    private Boolean logare(String user, String parola) {
        Boolean valoare;
        Auth_Method nume = null;
        database_check log = new database_check();
        valoare = log.Conexiune_Verificare(log.getUrl(), user, parola);
        return valoare;
    }

    public static void main(String[] args) {
        LOGIN loginForm = new LOGIN(null);
//        Boolean valoare1 = loginForm.valoare;
//        if(valoare1 != null){
//            System.out.println("Logare cu succes");
//        }
//        else {
//            System.out.println("Logare intrerupta!");
//        }
    }


}


