package main.dice;

import main.util.Constant;
import java.util.Random;

public class NormalDice implements Comparable, Dice {

    private int value;
    private Random rand;

    public NormalDice() {
        rand = new Random();
        value = createRandomDiceValue();
    }

    public NormalDice(Dice currentDice) {
        rand = new Random();
        value = currentDice.getValue();
    }

    public NormalDice(int value) {
        rand = new Random();
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int roll() {
        value = createRandomDiceValue();
        return value;
    }

    public void setValue(int newValue) {
        value = newValue;
    }

    private int createRandomDiceValue() {
        return rand.nextInt(Constant.DICE_MAXIMUM_NUMBER_OF_FACE) + 1;
    }

    @Override
    public int compareTo(Object o) {
        if(getValue() > ((NormalDice) o).getValue()) {
            return 1;
        } else if(getValue() == ((NormalDice) o).getValue()) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public int maxValue() {
        return Constant.DICE_MAXIMUM_NUMBER_OF_FACE;
    }

    @Override
    public int minValue() {
        return Constant.DICE_MINIMUM_NUMBER_OF_FACE;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object other){
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof NormalDice)) {
            return false;
        }
        NormalDice otherNormalDice = (NormalDice) other;
        return getValue() == otherNormalDice.getValue();
    }

}
