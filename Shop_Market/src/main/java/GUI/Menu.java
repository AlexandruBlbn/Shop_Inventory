package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JDialog {
    private JPanel MenuPanel;
    private JButton bStergere;
    private JButton bVizualizare;
    private JButton bModInventar;
    private JButton bCrUtilizator;
    private JButton bDelogare;
    private JButton bPanel;
    private JButton bInchidere;

    public Menu(){

        setTitle("Meniu principal");
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
        setVisible(true);
    }

    private void inchidere() {
        System.exit(0);
    }

    public static void main(String[] args) {
        Menu MenuPanel = new Menu();
    }
}
