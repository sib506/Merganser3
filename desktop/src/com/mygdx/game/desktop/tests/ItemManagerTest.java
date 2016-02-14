package com.mygdx.game.desktop.tests;

import com.mygdx.game.Consumable;
import com.mygdx.game.Equipable;
import com.mygdx.game.Consumable.consumeType;
import com.mygdx.game.Equipable.equipType;
import com.mygdx.game.managers.ItemManager;

public class ItemManagerTest extends AssetTestCase {

	Equipable testEquipment = new Equipable("hammer", "hammer to hit things with", equipType.WEAPON, 4, 2, 1, 4, 2, 1);
	Consumable testConsumable = new Consumable("testConsumable", "This is a test", consumeType.HEAL, 20);
	ItemManager testItemManager = new ItemManager();

	public void setUp() {
		super.setUp();
	}

	// Tests that equipment is added correctly and equipment ID updated
	public void testAddEquipment() {
		System.out.println(testEquipment.getID());
		testItemManager.addEquipable(testEquipment);
		System.out.println(testEquipment.getID());
		assertEquals(testEquipment, testItemManager.getEquipable(1));
		assertEquals(1, testEquipment.getID());
	}
	
	// Tests that consumable is added correctly and consumable ID updated
	public void testAddConsumable(){
		testItemManager.addConsumable(testConsumable);
		assertEquals(testConsumable, testItemManager.getConsumable(testItemManager.getConsumables().size()-1));
		assertEquals(testItemManager.getConsumables().size(), testConsumable.getID());
	}

}
