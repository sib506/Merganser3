package com.mygdx.game.desktop.tests;

public class AssetCreationTests extends AssetTestCase {

	public void setUp() {
		super.setUp();
	}

	public void testInit() {
		assertTrue(game.created);
	}

}