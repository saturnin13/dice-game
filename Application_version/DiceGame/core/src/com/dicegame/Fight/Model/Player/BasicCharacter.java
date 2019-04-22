package com.dicegame.Fight.Model.Player;

import com.dicegame.Fight.Utils.Constants;

import java.util.Random;

public class BasicCharacter implements Character {

    private int value;
    private Random rand;

    public BasicCharacter() {
        rand = new Random();
        roll();
    }

    @Override
    public int roll() {
        int range = Constants.BASIC_CHARACTER_MAXIMUM_VALUE - Constants.BASIC_CHARACTER_MINIMUM_VALUE + 1;
        value = rand.nextInt(range) + Constants.BASIC_CHARACTER_MINIMUM_VALUE;
        return value;
    }
}


