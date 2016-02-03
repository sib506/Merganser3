package com.mygdx.game;

import com.mygdx.game.UI.UIManager;

public class Objectives {

	public static boolean objectives[] = { false, false, false, false, false, false, false, false };
	/*
	 * 0:Talk to Sally 1:Defeat Roboduck 2:Win 10 battles 3:Reach 200 points
	 * 4:Defeat ??? 5:Win 20 battles 6:Reach 400 points 7:Defeat ???
	 */

	public static int objectivesComplete = 0;
	public static int battlesWon = 0;
	public Game game;

	public boolean complete3 = false;
	public boolean complete6 = false;
	
	public Objectives(Game game) {
		this.game = game;

	}

	public void battleWon(UIManager uiManager) {
		battlesWon += 1;
		if (battlesWon == 10) {
			objectives[2] = true;
			objectivesComplete += 1;
			Game.pointsScore += 50;
			uiManager.addNotification("You won 10 battles! You got 50 points!");
		} else if (battlesWon == 20) {
			objectives[5] = true;
			objectivesComplete += 1;
			Game.pointsScore += 50;
			uiManager.addNotification("You won 20 battles! You got 50 points!");
		}
	}

	public void completeObjective(int objective, int points) {
		Game.pointsScore += points;
		objectivesComplete ++;
		objectives[objective] = true;
	}
	
	public void ObjectiveNotification(String message){
		game.getWorldScreen().getGameWorld().uiManager.addNotification(message);
	}

	public void checkPoints() {
		if (Game.pointsScore >= 200 && !objectives[3]) {
			objectives[3] = true;
			ObjectiveNotification("You have over 200 points. Objective completed.");
		}
		else if (Game.pointsScore >= 400 && !objectives[6]){
			objectives[6] = true;
			ObjectiveNotification("You have over 400 points. Objective completed.");
		}
	}

	public void checkObjectives(){
		if (!complete3){
			check3Objective();
		}
		else if (!complete6){
			check6Objective();
		}
		else {
			checkAllComplete();
		}
		checkPoints();
	}
	
	public void check3Objective() {
		if (objectivesComplete == 1 && !complete3) {
			ObjectiveNotification("You have completed 3 objectives. Have some new skills!");
			Game.party.getMember(0).addSkill(9);
			Game.party.getMember(1).addSkill(10);
			Game.party.getMember(2).addSkill(11);
			Game.party.getMember(3).addSkill(12);
			complete3 = true;
		}
	}

	public void check6Objective() {
		if (objectivesComplete == 6 && !complete6) {
			ObjectiveNotification("You have completed 6 objectives. Have some new skills!");
			Game.party.getMember(0).addSkill(13);
			Game.party.getMember(1).addSkill(14);
			Game.party.getMember(2).addSkill(15);
			Game.party.getMember(3).addSkill(16);
			complete6 = true;
		}
	}

	public void checkAllComplete() {
		if (objectivesComplete >= 1) {
			game.newWinScreen();
		}
	}

}
