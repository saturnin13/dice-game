package net.dermetfan.blackpoint2;

import net.dermetfan.blackpoint2.screens.Splash;

import com.badlogic.gdx.Game;

public class Blackpoint2 extends Game {

	public static final String TITLE = "Blackpoint 2", VERSION = "0.0.0.0.reallyEarly";

	@Override
	public void create() {
		setScreen(new Splash());
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

}
