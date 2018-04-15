package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Arrays;
import java.util.Random;

public class MainClass extends ApplicationAdapter {

    private static final int BUNNY_COUNT = 12;
    private SpriteBatch batch;
    private Bunny[] bunnies = new Bunny[BUNNY_COUNT];
    private Texture texture;
    private Random random = new Random();
    private float time = 0;
    private BitmapFont bmf;
    private float t = 0;
    @Override
    public void create() {
        batch = new SpriteBatch();
        texture = new Texture("rounder.png");
        bmf = new BitmapFont(Gdx.files.internal("myfont.fnt"), Gdx.files.internal("myfont.png"), false);
        int xx = Gdx.graphics.getWidth();
        int yy = Gdx.graphics.getHeight();
        for (int i = 0; i < BUNNY_COUNT; i++) {
            bunnies[i] = new Bunny(
                    new Vector2(random.nextInt(xx), random.nextInt(yy)),
                    new Vector2((random.nextFloat() - 0.5f) * 5, (random.nextFloat() - 0.5f) * 5));
        }
    }

    @Override
    public void render() {
        update();
        time += 0.8f;
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        //   batch.draw(texture, InputHandler.getMousePosition().x, InputHandler.getMousePosition().y);
        batch.draw(texture, InputHandler.getMousePosition().x - texture.getWidth() / 2, InputHandler.getMousePosition().y - texture.getHeight() / 2,
                texture.getWidth() / 2, texture.getHeight() / 2, texture.getWidth(), texture.getHeight(),
                0.5f, 0.5f, time, 0, 0, texture.getWidth(), texture.getHeight(), false, false);
        Arrays.stream(bunnies).forEach(b -> b.render(batch));
        t+= Gdx.graphics.getDeltaTime();
        bmf.draw(batch, String.valueOf(Math.round(t)), 20,Gdx.graphics.getHeight()-20);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    private void update() {
        Arrays.stream(bunnies).forEach(Bunny::update);
    }

}
