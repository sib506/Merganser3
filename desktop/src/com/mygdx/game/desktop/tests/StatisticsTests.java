package com.mygdx.game.desktop.tests;

import com.mygdx.game.Statistics;

import junit.framework.TestCase;

public class StatisticsTests extends TestCase {

	Statistics testStat;

	public void setUp() {
		testStat = new Statistics(100, 100, 5, 5, 5, 5, 10, 0, 1);
	}

	// Tests Increase XP doesn't level up if not over required level
	public void testIncreaseXPNoLevelUp() {
		testStat.increaseXP(50);
		assertEquals(50, testStat.getExperience());
		assertEquals(1, testStat.getCurrentLevel());
	}

	// Increase XP levels up if over required level
	public void testIncreaseXPLevelUp() {
		testStat.increaseXP(140);
		assertEquals(40, testStat.getExperience());
		assertEquals(2, testStat.getCurrentLevel());
	}

	public void testReduceHP() {
		testStat.reduceHP(50);
		assertEquals(50, testStat.getCurrentHP());
	}

	// Reduce HP does not go negative
	public void testReduceHPto0() {
		testStat.reduceHP(150);
		assertEquals(0, testStat.getCurrentHP());
	}

	public void testIncreaseHP() {
		testStat.reduceHP(50);
		testStat.increaseHP(10);
		assertEquals(60, testStat.getCurrentHP());
	}

	// Increase HP doesn't increase above MaxMP
	public void testIncreaseHPMaxHP() {
		testStat.reduceHP(50);
		testStat.increaseHP(150);
		assertEquals(testStat.getMaxHP(), testStat.getCurrentHP());
	}

	public void testIncreaseMP() {
		testStat.reduceMP(50);
		testStat.increaseMP(10);
		assertEquals(60, testStat.getCurrentMP());
	}

	// Increase MP doesn't increase above MaxMP
	public void testIncreaseMPMax() {
		testStat.reduceMP(60);
		testStat.increaseMP(120);
		assertEquals(testStat.getMaxMP(), testStat.getCurrentMP());
	}

	// Reduce MP doesn't reduce below 0 (negative)
	public void testreduceMPto0() {
		testStat.reduceMP(150);
		assertEquals(0, testStat.getCurrentMP());
	}

}
