package com.dicegame.Fight.Model.Player;

public class PlayerData {

    private CharacterContainer characters;
    private int playerPosition;

    public PlayerData(int initialNumber, int playerPosition) {
        characters = new CharacterBatch(initialNumber);
        this.playerPosition = playerPosition;
    }
}
