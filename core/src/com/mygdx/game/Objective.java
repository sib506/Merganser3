package com.mygdx.game;

public class Objective {
	private String description;
	private boolean complete = false;
	private int addScore;
	private String textReward;
	private boolean valueObjective;
	
	public Objective(String description, int score, String textReward, boolean valueObjective ){
		this.description = description;
		this.addScore = score;
		this.textReward = textReward;
		this.valueObjective = valueObjective;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public int getAddScore() {
		return addScore;
	}

	public void setAddScore(int addScore) {
		this.addScore = addScore;
	}

	public String getTextReward() {
		return textReward;
	}

	public void setTextReward(String textReward) {
		this.textReward = textReward;
	}

	public boolean isValueObjective() {
		return valueObjective;
	}

	public void setValueObjective(boolean valueObjective) {
		this.valueObjective = valueObjective;
	}
	
	
	
	
}
