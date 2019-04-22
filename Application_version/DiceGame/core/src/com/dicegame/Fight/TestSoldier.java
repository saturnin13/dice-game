package com.dicegame.Fight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.dicegame.Fight.Utils.Identification;
import com.dicegame.Fight.Utils.Observable;
//TODO delete
public class TestSoldier extends Actor implements Observable {

    Animation animation;
    float totalTime = 0;

    public TestSoldier() {
        super();
        TextureAtlas textureAtlas = new TextureAtlas(Gdx.files.internal("zoro/new/zoroAtlas.atlas"));
        Array<TextureAtlas.AtlasRegion> textureRegions = textureAtlas.findRegions("zoro");
        animation = new Animation(1f/4f, textureRegions);
        System.out.println(getName());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        totalTime += delta;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(animation.getKeyFrame(totalTime, true), getX(), getY());
    }

    @Override
    public Identification getIdentity() {
        return null;
    }

    @Override
    public void setIdentity(Identification id) {

    }
        /*
        player1Characters = new PlayerCharacterGroup();
        player2Characters = new PlayerCharacterGroup();

        To remove
        player1Characters.setPosition(Constants.SCREEN_WIDTH/2, 0);
        player2Characters.setPosition(Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT - 60);

        addActor(player1Characters);
        addActor(player2Characters);

        TestSoldier soldier11 = new TestSoldier();
        soldier11.setPosition(- Constants.SCREEN_WIDTH/2, 0);
        TestSoldier soldier22 = new TestSoldier();
        soldier22.setPosition(- Constants.SCREEN_WIDTH/2+ Constants.SCREEN_WIDTH/4, 0);
        TestSoldier soldier33 = new TestSoldier();
        soldier33.setPosition(0, 0);
        TestSoldier soldier44 = new TestSoldier();
        soldier44.setPosition(Constants.SCREEN_WIDTH/2 - Constants.SCREEN_WIDTH/4 , 0);
        TestSoldier soldier55 = new TestSoldier();
        soldier55.setPosition(Constants.SCREEN_WIDTH/2-50, 0);

        player2Characters.addActor(soldier11);
        player2Characters.addActor(soldier22);
        player2Characters.addActor(soldier33);
        player2Characters.addActor(soldier44);
        player2Characters.addActor(soldier55);

        TestSoldier soldier1 = new TestSoldier();
        soldier1.setPosition(- Constants.SCREEN_WIDTH/2, 0);
        TestSoldier soldier2 = new TestSoldier();
        soldier2.setPosition(- Constants.SCREEN_WIDTH/2+ Constants.SCREEN_WIDTH/4, 0);
        TestSoldier soldier3 = new TestSoldier();
        soldier3.setPosition(0, 0);
        TestSoldier soldier4 = new TestSoldier();
        soldier4.setPosition(Constants.SCREEN_WIDTH/2 - Constants.SCREEN_WIDTH/4 , 0);
        TestSoldier soldier5 = new TestSoldier();
        soldier5.setPosition(Constants.SCREEN_WIDTH/2-50, 0);

        player1Characters.addActor(soldier1);
        player1Characters.addActor(soldier2);
        player1Characters.addActor(soldier3);
        player1Characters.addActor(soldier4);
        player1Characters.addActor(soldier5);
        */
}
