package com.mygdx.game.UI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The party menu allows the user to see information about each party member.
 * It contains a party member's skills and statistics.
 */
public class UIObjectives extends UIComponent {

    private boolean show;

    private int playerSelected, menuSelected;

    private UIMessageBox objectiveDisplay = new UIMessageBox("OBJECTIVES", Assets.consolas22, Color.WHITE, Align.center, x, (y + height + 4), width, 0, 10);

    public UIObjectives(float x, float y, float width, float height) {
        super(x, y, width, height);
        show = false;
    }

    /**
     * Called once per frame to render the party menu.
     */
    @Override
    public void render(SpriteBatch batch, NinePatch patch) {

        if (show) {

            new UIMessageBox("", Assets.consolas22, Color.WHITE, Align.center, x, y, width, height).render(batch, patch);
            objectiveDisplay.render(batch, patch);

        }
    }

    /**
     * Makes the UI component visible on screen.
     */
    public void show() {
        playerSelected = 0;
        menuSelected = 1;
        show = true;
    }

    /**
     * Called once per frame to handle input logic for selecting a player and exiting the menu.
     * @return returns true if the dialogue box should continue to be displayed.
     */
    public boolean update(float delta) {
        if (InputHandler.isEscJustPressed()) {
            show = false;
            return false;
        } else {
            optionUpdate();
            return true;
        }

    }

    private void optionUpdate() {
        if (InputHandler.isUpJustPressed()) {
            playerSelected--;
        } else if (InputHandler.isDownJustPressed()) {
            playerSelected++;
        }
        if (InputHandler.isLeftJustPressed()) {
            menuSelected--;
        } else if (InputHandler.isRightJustPressed()) {
            menuSelected++;
        }
        if (menuSelected < 0)
            menuSelected = 0;
        if (menuSelected > 2)
            menuSelected = 2;
        if (playerSelected < 0)
            playerSelected = 0;
    }
}
