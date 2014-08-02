package org.cyberhive.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.maps.MapLayers
import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.maps.tiled.TiledMapTile
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer
import com.badlogic.gdx.maps.tiled.renderers.HexagonalTiledMapRenderer
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile
import org.cyberhive.CyberHive
import org.cyberhive.map.HexMap

public class GameScreen(var game: CyberHive) : Screen {
    val camera = OrthographicCamera()
    val hexMap = HexMap();
    {
        camera.setToOrtho(false, CyberHive.VIRTUAL_WIDTH.toFloat(), CyberHive.VIRTUAL_HEIGHT.toFloat())
    }

    override fun render(delta: Float) {
        Gdx.gl?.glClearColor(1f, 1f, 1f, 1f)
        Gdx.gl?.glClear(GL20.GL_COLOR_BUFFER_BIT)

        camera.update()
        hexMap.renderer.setView(camera)
        hexMap.renderer.render()
    }

    override fun resize(width: Int, height: Int) {
    }

    override fun show() {
    }

    override fun hide() {
    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun dispose() {
        hexMap.dispose()
    }
}
