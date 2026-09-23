package EinfachesSpiel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    }

    public static void main(String[] args) {
        new Controller();
    }
}
