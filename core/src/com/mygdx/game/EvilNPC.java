package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.UI.UIManager;
import com.mygdx.game.battle.BattleParameters;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the vampire boss of the game.
 */
public class EvilNPC extends NPC {

    private String[] messages;

    public EvilNPC(Level level, Vector2 currentTile) {
        super(level, currentTile);
        messages = new String[3];
        messages[0] = "I have a doctorate, you know.";
        messages[1] = "I did important research.";
        messages[2] = "Why are you still bothering me?";
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
        uiManager.addNotification("'Tell my students... Their lectures are available online...'");
        uiManager.addNotification("You defeated the EVIL duck! You got 150 points!");
        gameWorld.game.objectiveManager.completeObjective(4, 150);
//        Game.objectivesComplete += 1;
//        Game.objectives[1] = true;
//        Game.pointsScore += 100;
        BattleParameters params = new BattleParameters(0);
        //Enemy ducks
        List<Integer> emptyList = new ArrayList<Integer>();
        Agent enemyDuck = new Agent("Dr. Von Duck", Agent.AgentType.ENEMY,new Statistics(300,500,8,2,3,3,3,3,3),emptyList,new CurrentEquipment(0,0,0,0,0),1);
//        enemyDuck.equipEquipment(0);
//        enemyDuck.equipEquipment(1);
        enemyDuck.addSkill(18);

        params.addEnemy(enemyDuck);


        gameWorld.setBattle(params);
        level.characters.remove(this);

    }
}
