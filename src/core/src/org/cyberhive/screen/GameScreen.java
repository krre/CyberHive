package org.cyberhive.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.HexagonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import org.cyberhive.CyberHive;

public class GameScreen implements Screen {
    CyberHive game;
    OrthographicCamera camera;
    TiledMap map;
    Texture hexture;
    HexagonalTiledMapRenderer renderer;


    public GameScreen(final CyberHive game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, CyberHive.VIRTUAL_WIDTH, CyberHive.VIRTUAL_HEIGHT);

        hexture = new Texture(Gdx.files.internal("hexagon.png"));
        int hexWidth = 103;
        int hexHeight = 90;
        TextureRegion[][] hexes = TextureRegion.split(hexture, hexWidth, hexHeight);
        map = new TiledMap();
        MapLayers layers = map.getLayers();
        TiledMapTile[] tiles = new TiledMapTile[4];
        tiles[0] = new StaticTiledMapTile(new TextureRegion(hexes[0][0]));
        tiles[1] = new StaticTiledMapTile(new TextureRegion(hexes[0][1]));
        tiles[2] = new StaticTiledMapTile(new TextureRegion(hexes[1][0]));
        tiles[3] = new StaticTiledMapTile(new TextureRegion(hexes[1][1]));

        int mapWidth = 45;
        int mapHeight = 30;
        TiledMapTileLayer layer = new TiledMapTileLayer(mapWidth, mapHeight, hexWidth, hexHeight);
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
                int id = (int)(Math.random() * 4);
                cell.setTile(tiles[id]);
                layer.setCell(x, y, cell);
            }
        }
        layers.add(layer);
        renderer = new HexagonalTiledMapRenderer(map);

    }

    @Override
    public void render(float delta) {
   		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        renderer.setView(camera);
        renderer.render();
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
        renderer.dispose();
        hexture.dispose();
        map.dispose();
    }
}
