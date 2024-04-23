package GUI;

import Auth.Detalii.Auth_Method;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ADMIN extends JDialog {
    private JButton CONTROLMANAGERButton;
    private JPanel AdminPanel;
    private JButton acasaButton;
    private JButton stergereAngajatButton;
    private Auth_Method detalii;

    public ADMIN(Auth_Method detalii) {
        this.detalii = detalii;
        setTitle("Meniu principal");
        setContentPane(AdminPanel);
        setMinimumSize(new Dimension(700, 500));
        setModal(true);
        setLocationRelativeTo(null);
        acasaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acasa();
            }
        });
        CONTROLMANAGERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void acasa() {
        dispose();
        Menu meniu = new Menu(detalii);
        meniu.setVisible(true);
    }


    //DE INTRODUS TABEL CU LOGURI
    public static void main(String[] args) {
        ADMIN panou = new ADMIN(null);
    }
}
