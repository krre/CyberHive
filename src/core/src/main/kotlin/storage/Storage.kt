package org.cyberhive.storage

import com.badlogic.gdx.Gdx
import org.cyberhive.gui.TopBar
import org.cyberhive.utils.Constants

object Storage {
    var energy = 0
    var energyDynamic = 0
    var population = 0
    var populationDynamic = 0
    var blackout = 0

    var topBar: TopBar? = null

    var hardwareArray: Array<IntArray>? = null
    var softwareArray: Array<IntArray>? = null
    var virtualArray: Array<IntArray>? = null

    var cameraX: Float = 0f
    var cameraY: Float = 0f
    var cameraZoom: Float = 0f

    val prefs = Gdx.app.getPreferences("Cyberhive")

    fun loadStorage() {
        cameraX = prefs.getFloat("cameraX")
        cameraY = prefs.getFloat("cameraY")
        cameraZoom = prefs.getFloat("cameraZoom")
    }
}
