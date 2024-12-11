import org.example.Smartphone;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JAVAprojectGUI extends JFrame{
    private JLabel titelLabel;
    private JPanel smartphonePanel;
    private JComboBox modellCB;
    private JLabel modellLabel;
    private JLabel farbeLabel;
    private JComboBox farbeCB;
    private JLabel speicherLabel;
    private JComboBox speicherCB;
    private JLabel ramLabel;
    private JComboBox ramCB;
    private JLabel gbLabelS;
    private JLabel gbLabelA;
    private JLabel preisLabel;
    private JTextField preisTF;
    private JButton konfigurierenButton;
    private JTextField gravurTF;
    private JLabel gravurLabel;
    private JButton speichernButton;
    private JLabel intitalenBedingungLabel;
    private JLabel verlaufLabel;
    private JList verlaufList;
    private JLabel euroLabel;
    private JTextField verlaufTF;

    private ArrayList<Smartphone> smartphones = new ArrayList<Smartphone>();
    private String modell, farbe, gravur;
    private int speicher, ram;
    private double preis;

    public JAVAprojectGUI() {
        setTitle("Smartphone-Konfigurator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(480, 145);
        setSize(600, 600);
        setContentPane(smartphonePanel);
        setVisible(true);

        konfigurierenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modell = modellCB.getSelectedItem().toString();
                farbe = farbeCB.getSelectedItem().toString();
                speicher = Integer.parseInt(speicherCB.getSelectedItem().toString());
                ram = Integer.parseInt(ramCB.getSelectedItem().toString());
                gravur = gravurTF.getText();
                preis = Double.parseDouble(preisTF.getText().toString());

                Smartphone a = new Smartphone(modell, farbe, gravur, speicher, ram, preis);
                smartphones.add(a);




                //Versuch Arryliste in Textfeld Verlauf auszugeben, aber Verzweiflung
                verlaufTF.setText(modell + ", " + farbe + ", " + speicher + "GB, " + ram + "GB, " + gravur + ", " + preis + "€");

                for(Smartphone smartphone: smartphones){
                    smartphone.ausgeben();
                    verlaufTF.setText(modell + ", " + farbe + ", " + speicher + "GB, " + ram + "GB, " + gravur + ", " + preis + "€");
                }



            }
        });
    }

    public static void main(String[] args) {
        new JAVAprojectGUI();
    }
}
