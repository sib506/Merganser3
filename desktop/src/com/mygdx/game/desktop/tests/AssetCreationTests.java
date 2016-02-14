package com.mygdx.game.desktop.tests;

public class AssetCreationTests extends AssetTestCase {

	public void setUp() {
		super.setUp();
	}

	// Tests whether assets successfully finished loading
	public void testAssetInit() {
		assertTrue(game.created);
	}

}