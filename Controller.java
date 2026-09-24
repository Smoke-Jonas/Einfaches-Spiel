package EinfachesSpiel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

/**
 * This is the CONTROlLER class.
 * This class is mainly used for combining the VIEW and MODEL.
 * @author Jonas Podlas
 * @version 2026-09-23
 */
public class Controller implements ActionListener {
    private View view;
    private GewinnModel model;

    public Controller() {
        model = new GewinnModel();
        view = new View(this);
    }

    /**
     * This method handles all Actions of the implemented ActionListener.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        // If the enter-key is pressed inside or outside of the text field
        if(command.equals("enter") || command.equals("enterOutside")) {
            if (!view.pruefeEingabe()) { // This checks if the current input is valid ( 1 - 9 )
                return;
            }

            model.berechneComputerZahl(); // Generates a random number the computer plays with, this round
            model.berechneRunde(view.getSpielerZahl()); // Calculates the result of the current round
            view.setStats(model); // Updates the view to showing the current points etc., disables the Text field
        } else if(command.equals("again")) { // If the try again button was pressed

            /*
            * The view updates itself back to only show the current points and not the result of the past round.
            * It also reactivates the text field, but disables the try again button
            */
            view.startGame();

        }
    }

    public static void main(String[] args) {
        new Controller();
    }
}
