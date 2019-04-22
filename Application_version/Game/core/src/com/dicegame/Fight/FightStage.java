package com.dicegame.Fight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dicegame.Fight.Controller.Controller;
import com.dicegame.Fight.Controller.FightController;
import com.dicegame.Fight.Model.FightModel;
import com.dicegame.Fight.View.FightRenderer;
import com.dicegame.Fight.View.Renderer;

public class FightStage extends Stage {

    private final Controller controller;
    private final FightModel model;
    private final Renderer renderer;

    public FightStage(Viewport viewport) {
        super(viewport);
        model = new FightModel();
        renderer = new FightRenderer(model);
        controller = new FightController(model);

        Gdx.input.setInputProcessor(controller);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        controller.update(delta);
    }

    @Override
    public void draw() {
        super.draw();
        renderer.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
