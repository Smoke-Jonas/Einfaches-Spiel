package EinfachesSpiel;

/**
 * This is the MODEL class.
 * This class is mainly used for algorythms and the code in the background.
 * @author Jonas Podlas
 * @version 2026-09-21
 */
public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel() {
        this.gesamtPunkte = 30; // Players start with 30 points in advance
    }

    /**
     * Getter-Method for the current points the player has achieved.
     * @return the current points
     */
    public int getGesamtPunkte() {
        return this.gesamtPunkte;
    }

    /**
     * Getter-Method for the random number the computer chooses at the current round.
     * @return the current number of the computer
     */
    public int getComputerZahl() {
        return this.computerZahl;
    }

    /**
     * Getter-Method for the outcume of the current round.
     * @return points the player has won or lost
     */
    public int getRundenErgebnis() {
        return rundenErgebnis;
    }

    public void berechneComputerZahl() {

    }

    public void berechneRunde(int spielerZahl) {

    }

    /**
     * This method determines if the player has won the game.
     * @return true if the player has more than 100 points, false if he hasn't yet
     */
    public boolean hatGewonnen() {
        if(gesamtPunkte > 100) {
            return true;
        }
        return false;
    }

    /**
     * This method determines if the player has lost the game.
     * @return true if the player has less than 0 points, false if he hasn't yet
     */
    public boolean hatVerloren() {
        if(gesamtPunkte < 0) {
            return true;
        }
        return false;
    }
}
