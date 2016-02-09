package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.UI.UIManager;
import com.mygdx.game.battle.BattleParameters;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the robot boss of the game.
 */
public class RoboNPC extends NPC {

    private String[] messages;

    public RoboNPC(Level level, Vector2 currentTile) {
        super(level, currentTile);
        messages = new String[2];
        messages[0] = "01010000 01001100 01000101 01000001 01010011 01000101 00100000 01001000 01000101 01001100 01010000 00100000 01001101 01000101 00001101 00001010!!!";
        messages[1] = "Robo duck has challenged you to a battle.";
    }

    @Override
    public void initializeInteraction(float delta, UIManager uiManager) {
        uiManager.createDialogue(messages);
        this.uiManager = uiManager;
    }

    @Override
    public boolean updateInteracting(float delta) {
        return uiManager.updateDialogue(delta);
    }

    @Override
    public void action(GameWorld gameWorld) {
        Assets.sfx_battleStart.play(Game.masterVolume);
        
        if(gameWorld.game.objectiveManager.gameObjectives.containsKey("RoboDuck")){
        	uiManager.addNotification("You defeated Roboduck! You got 100 points!");
        	gameWorld.game.objectiveManager.completeObjective("RoboDuck");
        }
        else{
        	uiManager.addNotification("You needed to talk to Sally! No points for you!");
        }
        level.characters.add(new EvilNPC(level, new Vector2(149, 70)));
//        Game.objectivesComplete += 1;
//        Game.objectives[1] = true;
//        Game.pointsScore += 100;
        BattleParameters params = new BattleParameters(0);
        //Enemy ducks
        List<Integer> emptyList = new ArrayList<Integer>();
        Agent enemyDuck = new Agent("Robo Duck", Agent.AgentType.ENEMY,new Statistics(180,300,8,2,3,3,3,3,3),emptyList,new CurrentEquipment(0,0,0,0,0),1);
//        enemyDuck.equipEquipment(0);
//        enemyDuck.equipEquipment(1);
        enemyDuck.addSkill(4);

        params.addEnemy(enemyDuck);


        gameWorld.setBattle(params);
        level.characters.remove(this);

    }
}
