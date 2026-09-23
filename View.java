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
        super("Einfaches Spiel");
        layout = new Layout(controller);
        this.add(layout);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public void startGame() {
        layout.getRundenergebnisLabel().setForeground(Color.BLACK);
        layout.getRundenergebnisLabel().setText("Tippe eine Zahl von 1 bis 9");

        layout.getUserInput().setText("");
        layout.getUserInput().setEditable(true);

        layout.getComputerOutput().setText("");

        layout.getNochEinmalButton().setEnabled(false);
    }
    public void setStats(GewinnModel stats) {

        if (stats.getRundenErgebnis() > 0) {
            layout.getRundenergebnisLabel().setText("+" + stats.getRundenErgebnis());
        } else {
            layout.getRundenergebnisLabel().setText("" + stats.getRundenErgebnis());
        }

        layout.getComputerOutput().setText("" + stats.getComputerZahl());
        layout.getGesamtpunkteLabel().setText("" + stats.getGesamtPunkte());

        if (stats.getRundenErgebnis() > 0 || stats.hatGewonnen()) {
            layout.getRundenergebnisLabel().setBackground(Color.GREEN);
            layout.getGesamtpunkteLabel().setBackground(Color.GREEN);

        } else if (stats.getRundenErgebnis() < 0 || stats.hatVerloren()) {
            layout.getRundenergebnisLabel().setBackground(Color.RED);
            layout.getGesamtpunkteLabel().setBackground(Color.RED);

        } else {
            layout.getRundenergebnisLabel().setBackground(Color.WHITE);
            layout.getGesamtpunkteLabel().setBackground(Color.WHITE);
        }


        layout.getUserInput().setEditable(false);

        if (stats.hatVerloren()) {
            layout.getRundenergebnisLabel().setText("Verloren");
            layout.getNochEinmalButton().setEnabled(false);

        } else if (stats.hatGewonnen()) {
            layout.getRundenergebnisLabel().setText("Gewonnen");
            layout.getNochEinmalButton().setEnabled(false);

        } else {
            layout.getNochEinmalButton().setEnabled(true);
        }
    }

    public boolean pruefeEingabe() {
        try {
            int zahl = Integer.parseInt(layout.getUserInput().getText());

            if(zahl < 1 || zahl > 9) {
                layout.getRundenergebnisLabel().setForeground(Color.RED);
                layout.getRundenergebnisLabel().setBackground(Color.WHITE);
                layout.getRundenergebnisLabel().setText("Ungültige Eingabe !");
                return false;
            }

            layout.getRundenergebnisLabel().setForeground(Color.BLACK);
            return true;

        }catch (NumberFormatException ex) {
            layout.getRundenergebnisLabel().setForeground(Color.RED);
            layout.getRundenergebnisLabel().setBackground(Color.WHITE);
            layout.getRundenergebnisLabel().setText("Ungültige Eingabe !");
            return false;
        }
    }

    public int getSpielerZahl() {
        return Integer.parseInt(layout.getUserInput().getText());
    }





}
