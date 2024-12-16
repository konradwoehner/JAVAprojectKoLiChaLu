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

                double preis =0.0;

                String modell= modellCB.getSelectedItem().toString();
                switch (modell){
                    case"Apple iPhone14":preis =800.00;break;
                    case"Apple iPhone15":preis=1000.00;break;
                    case"Apple iPhone16":preis=2000.00;break;
                    case"Samsung Galaxy S23":preis=799.99;break;
                    case"Samsung Galaxy S24":preis=1299.99;break;
                    case"Samsung Galaxy S24 Ultra":preis =2200.00;break;
                    case"Samsung Galaxy Z Flip":preis=1000.00;break;
                    case"Google Pixel 7":preis=499.99;break;
                    case"Google Pixel 8":preis=600.00;break;
                    case"Google Pixel 9 Pro":preis=1150.00;break;
                    case"Huawei P30 Lite":preis=1960.00;break;
                    case"Huawei Pura 70 Ultra":preis=2499.99;break;
                }

                String speicher= speicherCB.getSelectedItem().toString();
                switch (speicher) {
                    case"32":preis=preis+0.00;break;
                    case"64":preis=preis+100.00;break;
                    case"128":preis=preis+200.00;break;
                    case"256":preis=preis+400.00;break;
                    case"512":preis=preis+800.00;break;
                    case"1024":preis=preis+1600.00;break;
                }

                String ram= ramCB.getSelectedItem().toString();
                switch (ram) {
                    case"4":preis=preis+0.00;break;
                    case"6":preis=preis+50.00;break;
                    case"8":preis=preis+120.00;break;

                }

                preisTF.setText("Ihr Preis: "+ preis+"€");

            }
        });

// test push
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
