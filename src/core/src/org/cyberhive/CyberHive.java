package org.cyberhive;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.cyberhive.screen.GameScreen;

public class CyberHive extends Game {
    public static final int VIRTUAL_WIDTH = 800;
    public static final int VIRTUAL_HEIGHT = 480;
    public SpriteBatch batch;
    public BitmapFont font;


	@Override
	public void create () {
        batch = new SpriteBatch();
        font = new BitmapFont();
        setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
        super.render();
	}

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
