package EinfachesSpiel;

import javax.swing.*;
import java.awt.*;
/**
 * This is the VIEW class.
 * This class is mainly used for the graphical view of this game
 * @author Jonas Podlas
 * @version 2026-09-16
 */

public class View extends JFrame {

    private Layout layout; // This is the layout for this game
    public View(Controller controller) {
        super("Einfaches Spiel"); // Sets a new title for the Game-Windows
        layout = new Layout(controller);
        this.add(layout); // Adds the layout to the current Frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack(); // Sets the minimum size for the window to show every component
        this.setVisible(true); // Shows the Frame
    }

    /**
     * This is a method to set different elements after clicking the try again button.
     * It only leaves the total result, makes the text field editable again and disables the button.
     */
    public void startGame() {
        layout.getRundenergebnisLabel().setForeground(Color.BLACK);
        layout.getRundenergebnisLabel().setBackground(Color.WHITE);
        layout.getGesamtpunkteLabel().setBackground(Color.WHITE);
        layout.getRundenergebnisLabel().setText("Tippe eine Zahl von 1 bis 9");

        layout.getUserInput().setText(""); // Deletes the last user input
        layout.getUserInput().setEditable(true); // Sets the text field editable

        layout.getComputerOutput().setText(""); // Deletes the last computer input

        layout.getNochEinmalButton().setEnabled(false); // Disables the try again button
    }

    /**
     * This method puts the different stats, points, results in the different labels and fields after each round.
     * @param stats delivers the model, so the method can read the current statistics.
     */
    public void setStats(GewinnModel stats) {

        // Puts the result of the current round in the label for it (can be + or -)
        if (stats.getRundenErgebnis() > 0) {
            layout.getRundenergebnisLabel().setText("+" + stats.getRundenErgebnis());
        } else {
            layout.getRundenergebnisLabel().setText("" + stats.getRundenErgebnis());
        }

        layout.getComputerOutput().setText("" + stats.getComputerZahl()); // Puts the current randomized number in the text field
        layout.getGesamtpunkteLabel().setText("" + stats.getGesamtPunkte()); // Puts the total points in the defined label

        /*
         * If the player won this round or won the entire game the labels with the statistics will turn green.
         */
        if (stats.getRundenErgebnis() > 0 || stats.hatGewonnen()) {
            layout.getRundenergebnisLabel().setBackground(Color.GREEN);
            layout.getGesamtpunkteLabel().setBackground(Color.GREEN);

        } else if (stats.getRundenErgebnis() < 0 || stats.hatVerloren()) { // Otherwise it will turn red
            layout.getRundenergebnisLabel().setBackground(Color.RED);
            layout.getGesamtpunkteLabel().setBackground(Color.RED);

        } else { // Or white at first
            layout.getRundenergebnisLabel().setBackground(Color.WHITE);
            layout.getGesamtpunkteLabel().setBackground(Color.WHITE);
        }


        layout.getUserInput().setEditable(false); // The text field is now disabled

        // If the player has lost or won it will show in the statistics label and disables every input field.
        if (stats.hatVerloren()) {
            layout.getRundenergebnisLabel().setText("Verloren");
            layout.getNochEinmalButton().setEnabled(false);

        } else if (stats.hatGewonnen()) {
            layout.getRundenergebnisLabel().setText("Gewonnen");
            layout.getNochEinmalButton().setEnabled(false);

        } else {
            layout.getNochEinmalButton().setEnabled(true); // Otherwise the try again is enabled to play the next round
        }
    }

    /**
     * This method is used for checking if the current input is a number and in the range of 1 to 9.
     * @return a boolean value if the input is valid
     */
    public boolean pruefeEingabe() {
        try {
            int zahl = Integer.parseInt(layout.getUserInput().getText());

            // Shows error if the number is out of range
            if(zahl < 1 || zahl > 9) {
                layout.getRundenergebnisLabel().setForeground(Color.RED);
                layout.getRundenergebnisLabel().setBackground(Color.WHITE);
                layout.getRundenergebnisLabel().setText("Ungültige Eingabe !");
                return false;
            }

            // Otherwise the number is valid
            layout.getRundenergebnisLabel().setForeground(Color.BLACK);
            return true;

        }catch (NumberFormatException ex) {
            layout.getRundenergebnisLabel().setForeground(Color.RED);
            layout.getRundenergebnisLabel().setBackground(Color.WHITE);
            layout.getRundenergebnisLabel().setText("Ungültige Eingabe !");
            return false;
        }
    }

    /**
     * This method returns the current input number as and int-value to read in the controller
     * @return the current user input
     */
    public int getSpielerZahl() {
        return Integer.parseInt(layout.getUserInput().getText());
    }





}
