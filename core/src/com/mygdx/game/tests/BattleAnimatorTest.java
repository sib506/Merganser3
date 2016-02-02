package com.mygdx.game.tests;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import com.mygdx.game.Agent;
import com.mygdx.game.Agent.AgentType;
import com.mygdx.game.CurrentEquipment;
import com.mygdx.game.Statistics;
import com.mygdx.game.UseItem;
import com.mygdx.game.battle.BattleAnimator;

import junit.framework.TestCase;

public class BattleAnimatorTest extends TestCase {
	
	Agent testAgent1, testAgent2;
	BattleAnimator testAnimator;
	UseItem testItem;

	float valueX = 100f;
	float valueY = 100f;
	
	
	public void setUp(){
		testItem = mock(UseItem.class);
		testAgent1 = new Agent("testAgent", AgentType.FRIENDLY,
				new Statistics(10, 10, 20, 10, 10, 10, 10, 3, 1),
				new ArrayList<Integer>(), new CurrentEquipment(), 1);
		testAgent2 = new Agent("testAgent", AgentType.FRIENDLY,
				new Statistics(10, 10, 10, 10, 10, 10, 10, 3, 1),
				new ArrayList<Integer>(), new CurrentEquipment(), 1);
		testAnimator = new BattleAnimator();
		testAgent1.setX(valueX);
		testAgent1.setY(valueY);
	}
	
	public void testUpdate(){
		testAnimator.moveAgentTo(testAgent1, 0.5f, 2.6f, testItem);
		testAnimator.update(0);
		assertEquals(95.0f, testAgent1.getX());
		assertEquals(89.74737f, testAgent1.getY());
	}
	
	public void testMultipleUpdate(){
		testAnimator.moveAgentTo(testAgent1, 0.5f, 2.6f, testItem);
		testAnimator.update(0);
		testAnimator.update(0);
		testAnimator.update(0);
		testAnimator.update(0);
		testAnimator.update(0);
		testAnimator.update(0);
		testAnimator.update(0);
		testAnimator.update(0);
		testAnimator.update(0);
		assertEquals(52.5f, testAgent1.getX());
		assertEquals(2.6f, testAgent1.getY());
	}
	
	public void testReturnAgent(){
		testAnimator.moveAgentTo(testAgent1, 55.3f, 26f, testItem);
		testAnimator.update(0);
		assertTrue(testAgent1.getX() != valueX);
		assertTrue(testAgent1.getY() != valueY);
		testAnimator.returnAgent();
		testAnimator.update(0);
		assertEquals(valueX, testAgent1.getX());
		assertEquals(valueY, testAgent1.getY());
	}	
}
