package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class InputHandler {

    public static boolean isClicked() {
        return Gdx.input.justTouched();
    }

    public static boolean isLeftButtonPressed() {
        return Gdx.input.isButtonPressed(Input.Buttons.LEFT);
    }

    public static boolean isRightButtonPressed(){
       return Gdx.input.isButtonPressed(Input.Buttons.RIGHT);
    }

    public static Vector2 getMousePosition() {
        return new Vector2(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
    }
}
