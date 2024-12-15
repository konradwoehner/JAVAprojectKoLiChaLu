import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JTextField textField1;
    private JLabel gravurLabel;
    private JButton speichernButton;
    private JLabel intitalenBedingungLabel;
    private JLabel verlaufLabel;
    private JList verlaufList;

    public JAVAprojectGUI() {
        setTitle("Smartphone-Konfigurator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(450, 220);
        setSize(900, 600);
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
                    case"BApple iPhone16":preis=2000.00;break;
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

            }
        });
    }

    public static void main(String[] args) {
        new JAVAprojectGUI();
    }
}
