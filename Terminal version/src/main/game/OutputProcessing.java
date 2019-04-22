package main.game;

import main.player.Player;

public class OutputProcessing {

    public static void printBoardState(int currentPlayerTurn, Player player1, Player player2) {
        if(currentPlayerTurn == 0) {
            System.out.println("\u001B[34m");
        } else {
            System.out.println("\u001B[35m");
        }

        System.out.println(
                "\n-------------------------------------------------------------------------------" +
                        "\n" + "\u001B[34m" + "Player 1 : " + player1 +
                        "\n" +
                        "\n" + "\u001B[35m" + "Player 2 : " + player2
        );

        if(currentPlayerTurn == 0) {
            System.out.println("\u001B[34m");
        } else {
            System.out.println("\u001B[35m");
        }

        if(currentPlayerTurn == 0) {
            System.out.println("---------------------------------Player 1 turn---------------------------------");
        } else {
            System.out.println("---------------------------------Player 2 turn---------------------------------");
        }
    }

    //public static void printLastTurnAction(int currentPlayerTurn, int diceAttacked, int diceDefending) {
    public static void printLastTurnAction(StateDifference difference) {
        System.out.print(
                "\nplayer 1 lost " +
                        difference.getPlayer1LostDice() +
                        " and got " + difference.getPlayer1NewDice());

        System.out.print(
                "\nplayer 2 lost " +
                        difference.getPlayer2LostDice() +
                        " and got " + difference.getPlayer2NewDice());
    }

    public static void printWinningMessage(GameState gameState) {
        System.out.print("\n!!!!!!!!!!!!!!!!!! Winner is ");
        if (gameState.getPlayer1().hasLost()) {
            System.out.println("player 2, player 1 is a big loser !!!!!!!!!!!!!!!!!!");
        } else {
            System.out.println("player 1, player 2 is a big loser !!!!!!!!!!!!!!!!!!");
        }
    }

    public static void printImpossibilityOfPerformingAction() {
        System.out.println("\nCould not perform action");
    }
}
