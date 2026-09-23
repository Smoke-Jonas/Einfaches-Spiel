package EinfachesSpiel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

/**
 * This is the CONTROlLER class.
 * This class is mainly used for combining the VIEW and MODEL.
 */
public class Controller implements ActionListener {
    private View view;
    private GewinnModel model;

    public Controller() {
        model = new GewinnModel();
        view = new View(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("enter") || command.equals("enterOutside")) {
            if (!view.pruefeEingabe()) {
                return;
            }

            model.berechneComputerZahl();
            model.berechneRunde(view.getSpielerZahl());
            view.setStats(model);
        } else if(command.equals("again")) {

            view.startGame();
        }
    }

    public static void main(String[] args) {
        new Controller();
    }
}
