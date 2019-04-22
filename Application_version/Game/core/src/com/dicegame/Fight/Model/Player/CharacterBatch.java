package com.dicegame.Fight.Model.Player;

import java.util.LinkedList;
import java.util.List;

public class CharacterBatch implements CharacterContainer {

    private List<Character> characterList = new LinkedList<>();

    public CharacterBatch(int initialNumber) {
        for (int i = 0; i < initialNumber; i++) {
            characterList.add(new BasicCharacter());
        }
    }
}
