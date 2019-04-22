package main.game;

import main.dice.Dice;
import java.util.LinkedList;
import java.util.List;

public class StateDifference {

    private boolean initializingPlayer1 = true;
    private List<Dice> player1LostDice = new LinkedList<>();
    private List<Dice> player2LostDice = new LinkedList<>();
    private List<Dice> player1NewDice = new LinkedList<>();
    private List<Dice> player2NewDice = new LinkedList<>();

    public StateDifference(GameState newState, GameState oldState) {
        newState.getPlayer1().initialiseDifference(this, oldState.getPlayer1());
        initializingPlayer1 = false;
        newState.getPlayer2().initialiseDifference(this, oldState.getPlayer2());
    }

    public boolean player1HasLostDice () {
        return player1LostDice.isEmpty();
    }

    public boolean player2HasLostDice () {
        return player2LostDice.isEmpty();
    }

    public boolean player1HasNewDice () {
        return player1NewDice.isEmpty();
    }

    public boolean player2HasNewDice () {
        return player2NewDice.isEmpty();
    }

    public List<Dice> getPlayer1LostDice() {
        return player1LostDice;
    }

    public List<Dice> getPlayer2LostDice() {
        return player2LostDice;
    }

    public List<Dice> getPlayer1NewDice() {
        return player1NewDice;
    }

    public List<Dice> getPlayer2NewDice() {
        return player2NewDice;
    }

    public void setLostDice(List<Dice> lostDice) {
        if (initializingPlayer1) {
            player1LostDice = lostDice;
        } else {
            player2LostDice = lostDice;
        }
    }

    public void setNewDice(List<Dice> newDice) {
        if (initializingPlayer1) {
            player1NewDice = newDice;
        } else {
            player2NewDice = newDice;
        }
    }
}
