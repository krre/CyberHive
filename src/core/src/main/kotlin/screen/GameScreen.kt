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

public class GameScreen(var game: CyberHive) : Screen {
    var camera: OrthographicCamera
    var map: TiledMap
    var hexture: Texture
    var renderer: HexagonalTiledMapRenderer

    {
        camera = OrthographicCamera()
        camera.setToOrtho(false, CyberHive.VIRTUAL_WIDTH.toFloat(), CyberHive.VIRTUAL_HEIGHT.toFloat())

        hexture = Texture(Gdx.files?.internal("hexagon.png"))
        val hexWidth = 103
        val hexHeight = 90
        val hexes = TextureRegion.split(hexture, hexWidth, hexHeight)
        map = TiledMap()
        val layers = map.getLayers()
        val tiles = arrayOfNulls<TiledMapTile>(4)
        tiles[0] = StaticTiledMapTile(TextureRegion(hexes?.elementAt(0)?.elementAt(0)))
        tiles[1] = StaticTiledMapTile(TextureRegion(hexes?.elementAt(0)?.elementAt(1)))
        tiles[2] = StaticTiledMapTile(TextureRegion(hexes?.elementAt(1)?.elementAt(0)))
        tiles[3] = StaticTiledMapTile(TextureRegion(hexes?.elementAt(1)?.elementAt(1)))

        val mapWidth = 45
        val mapHeight = 30
        val layer = TiledMapTileLayer(mapWidth, mapHeight, hexWidth, hexHeight)
        for (y in 0..mapHeight - 1) {
            for (x in 0..mapWidth - 1) {
                val cell = TiledMapTileLayer.Cell()
                val id = (Math.random() * 4).toInt()
                cell.setTile(tiles[id])
                layer.setCell(x, y, cell)
            }
        }
        layers?.add(layer)
        renderer = HexagonalTiledMapRenderer(map)

    }

    override fun render(delta: Float) {
        Gdx.gl?.glClearColor(1f, 1f, 1f, 1f)
        Gdx.gl?.glClear(GL20.GL_COLOR_BUFFER_BIT)

        camera.update()
        renderer.setView(camera)
        renderer.render()
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
        renderer.dispose()
        hexture.dispose()
        map.dispose()
    }
}
