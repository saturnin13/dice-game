package main.game;

import main.Action.ActionExecution;
import main.player.Player;
import main.util.Constant;
import java.util.*;

public class Game {

    private static Game INSTANCE = new Game();
    GameState gameState;
    private GameHistory history = new GameHistory();

    private Game() {
        gameState = new GameState(0, new Player(), new Player());
        history.addStateCopy(gameState);
    }

    public static Game getInstance() {
        return INSTANCE;
    }

    public void start() {
        while(!gameOver()) {
            OutputProcessing.printBoardState(gameState.getCurrentPlayerTurn(), gameState.getPlayer1(), gameState.getPlayer2());
            playTurn();
            nextTurn();// TODO see order of nextTurn and addState if good
            history.addStateCopy(gameState);
            OutputProcessing.printLastTurnAction(history.getLastTurnDifference());
        }

        OutputProcessing.printWinningMessage(gameState);
    }

    private void nextTurn() {
        gameState.nextTurn();
        history.nextTurn();
    }

    private void playTurn() {
        int diceSelected = SelectAttackingDice();
        if(diceSelected != -1) {
            int diceDefending = selectDefenceDice(diceSelected);
            gameState.getPlaying().attackOtherPlayer(diceSelected, diceDefending, gameState.getNotPlaying());// TODO get value of new dices for printing
        } else {
            skipTurn();
        }
    }

    private void skipTurn() {
        System.out.println("Turn skipped");
    }

    private int SelectAttackingDice() {
        Scanner reader = new Scanner(System.in);
        Set<Integer> validValues = validValuesToAttack();

        while(true) {
            System.out.print("Choose one of your dice to use : ");
            if(reader.hasNextInt()) {
                int result = reader.nextInt();
                if (validValues.contains(result)) {
                    return result;
                }
            }
            else {
                ActionExecution.performAction(reader.next().charAt(0), gameState);
                validValues = validValuesToAttack();
            }
            if(validValues.isEmpty()) {
                return -1;
            }
            OutputProcessing.printBoardState(gameState.getCurrentPlayerTurn(), gameState.getPlayer1(), gameState.getPlayer2());
        }

    }

    private Set<Integer> validValuesToAttack() {
        Set<Integer> values = new HashSet<>();
        for (int i = 0; i <= Constant.DICE_MAXIMUM_NUMBER_OF_FACE; i++) {
            if(gameState.getPlaying().validDiceToPlay(i) && gameState.getNotPlaying().getMinimumDiceValue() <= i) {
                values.add(i);
            }
        }
        return values;
    }

    private int selectDefenceDice(int attacking) {
        Scanner reader = new Scanner(System.in);
        Set<Integer> validValues = validValuesToDefend(attacking);

        while(true) {
            System.out.print("Choose one of opponent dice to attack : ");
            if (reader.hasNextInt()) {
                int result = reader.nextInt();
                if (validValues.contains(result)) {
                    return result;
                }
            }
            else {
                reader.next();
            }
            if(validValues.isEmpty()) {
                return -1;
            }
            OutputProcessing.printBoardState(gameState.getCurrentPlayerTurn(), gameState.getPlayer1(), gameState.getPlayer2());
        }
    }

    private Set<Integer> validValuesToDefend(int attacking) {
        Set<Integer> values = new HashSet<>();
        for (int i = 0; i <= Constant.DICE_MAXIMUM_NUMBER_OF_FACE; i++) {
            if(gameState.getNotPlaying().validDiceToDefend(attacking, i)) {
                values.add(i);
            }
        }
        return values;
    }

    private boolean gameOver() {
        return gameState.getPlaying().hasLost() || gameState.getNotPlaying().hasLost();
    }

}