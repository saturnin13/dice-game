package main.game;

        import java.util.LinkedList;

public class GameHistory {

    private LinkedList<GameTurn> gameEvolution;
    private GameTurn currentTurn;

    public GameHistory() {
        currentTurn = new GameTurn();
        gameEvolution = new LinkedList<>();
        gameEvolution.add(currentTurn);
    }

    public void addStateCopy(GameState stateToCopy) {
        currentTurn.addGameState(stateToCopy.cloneState());
    }

    public void nextTurn() {
        currentTurn = new GameTurn();
        gameEvolution.add(currentTurn);
    }

    public StateDifference getLastTurnDifference () {
        return gameEvolution.getLast().getDifferenceFrom(getSecondLastElement());
    }

    private GameTurn getSecondLastElement() {
        return gameEvolution.get(gameEvolution.size() - 2);
    }
}
