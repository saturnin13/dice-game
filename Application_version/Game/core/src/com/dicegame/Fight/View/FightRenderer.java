package com.dicegame.Fight.View;


import com.dicegame.Fight.Model.FightModel;

public class FightRenderer implements Renderer {

    private final FightModel model;
    private final PlayerRenderer player1Renderer;
    private final PlayerRenderer player2Renderer;

    public FightRenderer(FightModel fightModel) {
        this.model = fightModel;
        player1Renderer = new PlayerRenderer(fightModel.getPlayer1());
        player2Renderer = new PlayerRenderer(fightModel.getPlayer2());
    }

    //TODO implement renderer (using helper class)
    //TODO add state to a character
    @Override
    public void render() {
        player1Renderer.render();
        player2Renderer.render();
    }
}
