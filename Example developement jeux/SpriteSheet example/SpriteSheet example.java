package com.gamefromscratch;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpritesheetDemo extends ApplicationAdapter implements InputProcessor {
   SpriteBatch batch;
   TextureAtlas textureAtlas;
   Sprite sprite;
   TextureRegion textureRegion;
   int currentFrame = 1;
   int MAX_FRAMES = 19;

   @Override
   public void create () {
      batch = new SpriteBatch();
      textureAtlas = new TextureAtlas(Gdx.files.internal("ss.txt"));
      textureRegion = textureAtlas.findRegion("0001");
      sprite = new Sprite(textureRegion);
      sprite.setPosition(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2,
            Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);

      Gdx.input.setInputProcessor(this);
   }

   @Override
   public void render () {
      Gdx.gl.glClearColor(0, 0, 0, 1);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      batch.begin();
      sprite.draw(batch);
      batch.end();
   }

   @Override
   public boolean keyDown(int keycode) {
      if(keycode == Input.Keys.UP){
         currentFrame++;
         if(currentFrame > MAX_FRAMES)
            currentFrame = 1;
         sprite.setRegion(textureAtlas.findRegion(String.format("%04d",currentFrame)));
      }
      if(keycode == Input.Keys.DOWN){
         currentFrame--;
         if(currentFrame < 1)
            currentFrame = MAX_FRAMES;

         sprite.setRegion(textureAtlas.findRegion(String.format("%04d",currentFrame)));
      }
      return true;
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
