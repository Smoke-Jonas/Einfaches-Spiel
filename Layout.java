package EinfachesSpiel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * This class contains the Layout for this game.
 * @author Jonas Podlas
 * @version 2026-09-23W
 */
public class Layout extends JPanel{

    // ALl the important attributes for the layout
    private JLabel rundeTitel  = new JLabel("Rundenergebnis:", SwingConstants.CENTER);
    private JLabel gesamtPunkteTitel = new JLabel("Gesamtpunkte:", SwingConstants.CENTER);
    private JLabel zahlEintippen = new JLabel("Tippe eine Zahl von 1 bis 9", SwingConstants.CENTER);
    private JLabel gesamtPunkte = new JLabel("Gesamtpunkte: 30", SwingConstants.CENTER);
    private JLabel deineZahl = new JLabel("Deine Zahl:", SwingConstants.CENTER);
    private JLabel computerZahl = new JLabel("Computer:", SwingConstants.CENTER);
    private JButton nochEinmal = new JButton("Noch einmal!");
    private JTextField userInput = new JTextField();
    private JTextField computerInput = new JTextField();
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

        userInput.setFont(fontCenter);
        computerInput.setFont(fontCenter);
        computerInput.setEditable(false);
        computerInput.setBackground(Color.WHITE);
        computerInput.setHorizontalAlignment(SwingConstants.CENTER);
        userInput.setHorizontalAlignment(SwingConstants.CENTER);
        userInput.addActionListener(controller);
        userInput.setActionCommand("enter"); // If ENTER is pressed inside of the input field this command will show in the actionListener
        // How to receive and ActionCommand if the ENTER key is pressed outside of the input field
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( // Wenn im aktuellen Fenster
                KeyStroke.getKeyStroke("ENTER"), // Die ENTER Taste gedrückt wird
                "enterOutside" // wird diese mit dem Begriff "enterOutside" verbunden
        );
        this.getActionMap().put("enterOutside", new AbstractAction() {  // Wenn die ENTER Taste gedrückt wird
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.actionPerformed( // Wird dem controller ein neues ActionEvent
                        new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "enterOutside") // mit dem "enterOuside" ActioCommand weitergeleitet
                );
            }
        });
        inputMitte.add(userInput);
        inputMitte.add(computerInput);


        this.add(inputMitte, BorderLayout.CENTER);

        buttonUnten.add(nochEinmal);
        nochEinmal.addActionListener(controller);
        nochEinmal.setActionCommand("again");

        this.add(buttonUnten, BorderLayout.SOUTH);
    }

    // These are all the important getter Methods for the View class
    public JLabel getRundenergebnisLabel() { return this.zahlEintippen;}
    public JLabel getGesamtpunkteLabel() { return this.gesamtPunkte;}
    public JTextField getUserInput() { return this.userInput; }

    public JTextField getComputerOutput() { return this.computerInput;}
    public JButton getNochEinmalButton() { return this.nochEinmal;}
}
