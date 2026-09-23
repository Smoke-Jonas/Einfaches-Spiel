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

    private Layout layout;
    public View(Controller controller) {
        layout = new Layout(controller);
        super("Einfaches Spiel");
        this.add(layout);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
