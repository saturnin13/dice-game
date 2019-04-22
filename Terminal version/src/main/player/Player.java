package main.player;

import main.dice.Dice;
import main.dice.DiceBatch;
import main.dice.NormalDice;
import main.game.StateDifference;
import main.util.Constant;

import java.util.List;
import java.util.TreeSet;

public class Player implements Cloneable {

    private DiceBatch dices;

    public Player() {
        dices = new DiceBatch(Constant.GAME_NUMBER_OF_DICE);
    }

    public Player(DiceBatch dices) {
        this.dices = dices;
    }

    // Put all the variable of the object in this constructor
    public Player clonePlayer() {
        return new Player(dices.cloneDiceBatch());
    }

    public void rerollAllDices() {
        dices.rerollAllDices();
    }

    public Dice rollSingleDice(int value) {
        return dices.rollSingleDice(value);
    }

    public Dice removeDice(int value){
        return dices.removeDice(value);
    }

    public void setAllDices(TreeSet<Dice> newDices) {
        dices.setAllDices(newDices);
    }

    @Override
    public String toString() {
        return dices.toString();
    }

    public void attackOtherPlayer(int diceUsed, int diceAttacked, Player attacked) throws RuntimeException{
        if(diceUsed == diceAttacked) {
            attacked.rollSingleDiceWithModifier(diceAttacked, -1);
            rollSingleDice(diceUsed);
        } else if (diceUsed > diceAttacked){
            rollSingleDice(diceUsed);
            attacked.removeDice(diceAttacked);
        } else {
            throw new RuntimeException();
        }
    }

    private void rollSingleDiceWithModifier(int diceAttacked, int modifier) {
        dices.rollSingleDiceWithModifier(diceAttacked, modifier);
    }

    public boolean validDiceToPlay(int value) {
        return dices.hasDice(value) && validValue(value);
    }

    public boolean validDiceToDefend(int attacking, int attacked) {
        return attacking >= attacked && dices.hasDice(attacked) && validValue(attacked);
    }

    private boolean validValue(int value) {
        return value > 0 && value <= Constant.DICE_MAXIMUM_NUMBER_OF_FACE;
    }

    public boolean hasLost() {
        return dices.size() == 0;
    }

    public int getMinimumDiceValue() {
        return dices.getMinimum();
    }

    public void removeAnyDice() {
        dices.removeAnyDice();
    }

    public void reRollAction() {
        if (dices.size() > 1) {
            dices.removeAnyDice();
            dices.rerollAllDices();
        }
    }

    public void initialiseDifference(StateDifference difference, Player oldPlayer) {
        difference.setLostDice(getLostDices(oldPlayer));
        difference.setNewDice(getNewDices(oldPlayer));
    }

    private List<Dice> getLostDices (Player oldPlayer) {
        return dices.getLostDices(oldPlayer.dices);
    }

    private List<Dice> getNewDices (Player oldPlayer) {
        return dices.getNewDices(oldPlayer.dices);
    }

    public int numberOfDices() {
        return dices.size();
    }

    public boolean hasDice(int value) {
        return dices.hasDice(value);
    }

    public boolean hasAllDice(List<Integer> diceList) {
        DiceBatch temp = dices.cloneDiceBatch();
        for (Integer current : diceList) {
            if(!temp.hasDice(current)) {
                return false;
            }
            temp.removeDice(current);
        }
        return true;
    }

    // TODO implement correctly
    public void combineDice(List<Integer> values) {
        dices.addDice(new NormalDice(1));//TODO replace 1 by constant can be any value of a dice
        dices.rollSingleDiceWithModifier(1, values.size() - 1);
    }
}







