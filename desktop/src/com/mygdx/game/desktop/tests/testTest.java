package com.mygdx.game.desktop.tests;

//import org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.mygdx.game.input.InputHandler;

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
