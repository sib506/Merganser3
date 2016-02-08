package com.mygdx.game.UI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.Assets;
import com.mygdx.game.InputHandler;

/**
 * The party menu allows the user to see information about each party member. It
 * contains a party member's skills and statistics.
 */
public class UIMap extends UIComponent {

	private boolean show;

	private BitmapFont font;

	float paddingX;
	float paddingY;
	int i;

	private UIMessageBox map = new UIMessageBox("World Map", Assets.consolas22, Color.WHITE, Align.center,
			x, (y + height + 4), width, 0, 10);

	public UIMap(float x, float y, float width, float height) {
		super(x, y, width, height);
		paddingX = 25;
		paddingY = 70;
		font = Assets.consolas22;
		show = false;
	}

	/**
	 * Called once per frame to render the party menu.
	 */
	@Override
	public void render(SpriteBatch batch, NinePatch patch) {

		if (show) {

			new UIMessageBox("", Assets.consolas22, Color.WHITE, Align.center, x, y, width, height).render(batch,
					patch);

			map.render(batch, patch);
			batch.draw(Assets.worldMap,95,60);
			
		}
	}

	/**
	 * Makes the UI component visible on screen.
	 */
	public void show() {
		show = true;
	}

	/**
	 * Called once per frame to handle input logic for selecting a player and
	 * exiting the menu.
	 * 
	 * @return returns true if the dialogue box should continue to be displayed.
	 */
	public boolean update(float delta) {
		if (InputHandler.isEscJustPressed()) {
			show = false;
			return false;
		} else {
			return true;
		}

	}

	public void renderText(SpriteBatch batch, String message, float x, float y, Color color) {
		GlyphLayout layout = new GlyphLayout(font, message, Color.BLACK, width - paddingX * 2, Align.left, false);

		font.draw(batch, layout, x + paddingX, y + height + paddingY - 2);
		layout.setText(font, message, color, width - paddingX * 2, Align.left, false);
		font.draw(batch, layout, x + paddingX, y + height + paddingY);
	}
}
