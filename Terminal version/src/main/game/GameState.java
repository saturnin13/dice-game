package main.game;

import main.Action.PlayerAction;
import main.player.Player;
import main.util.Constant;

public class GameState {

    private int currentPlayerTurn;
    private Player player1;
    private Player player2;
    private PlayerAction lastAction;

    public GameState(int currentPlayerTurn, Player player1, Player player2) {
        this.player1 = player1.clonePlayer();
        this.player2 = player2.clonePlayer();
        this.currentPlayerTurn = currentPlayerTurn;
    }

    public StateDifference getDifferenceFrom(GameState oldState) {
        return new StateDifference(this, oldState);
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void nextTurn() {
        currentPlayerTurn = (currentPlayerTurn + 1) % Constant.NUMBER_OF_PLAYERS;
    }

    public Player getPlaying() {
        if (currentPlayerTurn == 0) {
            return player1;
        } else {
            return player2;
        }
    }

    public Player getNotPlaying() {
        if (currentPlayerTurn == 1) {
            return player1;
        } else {
            return player2;
        }
    }

    public int getCurrentPlayerTurn() {
        return currentPlayerTurn;
    }

    // Put all the variable of the object in this constructor
    public GameState cloneState() {
        GameState result = new GameState(currentPlayerTurn, player1.clonePlayer(), player2.clonePlayer()); //TODO modifier les clonePlayer, cloneGameState, CloneBatchDice en constructeur avec les element en parametre
        //result.setLastAction(lastAction.cloneAction()); //TODO implement
        return result;
    }

    public void setLastAction(PlayerAction lastAction) {
        this.lastAction = lastAction;
    }
}
