package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import static com.mygdx.game.InputHandler.getMousePosition;

public class Bunny {
    private static Texture img = new Texture("MyBunny.png");
  //  private static Texture img = new Texture("rounder.png");

    private static final int IMAGE_SIZE_X = img.getWidth();
    private static final int IMAGE_SIZE_Y = img.getHeight();
    private static int FRAME_X = Gdx.graphics.getWidth();
    private static int FRAME_Y = Gdx.graphics.getHeight();

    private Vector2 position;
    private Vector2 velocity;


    public Bunny(Vector2 position, Vector2 velocity) {
        this.position = position;
        this.velocity = velocity;
    }

    public void update() {
        position.add(velocity);
      //  velocity.scl(0.995f);
        if (position.x > FRAME_X) position.x = -IMAGE_SIZE_X;
        if (position.x < -IMAGE_SIZE_X) position.x = FRAME_X;
        if (position.y > FRAME_Y) position.y = -IMAGE_SIZE_Y;
        if (position.y < -IMAGE_SIZE_Y) position.y = FRAME_Y;

        if (InputHandler.isLeftButtonPressed()){
            if (position.cpy().sub(getMousePosition()).len()<=200){
                velocity = position.cpy().sub(getMousePosition()).nor().scl(-1.0f);
            }

        }

        if (InputHandler.isRightButtonPressed()){
            if (position.cpy().sub(getMousePosition()).len()<=200){
                velocity = position.cpy().sub(getMousePosition()).nor().scl(1.0f);
            }

        }

    }

    public void render(SpriteBatch batch) {


        batch.draw(img, position.x - img.getWidth() / 2, position.y - img.getHeight() / 2,
                img.getWidth() / 2, img.getHeight() / 2, img.getWidth(), img.getHeight(),
                0.5f, 0.5f, 0, 0, 0, img.getWidth(), img.getHeight(), false, false);


    }

}
