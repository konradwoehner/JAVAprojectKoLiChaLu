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
