package main.game;

import java.util.LinkedList;

public class GameTurn {

    private LinkedList<GameState> gameStates = new LinkedList<>();

    public GameTurn () {}

    public StateDifference getDifferenceFrom(GameTurn oldTurn) {
        return gameStates.getFirst().getDifferenceFrom(oldTurn.getFirstGameState());
    }

    public GameState getFirstGameState() {
        return gameStates.getFirst();
    }

    public void addGameState(GameState newState) {
        gameStates.add(newState);
    }
}
