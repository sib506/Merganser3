package com.mygdx.game.desktop.tests;

import org.junit.Before;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Game;

import junit.framework.TestCase;

public class AssetTestCase extends TestCase {

	protected static Game game;
	private static LwjglApplication app;

	@Before
	public void setUp() {
		
		// use same LwjglApplication window across all AssetTestCase tests
		if (app != null)
			return;
		
		game = new Game();

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Merganser";
		config.height = 270;
		config.width = 480;
		config.resizable = true;
		app = new LwjglApplication(game, config);
		
		// don't run the test until the assetManager has been initialised.
		while (!game.created) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
