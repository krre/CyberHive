package org.cyberhive.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import org.cyberhive.CyberHive;

public class GameScreen implements Screen {
    CyberHive game;
    OrthographicCamera camera;
    Texture hexture;


    public GameScreen(final CyberHive game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, CyberHive.VIRTUAL_WIDTH, CyberHive.VIRTUAL_HEIGHT);

        hexture = new Texture(Gdx.files.internal("hexagon.png"));
    }

    @Override
    public void render(float delta) {
   		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(hexture, 0, 0);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
