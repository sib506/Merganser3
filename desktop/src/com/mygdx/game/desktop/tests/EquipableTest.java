package com.mygdx.game.desktop.tests;

import com.mygdx.game.Equipable;
import com.mygdx.game.Equipable.equipType;

import junit.framework.TestCase;

public class EquipableTest extends TestCase {
	
	Equipable testEquipment;
	
	public void setUp(){
		testEquipment = new Equipable("hammer", "hammer to hit things with", equipType.WEAPON, 4, 2, 1, 4, 2, 1);
	}
	
	public void testModifiers(){
		int[] expectedModifiers = {4,2,1,4,2,1};
		int[] actualModifiers = testEquipment.getModifiers();
		
		for (int i = 0; i<expectedModifiers.length - 1; i++){
			assertEquals(expectedModifiers[i], actualModifiers[i]);
		}
	}
	
	
	
}
