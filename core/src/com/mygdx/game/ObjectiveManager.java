package com.mygdx.game;

import java.util.LinkedHashMap;

import com.mygdx.game.UI.UIManager;

public class ObjectiveManager {
	
//	public static ArrayList<Objective> gameObjectives = new ArrayList<Objective>();
	public LinkedHashMap<String, Objective> gameObjectives = new LinkedHashMap<String, Objective>(); 
//	public static boolean objectives[] = { false, false, false, false, false, false, false, false };
	/*
	 * 0:Talk to Sally 1:Defeat Roboduck 2:Win 10 battles 3:Reach 200 points
	 * 4:Defeat The EVIL duck 5:Win 20 battles 6:Reach 400 points 7:Defeat ???
	 */

	public static int objectivesComplete = 0;
	public static int battlesWon = 0;
	public Game game;

	public boolean complete3 = false;
	public boolean complete6 = false;
	
	public ObjectiveManager(Game game) {
		this.game = game;
		// Add objectives that are defined by the game e.g. score
		gameObjectives.put("Sally", new Objective("Talk to Sally", 40, "40 Points", false));
		gameObjectives.put("10Batt", new Objective("Win 10 battles", 50, "50 Points", true));
		gameObjectives.put("3Obj", new Objective("Complete 3 objectives", 0 , "Mystery reward", true));
		gameObjectives.put("200Points", new Objective("Reach 200 points", 0, "Mystery reward", true));
		gameObjectives.put("AllObj", new Objective("Complete All objectives", 0, "Completes the game", true));
	}
	
	public int addObjective(String key, Objective e){
		gameObjectives.put(key, e);
		return gameObjectives.size()-1;
	}

	public void battleWon(UIManager uiManager) {
		battlesWon += 1;
		if (battlesWon == 10 && !gameObjectives.get("10Batt").isComplete()) {
			gameObjectives.get("10Batt").setComplete(true);
			gameObjectives.put("20Batt", new Objective("Win 20 battles", 50, "50 Points", true));
			gameObjectives.remove("10Batt");
//			objectives[2] = true;
			objectivesComplete += 1;
			Game.pointsScore += 50;
			uiManager.addNotification("You won 10 battles! You got 50 points!");
		} else if (battlesWon == 20 && !gameObjectives.get("20Batt").isComplete()) {
			gameObjectives.get("20Batt").setComplete(true);
//			objectives[5] = true;
			objectivesComplete += 1;
			Game.pointsScore += 50;
			uiManager.addNotification("You won 20 battles! You got 50 points!");
		}
	}
	
	public void completeObjective(String key){
		objectivesComplete++;
		gameObjectives.get(key).setComplete(true);
		Game.pointsScore += gameObjectives.get(key).getAddScore();
	}

//	public void completeObjective(int objective, int points) {
//		Game.pointsScore += points;
//		objectivesComplete ++;
//		objectives[objective] = true;
//	}
	
	public void ObjectiveNotification(String message){
		game.getWorldScreen().getGameWorld().uiManager.addNotification(message);
	}

	public void checkPoints() {
		if (Game.pointsScore >= 200 && !gameObjectives.get("200Points").isComplete()) {
			gameObjectives.get("200Points").setComplete(true);
			gameObjectives.put("400Points", new Objective("Reach 400 points", 0, "Mystery reward", true));
			gameObjectives.remove("200Points");
			ObjectiveNotification("You have over 200 points. Objective completed.");
		}
		else if (Game.pointsScore >= 400 && !gameObjectives.get("400Points").isComplete()){
			gameObjectives.get("400Points").setComplete(true);
			ObjectiveNotification("You have over 400 points. Objective completed.");
		}
	}

	public void checkObjectives(){
//		for (String key : gameObjectives.keySet()){
//			System.out.println("Objective: " + gameObjectives.get(key).getDescription() + " : " + gameObjectives.get(key).isComplete());
//		}
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
			gameObjectives.get("3Obj").setComplete(true);
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
			gameObjectives.get("6Obj").setComplete(true);
			gameObjectives.put("6Obj", new Objective("Complete 6 objectives", 0, "Mystery reward", true));
			gameObjectives.remove("6Obj");
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