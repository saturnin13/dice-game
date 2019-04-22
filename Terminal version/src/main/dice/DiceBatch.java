package main.dice;

import com.sun.javafx.collections.transformation.SortedList;
import org.junit.Assert;

import java.util.*;

public class DiceBatch {

    private List<Dice> dices = new LinkedList<>();

    public DiceBatch(int numberOfDice) {
        for (int i = 0; i < numberOfDice; i++) {
            addDice(new NormalDice());
        }
    }

    public DiceBatch(List<Dice> dices) {
        this.dices = dices;
    }

    public DiceBatch cloneDiceBatch() {
        DiceBatch result;
        LinkedList<Dice> newList = new LinkedList<>();
        for (Dice currentDice : dices) {
            newList.add(new NormalDice(currentDice));
        }
        result = new DiceBatch(newList);
        return result;
    }

    public void rerollAllDices() {
        for (Dice currentDice : dices) {
            roll(currentDice);
        }
    }

    public Dice rollSingleDice(int value) {
        Dice correctDice = getDice(value);
        if(correctDice != null){
            roll(correctDice);
            sort();
            return correctDice;
        }
        return null;
    }

    private void roll(Dice dice) {
        dice.roll();
        sort();
    }

    private Dice getDice(int value) {
        for (Dice current : dices) {
            if (current.getValue() == value) {
                return current;
            }
        }
        return null;
    }
    
    public int size() {
        return dices.size();
    }

    public boolean hasDice(int value) {
        return getDice(value) != null;
    }

    public Dice removeDice(int value){
        Dice correctDice = getDice(value);
        if(correctDice != null){
            dices.remove(correctDice);
            sort();
            return correctDice;
        }
        return null;
    }

    public void addDice(Dice dice){
        dices.add(dice);
        sort();
    }

    private void sort() {
        Collections.sort(dices);
    }

    public void setAllDices(TreeSet<Dice> newDices) {
        dices.clear();
        dices.addAll(newDices);
    }

    @Override
    public String toString() {
        String dices = "";

        for (Dice currentDice : this.dices) {
            dices = dices + currentDice.getValue() + "  ";
        }

        return dices;
    }

    public int getMinimum() {
        return dices.get(0).getValue();
    }

    public void removeAnyDice() {
        removeDice(getMinimum());
    }

    public void rollSingleDiceWithModifier(int dice, int modifier) {
        Dice modifiedDice = rollSingleDice(dice);
        int newDiceValue = modifiedDice.getValue() + modifier;
        if (newDiceValue <= modifiedDice.minValue()) {
            removeDice(modifiedDice.getValue());
            return;
        } else if (newDiceValue > modifiedDice.maxValue()) {
            newDiceValue = modifiedDice.maxValue();
        }
        modifiedDice.setValue(newDiceValue);
        sort();
    }

    public List<Dice> getLostDices(DiceBatch oldDices) {
        List<Dice> result = new LinkedList<>();
        List<Dice> temp = new LinkedList<>(dices);
        for (Dice current : oldDices.dices) {
            if(temp.contains(current)) {
                temp.remove(current);
            } else  {
                result.add(current);
            }
        }
        return result;
    }

    public List<Dice> getNewDices(DiceBatch oldDices) {
        List<Dice> temp = new LinkedList<>(dices);
        for (Dice current : oldDices.dices) {
            if(temp.contains(current)) {
                temp.remove(current);
            }
        }
        return temp;
    }
}
