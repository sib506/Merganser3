package com.mygdx.game.tests;

import static org.mockito.Mockito.mock;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Level;
import com.mygdx.game.characters.SallyNPC;

import junit.framework.TestCase;

public class CharacterTest extends TestCase{
	
	SallyNPC testCharacter;
	Level testLevel;
	
	public void setUp(){
		testLevel = mock(Level.class);
		testCharacter = new SallyNPC(testLevel, new Vector2(0, 0));
		};
	
	public void testC1(){
//		testCharacter.action(gameWorld);
		
	}

}
