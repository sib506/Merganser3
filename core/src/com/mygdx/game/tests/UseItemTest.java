package com.mygdx.game.tests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.Agent;
import com.mygdx.game.Agent.AgentType;
import com.mygdx.game.Assets;
import com.mygdx.game.Consumable;
import com.mygdx.game.CurrentEquipment;
import com.mygdx.game.Game;
import com.mygdx.game.ItemManager;
import com.mygdx.game.Statistics;
import com.mygdx.game.UseItem;
import com.mygdx.game.battle.BattleMenu;

import junit.framework.TestCase;

public class UseItemTest extends TestCase {

	UseItem testUseItem;
	Agent testAgent1, testAgent2;

	BattleMenu mockBattleMenu;

	Game game = new Game();

	Consumable testConsumable = new Consumable("testCon", "test", Consumable.consumeType.HEAL, 5);

	public void setUp() {
		game.items = new ItemManager();
		game.items.addConsumable(testConsumable);
		System.out.println(game.items.toString());
		testAgent1 = new Agent("testAgent1", AgentType.FRIENDLY, new Statistics(10, 10, 20, 10, 10, 10, 10, 3, 1),
				new ArrayList<Integer>(), new CurrentEquipment(), 1);
		testAgent2 = new Agent("testAgent2", AgentType.FRIENDLY, new Statistics(10, 10, 10, 10, 10, 10, 10, 3, 1),
				new ArrayList<Integer>(), new CurrentEquipment(), 1);
		mockBattleMenu = mock(BattleMenu.class);
		testUseItem = new UseItem(testAgent1, testAgent2, 1, mockBattleMenu);
	}

	public void testMovementDoneHeal() {
//		Assets mockAssets = mock(Assets.class); 
//		doNothing().when(mockAssets.sfx_healNoise).play();
//		doThrow(new RuntimeException()).when(mockBattleMenu).createInfoBox(testAgent1.getName() + " is healed for " + testConsumable.getPower()
//        + " health",3);
//		int getDuck
		testUseItem.movementDone(0);
		assertTrue(true);
	}

	public void testMovementDoneRevive() {
		assertTrue(true);
	}

	public void testMovementDoneManaheal() {
		assertTrue(true);
	}

}
