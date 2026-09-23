package EinfachesSpiel;

import javax.swing.*;
import java.awt.*;
/**
 * This class contains the Layout for this game.
 * @author Jonas Podlas
 * @version 2026-09-23W
 */
public class Layout extends JPanel{

    private JLabel rundeTitel  = new JLabel("Rundenergebnis:", SwingConstants.CENTER);
    private JLabel gesamtPunkteTitel = new JLabel("Gesamtpunkte:", SwingConstants.CENTER);
    private JLabel zahlEintippen = new JLabel("Tippe eine Zahl von 1 bis 9", SwingConstants.CENTER);
    private JLabel gesamtPunkte = new JLabel("Gesamtpunkte: 30", SwingConstants.CENTER);
    private JLabel deineZahl = new JLabel("Deine Zahl:", SwingConstants.CENTER);
    private JLabel computerZahl = new JLabel("Computer:", SwingConstants.CENTER);
    private JButton nochEinmal = new JButton("Noch einmal!");
    private JTextField du = new JTextField();
    private JTextField computer = new JTextField();
    private Font fontRowTwo = new Font("SanSerif", Font.BOLD, 20);
    private Font fontCenter = new Font("SanSerif", Font.BOLD, 40);

    private JPanel uebersicht = new JPanel(new GridLayout(3,2, 10, 0));
    private JPanel inputMitte = new JPanel(new GridLayout(1, 2, 10 , 0));
    private JPanel buttonUnten = new JPanel(new FlowLayout(FlowLayout.CENTER));

    public Layout(Controller controller) {
        this.setLayout(new BorderLayout());
        uebersicht.add(rundeTitel);
        uebersicht.add(gesamtPunkteTitel);
        zahlEintippen.setOpaque(true);
        zahlEintippen.setBackground(Color.WHITE);
        zahlEintippen.setFont(fontRowTwo);
        uebersicht.add(zahlEintippen);
        gesamtPunkte.setOpaque(true);
        gesamtPunkte.setBackground(Color.WHITE);
        gesamtPunkte.setFont(fontRowTwo);
        uebersicht.add(gesamtPunkte);
        uebersicht.add(deineZahl);
        uebersicht.add(computerZahl);

        this.add(uebersicht, BorderLayout.NORTH);

        du.setFont(fontCenter);
        computer.setFont(fontCenter);
        computer.setEditable(false);
        computer.setBackground(Color.WHITE);
        computer.setHorizontalAlignment(SwingConstants.CENTER);
        du.setHorizontalAlignment(SwingConstants.CENTER);
        inputMitte.add(du);
        inputMitte.add(computer);


        this.add(inputMitte, BorderLayout.CENTER);

        buttonUnten.add(nochEinmal);
        nochEinmal.addActionListener(controller);
        nochEinmal.setActionCommand("again");

        this.add(buttonUnten, BorderLayout.SOUTH);





    }
}
