package main.dice;

public interface Dice extends Comparable {

    int getValue();

    int roll();

    void setValue(int newValue);

    @Override
    int compareTo(Object other);

    int maxValue();

    int minValue();

    @Override
    String toString();

    @Override
    boolean equals(Object other);
}
