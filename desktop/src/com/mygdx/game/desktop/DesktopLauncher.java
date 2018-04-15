package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MainClass;

public class DesktopLauncher {
	public static final int FRAME_X = 800;
	public static final int FRAME_Y = 600;
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = FRAME_X;
		config.height = FRAME_Y;
		new LwjglApplication(new MainClass(), config);
	}
}
