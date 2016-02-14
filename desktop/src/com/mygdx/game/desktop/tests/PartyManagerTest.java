package com.mygdx.game.desktop.tests;

import java.util.ArrayList;

import com.mygdx.game.Agent;
import com.mygdx.game.Statistics;
import com.mygdx.game.managers.PartyManager;

public class PartyManagerTest extends AssetTestCase {

	PartyManager testPartyManager = new PartyManager();
	ArrayList<Integer> skills = new ArrayList<Integer>();
	Agent agent1;
	Agent agent2;
	Agent agent3;
	Agent agent4;
	Agent agent5;
	Agent agent6;

	public void setUp() {
		super.setUp();
		skills.add(1);
		skills.add(2);
		skills.add(3);
		skills.add(4);
		agent1 = new Agent("test1", Agent.AgentType.FRIENDLY, new Statistics(10, 10, 10, 10, 10, 10, 10, 10, 1), skills,
				null, 0);
		agent2 = new Agent("test2", Agent.AgentType.FRIENDLY, new Statistics(10, 10, 10, 10, 10, 10, 10, 10, 1), skills,
				null, 0);
		agent3 = new Agent("test3", Agent.AgentType.FRIENDLY, new Statistics(10, 10, 10, 10, 10, 10, 10, 10, 1), skills,
				null, 0);
		agent4 = new Agent("test4", Agent.AgentType.FRIENDLY, new Statistics(10, 10, 10, 10, 10, 10, 10, 10, 1), skills,
				null, 0);
		agent5 = new Agent("test5", Agent.AgentType.FRIENDLY, new Statistics(10, 10, 10, 10, 10, 10, 10, 10, 1), skills,
				null, 0);
		agent6 = new Agent("test6", Agent.AgentType.FRIENDLY, new Statistics(10, 10, 10, 10, 10, 10, 10, 10, 1), skills,
				null, 0);
		testPartyManager = new PartyManager();
		testPartyManager.addMember(agent1);
		testPartyManager.addMember(agent2);
		testPartyManager.addMember(agent3);
		testPartyManager.addMember(agent4);
		testPartyManager.addMember(agent5);
	}

	// Tests that the size of the party can't increase above 5
	public void testAddMemberMaxed() {
		assertEquals(5, testPartyManager.size());
		testPartyManager.addMember(agent6);
		assertEquals(5, testPartyManager.size());
	}

	// Tests the correct index is returned and that if not in manager then
	// negative number returned
	public void testGetIndex() {
		assertEquals(0, testPartyManager.getIndex(agent1));
		assertEquals(1, testPartyManager.getIndex(agent2));
		assertEquals(-1, testPartyManager.getIndex(agent6));
	}

	// Tests correct list of agents returned
	public void testGetMember() {
		ArrayList<Agent> expectedList = new ArrayList<Agent>();
		expectedList.add(agent1);
		expectedList.add(agent2);
		expectedList.add(agent3);
		expectedList.add(agent4);
		expectedList.add(agent5);
		assertEquals(expectedList, testPartyManager.getMember("test"));
	}

	// Tests that empty list returned if no members in party
	public void testNoGetMember() {
		ArrayList<Agent> expectedList = new ArrayList<Agent>();
		assertEquals(expectedList, testPartyManager.getMember("notest"));
	}

	// Tests that returns true if all agents dead
	public void testIsDead() {
		testPartyManager.getMember(0).dealHealth(-100);
		testPartyManager.getMember(1).dealHealth(-100);
		testPartyManager.getMember(2).dealHealth(-100);
		testPartyManager.getMember(3).dealHealth(-100);
		testPartyManager.getMember(4).dealHealth(-100);
		assertTrue(testPartyManager.isDead());
	}

	// Tests returns false if all agents aren't dead
	public void testIsNotDead() {
		testPartyManager.getMember(0).dealHealth(-100);
		testPartyManager.getMember(1).dealHealth(-9);
		testPartyManager.getMember(2).dealHealth(-9);
		testPartyManager.getMember(3).dealHealth(-9);
		testPartyManager.getMember(4).dealHealth(-9);
		assertFalse(testPartyManager.isDead());
	}

	// Test consumable removes correctly and only 1 instance of consumable
	public void testRemoveConsumables() {
		testPartyManager.addConsumable(1);
		testPartyManager.addConsumable(1);
		assertTrue(testPartyManager.getConsumables().contains(1));
		testPartyManager.removeConsumable(1);
		assertTrue(testPartyManager.getConsumables().contains(1));
		testPartyManager.removeConsumable(1);
		assertFalse(testPartyManager.getConsumables().contains(1));
	}

	// Tests setHealth changes the health of all members in party by specified
	// amount
	public void testSetHealths() {
		testPartyManager.setHealths(-5);
		for (int i = 0; i < testPartyManager.size(); i++)
			assertEquals(5, testPartyManager.getMember(i).getStats().getCurrentHP());
	}

}
