package com.dicegame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dicegame.Fight.FightStage;
import com.dicegame.Fight.Utils.Constants;

// TODO re arrange files when test done and basic done
// TODO verifier orthographe, indentation, nom des variable, magic number, private application, comment, use of interface...
// TODO create ci
// TODO basic sketch of project
// TODO find sprite (can split existing using downloaded program (in game making) and then create a sprite using the tool in gdx library (gdx-tool)
// TODO create a TODO list (Trello)
public class DiceGame extends Game {
    private FightStage fightStage;
    private StretchViewport viewport;
    private OrthographicCamera camera;

	@Override
	public void create () {
        camera = new OrthographicCamera();

        viewport = new StretchViewport(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, camera);
        fightStage = new FightStage(viewport);
	}

	@Override
	public void render () {
        super.render();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        fightStage.act(Gdx.graphics.getDeltaTime());
        fightStage.draw();
	}

    @Override
    public void resize(int width, int height){
        super.resize(width, height);
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        super.dispose();
        fightStage.dispose();
    }
}
