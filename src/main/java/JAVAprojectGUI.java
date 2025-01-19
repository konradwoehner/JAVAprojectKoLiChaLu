import org.example.Smartphone;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

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
    private JTextArea verlaufTA;
    private JRadioButton preisAbRB;
    private JRadioButton preisAufRB;
    private JRadioButton blauRB;
    private JRadioButton goldRB;
    private JRadioButton weißRB;
    private JRadioButton schwarzRB;
    private JButton filterZurücksetzenButton;

    protected ArrayList<Smartphone> smartphones = new ArrayList<>();
    protected String modell, farbe, gravur;
    protected int speicher, ram;
    protected double preis;

    //Methoden
    public void initObjekte(){
        Smartphone i1 = new Smartphone("Apple iPhone14", "schwarz", "CU", 1024, 8, 2519.99);
        smartphones.add(i1);
        Smartphone i2 = new Smartphone("Google Pixel 9 Pro", "blau", "LH", 256, 8, 1669.99);
        smartphones.add(i2);
        Smartphone i3 = new Smartphone("Apple iPhone16", "schwarz", "KW", 512, 6, 2849.99);
        smartphones.add(i3);
    }


    public void schleifeausgeben(){
        for (int i = 0; i < smartphones.size(); i++) {
            Smartphone smartphone = smartphones.get(i);  // Smartphone an Index i holen
            verlaufTA.append(smartphone.ausgeben() + "\n");
        }
    }

    public double berechnen(String modell, String speicher, String ram){

        switch (modell){
            case"Apple iPhone14":preis =799.99;break;
            case"Apple iPhone15":preis=999.99;break;
            case"Apple iPhone16":preis=1999.99;break;
            case"Samsung Galaxy S23":preis=799.99;break;
            case"Samsung Galaxy S24":preis=1299.99;break;
            case"Samsung Galaxy S24 Ultra":preis =2199.99;break;
            case"Samsung Galaxy Z Flip":preis=999.99;break;
            case"Google Pixel 7":preis=499.99;break;
            case"Google Pixel 8":preis=599.99;break;
            case"Google Pixel 9 Pro":preis=1149.99;break;
            case"Huawei P30 Lite":preis=1959.99;break;
            case"Huawei Pura 70 Ultra":preis=2499.99;break;
        }

        switch (speicher) {
            case"32":preis=preis+0.00;break;
            case"64":preis=preis+100.00;break;
            case"128":preis=preis+200.00;break;
            case"256":preis=preis+400.00;break;
            case"512":preis=preis+800.00;break;
            case"1024":preis=preis+1600.00;break;
        }

        switch (ram) {
            case"4":preis=preis+0.00;break;
            case"6":preis=preis+50.00;break;
            case"8":preis=preis+120.00;break;
        }

        return preis;
    }


    //GUI-Aufbau
    public JAVAprojectGUI() {
        setTitle("Smartphone-Konfigurator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(425, 80);
        setSize(700, 650);
        setContentPane(smartphonePanel);
        setVisible(true);

        //Man kann nur einen RadioButton auswählen
        ButtonGroup gruppierungPreis = new ButtonGroup();
        gruppierungPreis.add(preisAufRB);
        gruppierungPreis.add(preisAbRB);

        ButtonGroup gruppierungFarbe = new ButtonGroup();
        gruppierungFarbe.add(schwarzRB);
        gruppierungFarbe.add(weißRB);
        gruppierungFarbe.add(goldRB);
        gruppierungFarbe.add(blauRB);

        //Methodenaufruf
        initObjekte();
        schleifeausgeben();

        //Buttons
        konfigurierenButton.addActionListener(new ActionListener() {
            public void pruefe(){
                try{
                    String gravur = gravurTF.getText();
                    if (gravur.length()>2){
                        speichernButton.setEnabled(false);
                        throw new IllegalArgumentException();
                    }

                }catch (IllegalArgumentException e1){
                    JOptionPane.showMessageDialog(null,"Bitte gültige Gravur eingeben","Fehlermeldung",JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                preis =0.0;
                berechnen(modellCB.getSelectedItem().toString(), speicherCB.getSelectedItem().toString(), ramCB.getSelectedItem().toString());
                speichernButton.setEnabled(true);
                pruefe();
                preisTF.setText(""+preis);
            }
        });

        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Eingabewerte aus den Formularfeldern
                modell = modellCB.getSelectedItem().toString();
                farbe = farbeCB.getSelectedItem().toString();
                speicher = Integer.parseInt(speicherCB.getSelectedItem().toString());
                ram = Integer.parseInt(ramCB.getSelectedItem().toString());
                gravur = gravurTF.getText();
                preis = Double.parseDouble(preisTF.getText());

                // Neues Smartphone erstellen und zur Liste hinzufügen
                Smartphone a = new Smartphone(modell, farbe, gravur, speicher, ram, preis);
                smartphones.add(a);

                // Alle Smartphones durchgehen und im Textfeld ausgeben
                verlaufTA.setText("");  // Textfeld zurücksetzen, um die alte Ausgabe zu löschen
                schleifeausgeben();
                speichernButton.setEnabled(false);
            }
        });

        preisAbRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                smartphones.sort(Comparator.comparingDouble(Smartphone::getPreis).reversed()); // Inhaltliche Hilfestellung durch Julia Hosch (Tutorium)
                verlaufTA.setText("");  // Textfeld zurücksetzen, um die alte Ausgabe zu löschen
                schleifeausgeben();
            }
        });

        preisAufRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                smartphones.sort(Comparator.comparingDouble(Smartphone::getPreis));
                verlaufTA.setText("");  // Textfeld zurücksetzen, um die alte Ausgabe zu löschen
                schleifeausgeben();
            }
        });

        schwarzRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verlaufTA.setText("");
                farbe = farbeCB.getSelectedItem().toString();
                for (int i = 0; i < smartphones.size(); i++) {
                    Smartphone aktuell = smartphones.get(i);
                    if(aktuell.getFarbe().equals("schwarz")){ // Nur schwarze Smartphones ausgeben
                        verlaufTA.append(aktuell.ausgeben() + "\n");
                    }
                }
            }
        });

        weißRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verlaufTA.setText("");
                farbe = farbeCB.getSelectedItem().toString();
                for (int i = 0; i < smartphones.size(); i++) {
                    Smartphone aktuell = smartphones.get(i);
                    if(aktuell.getFarbe().equals("weiß")){ // Nur weiße Smartphones ausgeben
                        verlaufTA.append(aktuell.ausgeben() + "\n");
                    }
                }
            }
        });

        goldRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verlaufTA.setText("");
                farbe = farbeCB.getSelectedItem().toString();
                for (int i = 0; i < smartphones.size(); i++) {
                    Smartphone aktuell = smartphones.get(i);
                    if(aktuell.getFarbe().equals("gold")){ // Nur goldene Smartphones ausgeben
                        verlaufTA.append(aktuell.ausgeben() + "\n");
                    }
                }

            }
        });

        blauRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verlaufTA.setText("");
                farbe = farbeCB.getSelectedItem().toString();
                for (int i = 0; i < smartphones.size(); i++) {
                    Smartphone aktuell = smartphones.get(i);
                    if(aktuell.getFarbe().equals("blau")){ // Nur blaue Smartphones ausgeben
                        verlaufTA.append(aktuell.ausgeben() + "\n");
                    }
                }

            }
        });

        filterZurücksetzenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verlaufTA.setText("");  // Textfeld zurücksetzen, um die alte Ausgabe zu löschen
                gruppierungFarbe.clearSelection(); // Hilfestellung durch Chat GPT

                schleifeausgeben();
            }
        });
    }

    //main-Methode zum Programmstart
    public static void main(String[] args) {
        new JAVAprojectGUI();
    }
}