package com.mygdx.game.desktop.tests;

import com.mygdx.game.Game;
import com.mygdx.game.Objective;
import com.mygdx.game.managers.ObjectiveManager;

public class ObjectiveManagerTest extends AssetTestCase{
	public void setUp(){
		super.setUp();
	}
	
	// Checks that manager hasn't been intialised empty
	public void testObjInitalise(){
		assertTrue(!game.objectiveManager.gameObjectives.isEmpty());
	}
	
	// Test objective is correctly added to manager
	public void testAddObjective(){
		Objective testObjective = new Objective("test Objective", 50, "50 points", false);
		game.objectiveManager.addObjective("testObj", testObjective);
		assertTrue(game.objectiveManager.gameObjectives.containsKey("testObj"));
	}
	
	// Tests objective when complete increases game score, updates completed objectives and removes correctly
	public void testCompleteObjective(){
		int pointsBeforeObj = Game.pointsScore;
		int objectivesCompleteBefore = ObjectiveManager.objectivesComplete;
		Objective testObjective = new Objective("test Objective", 50, "50 points", false);
		game.objectiveManager.addObjective("testObj", testObjective);
		game.objectiveManager.completeObjective("testObj");
		assertTrue(!game.objectiveManager.gameObjectives.containsKey("testObj"));
		int pointsAfterObj = Game.pointsScore;
		assertEquals(pointsBeforeObj + testObjective.getAddScore(), pointsAfterObj);
		assertEquals(objectivesCompleteBefore + 1,ObjectiveManager.objectivesComplete);
	}
	
	// Checks that when completing 3 objectives, skills are added correctly to party and new obj setup
	public void testCheck3Objectives(){
		game.objectiveManager.objectivesComplete = 3;
		assertTrue(!Game.party.getMember(0).getSkills().contains(9));
		assertTrue(!Game.party.getMember(1).getSkills().contains(10));
		assertTrue(!Game.party.getMember(2).getSkills().contains(11));
		assertTrue(!Game.party.getMember(3).getSkills().contains(12));
		game.objectiveManager.check3Objective();
		assertTrue(game.objectiveManager.gameObjectives.containsKey("6Obj"));
		assertTrue(Game.party.getMember(0).getSkills().contains(9));
		assertTrue(Game.party.getMember(1).getSkills().contains(10));
		assertTrue(Game.party.getMember(2).getSkills().contains(11));
		assertTrue(Game.party.getMember(3).getSkills().contains(12));
	}
	
	// Checks that when completing 6 objectives, skills are added correctly to party
	public void testCheck6Objectives(){
		game.objectiveManager.addObjective("6Obj", new Objective("Complete 6 objectives", 0, "Mystery reward", true));
		game.objectiveManager.objectivesComplete = 6;
		assertTrue(!Game.party.getMember(0).getSkills().contains(13));
		assertTrue(!Game.party.getMember(1).getSkills().contains(14));
		assertTrue(!Game.party.getMember(2).getSkills().contains(15));
		assertTrue(!Game.party.getMember(3).getSkills().contains(16));
		game.objectiveManager.check6Objective();
		assertTrue(Game.party.getMember(0).getSkills().contains(13));
		assertTrue(Game.party.getMember(1).getSkills().contains(14));
		assertTrue(Game.party.getMember(2).getSkills().contains(15));
		assertTrue(Game.party.getMember(3).getSkills().contains(16));
	}
	
	// Checks that when completing reaching 200 points the objective completes successfully
	public void test200CheckPoints(){
		game.objectiveManager.addObjective("200Points", new Objective("Reach 200 points", 0, "Mystery reward", true));
		game.pointsScore = 200;
		game.objectiveManager.checkPoints();
		assertTrue(!game.objectiveManager.gameObjectives.containsKey("200Points"));
	}
	
	// Checks that when completing reaching 400 points the objective completes successfully
	public void test400CheckPoints(){
		game.objectiveManager.addObjective("200Points", new Objective("Reach 200 points", 0, "Mystery reward", true));
		game.pointsScore = 200;
		game.objectiveManager.checkPoints();
		assertTrue(game.objectiveManager.gameObjectives.containsKey("400Points"));
		game.pointsScore = 400;
		game.objectiveManager.checkPoints();
		assertTrue(!game.objectiveManager.gameObjectives.containsKey("400Points"));
	}
}
