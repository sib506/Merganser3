package com.mygdx.game.desktop.tests;

import com.mygdx.game.Equipable;
import com.mygdx.game.Equipable.equipType;
import com.mygdx.game.managers.ItemManager;

import junit.framework.TestCase;

public class ItemManagerTest extends TestCase {

	Equipable testEquipment = new Equipable("hammer", "hammer to hit things with", equipType.WEAPON, 4, 2, 1, 4, 2, 1);
	ItemManager testItemManager = new ItemManager();

	public void setUp() {
	
	}

	public void testAddItem() {
		System.out.println(testEquipment.getID());
		testItemManager.addEquipable(testEquipment);
		System.out.println(testEquipment.getID());
		assertEquals(testEquipment, testItemManager.getEquipable(1));
	}

}
