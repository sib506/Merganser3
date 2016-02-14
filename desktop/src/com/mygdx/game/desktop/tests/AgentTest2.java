package com.mygdx.game.desktop.tests;

import java.util.ArrayList;

import com.mygdx.game.Agent;
import com.mygdx.game.Agent.AgentType;
import com.mygdx.game.CurrentEquipment;
import com.mygdx.game.Equipable;
import com.mygdx.game.Equipable.equipType;
import com.mygdx.game.Statistics;

import junit.framework.TestCase;

public class AgentTest2 extends TestCase {

	Agent testAgent1, testAgent2;

	Equipable testEquipment = new Equipable("hammer", "hammer to hit things with", equipType.WEAPON, 4, 2, 1, 4, 2, 1);

	public void setUp() {
		testAgent1 = new Agent("testAgent", AgentType.FRIENDLY, new Statistics(10, 10, 20, 10, 10, 10, 10, 3, 1),
				new ArrayList<Integer>(), new CurrentEquipment(), 1);
		testAgent2 = new Agent("testAgent", AgentType.FRIENDLY, new Statistics(10, 10, 10, 10, 10, 10, 10, 3, 1),
				new ArrayList<Integer>(), new CurrentEquipment(), 1);

	}

	// Compares total speed of agents
	public void testCompareTo1() {
		assertEquals(-10, testAgent1.compareTo(testAgent2));
	}

	// Compares total speed of agents
	public void testCompareTo2() {
		assertEquals(10, testAgent2.compareTo(testAgent1));
	}

	// Tests whether the agent is dead
	public void testIsDead() {
		int currentHealth = testAgent1.getStats().getCurrentHP();
		testAgent1.dealDamage(currentHealth * 2);
		assertTrue(testAgent1.isDead());

	}
	
	// Tests whether the agent is dead
		public void testIsNotDead() {
			int currentHealth = testAgent1.getStats().getCurrentHP();
			testAgent1.dealDamage(currentHealth-3);
			assertFalse(testAgent1.isDead());

		}

	// Test adding a skill
	public void testAddSkillNotInList() {
		testAgent1.addSkill(0);
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		assertEquals(expected, testAgent1.getSkills());
	}

	// Test adding a skill
	public void testAddSkillAlreadyInList() {
		testAgent1.addSkill(0);
		testAgent1.addSkill(0);
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		assertEquals(expected, testAgent1.getSkills());
	}
}
