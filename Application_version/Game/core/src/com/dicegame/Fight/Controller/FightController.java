package com.dicegame.Fight.Controller;

import com.dicegame.Fight.Model.FightModel;
import com.dicegame.Fight.Utils.Observable;

//TODO implement controller basics
public class FightController implements Controller{

    public FightController(FightModel model) {
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public boolean notifyKeyDown(int keycode) {
        return false;
    }

    @Override
    public boolean notifyKeyUp(Observable observed, int keycode) {
        return false;
    }

    @Override
    public boolean notifyKeyTyped(Observable observed, char character) {
        return false;
    }

    @Override
    public boolean notifyTouchDown(Observable observed, int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean notifyTouchUp(Observable observed, int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean notifyTouchDragged(Observable observed, int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean notifyMouseMoved(Observable observed, int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean notifyScrolled(Observable observed, int amount) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
