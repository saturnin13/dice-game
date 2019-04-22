package main.Action;

import main.game.GameState;
import main.game.OutputProcessing;
import main.util.Constant;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ActionExecution {

    private static int numberOfDiceCombined; //TODO improve

    public static void performAction(char command, GameState gameState) {
            switch (command) {
                case 'r':
                    reRollAction(gameState);
                    break;
                case 'c':
                    combineAction(gameState);
                    break;
            }
    }

    private static boolean canPerformAction(char command, GameState gameState) {
        boolean result = false;
        switch (command) {
            case 'r': result = costOfAction(command) < gameState.getPlaying().numberOfDices();
                break;
            case 'c':
                numberOfDiceCombined = costOfAction(command);
                result = numberOfDiceCombined < gameState.getPlaying().numberOfDices(); //TODO implement correctly
                break;
        }
        if(!result) {
            OutputProcessing.printImpossibilityOfPerformingAction();
        }
        return result;
    }

    private static int costOfAction(char command) {
        switch (command) {
            case 'r': return Constant.COST_ACTION_RE_ROLL;
            case 'c': return numberOfDiceToCombine();
        }
        return -1;
    }

    private static int numberOfDiceToCombine() {
        Scanner reader = new Scanner(System.in);

        while(true) {
            System.out.print("How many dices do you want to combine : ");
            if(reader.hasNextInt()) {
                int value = reader.nextInt();
                if (value > 1) {
                    return value;
                }
            } else {
                reader.next();
            }
        }
    }

    private static void reRollAction(GameState gameState) {
        if(canPerformAction('r', gameState)) {
            gameState.getPlaying().removeAnyDice();
            gameState.getPlaying().rerollAllDices();
        }

    }

    private static void combineAction(GameState gameState) {
        if(!canPerformAction('c', gameState)) {
            return;
        }

        Scanner reader = new Scanner(System.in);
        List<Integer> values = new LinkedList<>();
        int counter = 0;


        while (true) {
            if(counter >= numberOfDiceCombined) {
                break;
            }
            System.out.print("Choose a dice to combine : ");
            if(reader.hasNextInt()) {
                int value = reader.nextInt();
                values.add(value);
                if (gameState.getPlaying().hasAllDice(values)) {
                    values.set(counter, value);
                    counter++;
                } else {
                    values.remove(new Integer(value));
                }
            } else {
                reader.next();
                System.out.println("Incorrect value ");
            }
        }

        for (Integer current : values) {
            gameState.getPlaying().removeDice(current);
        }

        gameState.getPlaying().combineDice(values);
    }
}
