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
    private JButton alleKonfigurationenButton;

    protected ArrayList<Smartphone> smartphones = new ArrayList<Smartphone>();
    protected String modell, farbe, gravur;
    protected int speicher, ram;
    protected double preis;

    public JAVAprojectGUI() {
        setTitle("Smartphone-Konfigurator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(480, 145);
        setSize(800, 800);
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

        konfigurierenButton.addActionListener(new ActionListener() {
            public void pruefe(){
                try{
                    String gravur = gravurTF.getText();
                    if (gravur.length()>2){
                        throw new IllegalArgumentException();
                    }

                }catch (IllegalArgumentException e1){
                    JOptionPane.showMessageDialog(null,"Bitte gültige Gravur eingeben","Fehlermeldung",JOptionPane.ERROR_MESSAGE);
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Falsche Eingabe","Fehlermeldung",JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                preis =0.0;

                modell= modellCB.getSelectedItem().toString();
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

                pruefe();
                preisTF.setText(""+preis);
                speichernButton.setEnabled(true);
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
                for (int i = 0; i < smartphones.size(); i++) {
                    Smartphone smartphone = smartphones.get(i);  // Smartphone an Index i holen
                    verlaufTA.append(smartphone.ausgeben() + "\n");
                }
                speichernButton.setEnabled(false);
            }
        });
        preisAbRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                smartphones.sort(Comparator.comparingDouble(Smartphone::getPreis).reversed());
                verlaufTA.setText("");  // Textfeld zurücksetzen, um die alte Ausgabe zu löschen
                for (int i = 0; i < smartphones.size(); i++) {
                    Smartphone smartphone = smartphones.get(i);  // Smartphone an Index i holen
                    verlaufTA.append(smartphone.ausgeben() + "\n");
                }

            }


        });
        preisAufRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                smartphones.sort(Comparator.comparingDouble(Smartphone::getPreis));
                verlaufTA.setText("");  // Textfeld zurücksetzen, um die alte Ausgabe zu löschen
                for (int i = 0; i < smartphones.size(); i++) {
                    Smartphone smartphone = smartphones.get(i);  // Smartphone an Index i holen
                    verlaufTA.append(smartphone.ausgeben() + "\n");
                }

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
        alleKonfigurationenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verlaufTA.setText("");  // Textfeld zurücksetzen, um die alte Ausgabe zu löschen
                gruppierungPreis.clearSelection();
                gruppierungFarbe.clearSelection();

                for (int i = 0; i < smartphones.size(); i++) {
                    Smartphone smartphone = smartphones.get(i);  // Smartphone an Index i holen
                    verlaufTA.append(smartphone.ausgeben() + "\n");
                }

            }
        });
    }

    public static void main(String[] args) {
        new JAVAprojectGUI();






    }
}