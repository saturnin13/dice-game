package main.game;

import main.Action.PlayerAction;

import java.util.LinkedList;

public class TurnActions {

    private LinkedList<PlayerAction> actions = new LinkedList<>();

    public TurnActions () {

    }

    public void add(PlayerAction newAction) {
        actions.add(newAction);
    }
}
