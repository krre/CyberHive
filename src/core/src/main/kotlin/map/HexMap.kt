package org.cyberhive.map

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.maps.tiled.TiledMapTile
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer
import com.badlogic.gdx.maps.tiled.renderers.HexagonalTiledMapRenderer
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile
import org.cyberhive.logic.World
import org.cyberhive.printc
import org.cyberhive.storage.Storage

class HexMap {
    private val map =  TiledMap()
    private val hexture = Texture(Gdx.files.internal("hexagon.png"))
    val renderer: HexagonalTiledMapRenderer
    init {
        val hexWidth = 103
        val hexHeight = 90
        val hexes = TextureRegion.split(hexture, hexWidth, hexHeight)
        val layers = map.getLayers()
        val tiles = arrayOfNulls<TiledMapTile>(4)
        tiles[0] = StaticTiledMapTile(TextureRegion(hexes.elementAt(0).elementAt(0)))
        tiles[1] = StaticTiledMapTile(TextureRegion(hexes.elementAt(0).elementAt(1)))
        tiles[2] = StaticTiledMapTile(TextureRegion(hexes.elementAt(1).elementAt(0)))
        tiles[3] = StaticTiledMapTile(TextureRegion(hexes.elementAt(1).elementAt(1)))

        val mapWidth = Storage.hardwareArray!!.count()
        val mapHeight = Storage.hardwareArray!!.count()
        val layer = TiledMapTileLayer(mapWidth, mapHeight, hexWidth, hexHeight)
        for (y in 0..mapHeight - 1) {
            for (x in 0..mapWidth - 1) {
                val cell = TiledMapTileLayer.Cell()
                val id = (Math.random() * 4).toInt()
                cell.setTile(tiles[id])
                layer.setCell(x, y, cell)
            }
        }
        layers.add(layer)
        renderer = HexagonalTiledMapRenderer(map)

        printc(World.Cell.FIELD.ordinal())
    }

    fun dispose() {
        renderer.dispose()
        hexture.dispose()
        map.dispose()
    }
}
