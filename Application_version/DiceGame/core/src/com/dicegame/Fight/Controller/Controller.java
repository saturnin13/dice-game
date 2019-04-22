package com.dicegame.Fight.Controller;


import com.badlogic.gdx.InputProcessor;
import com.dicegame.Fight.Utils.Observable;

public interface Controller extends InputProcessor {

    public void update(float delta);

    public boolean notifyKeyDown(int keycode);

    public boolean notifyKeyUp(Observable observed, int keycode);

    public boolean notifyKeyTyped(Observable observed, char character);

    public boolean notifyTouchDown(Observable observed, int screenX, int screenY, int pointer, int button);

    public boolean notifyTouchUp(Observable observed, int screenX, int screenY, int pointer, int button);

    public boolean notifyTouchDragged(Observable observed, int screenX, int screenY, int pointer);

    public boolean notifyMouseMoved(Observable observed, int screenX, int screenY);

    public boolean notifyScrolled(Observable observed, int amount);
}
