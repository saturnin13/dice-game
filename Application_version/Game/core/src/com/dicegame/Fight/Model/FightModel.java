package com.dicegame.Fight.Model;

import com.dicegame.Fight.Model.Player.PlayerData;
import com.dicegame.Fight.Utils.Constants;

public class FightModel {

    private FightState currentState;

    private PlayerData player1;
    private PlayerData player2;
    public FightModel() {
        currentState = FightState.PLAYER1_IDLE;
        player1 = new PlayerData(Constants.INITIAL_NUMBER_CHARACTER, Constants.PLAYER_1);
        player2 = new PlayerData(Constants.INITIAL_NUMBER_CHARACTER, Constants.PLAYER_2);
    }

    public FightState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(FightState currentState) {
        this.currentState = currentState;
    }

    public PlayerData getPlayer1() {
        return player1;
    }

    public PlayerData getPlayer2() {
        return player2;
    }
}
