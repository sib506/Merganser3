package com.mygdx.game.tests;

//import org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input;
//import com.mygdx.game.Game;
import com.mygdx.game.InputHandler;
//import com.mygdx.game.battle.BattleParameters;
//import com.mygdx.game.battle.BattleScreen;

import junit.framework.TestCase;

public class testTest extends TestCase {
	InputHandler testInput;
	Boolean mockInput;
	
	public void setUp(){
		testInput = mock(InputHandler.class);
		mockInput = mock(Boolean.class);
		when(mockInput).thenReturn(true);
	}
	
	public void testTest1(){
		assertTrue(this.mockInput);
	}

}
