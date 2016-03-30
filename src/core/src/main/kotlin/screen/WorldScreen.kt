package org.cyberhive.screen

import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import org.cyberhive.CyberHive
import org.cyberhive.logic.World
import org.cyberhive.storage.Storage
import org.cyberhive.utils.Constants
import java.util.Random

class WorldScreen : AbstractScreen() {
    private val sizeSelectBox = SelectBox<String>(skin)
    private val climateSelectBox = SelectBox<String>(skin)
    private val geoSelectBox = SelectBox<String>(skin)
    private val landscapeSelectBox = SelectBox<String>(skin)

    init {
        val mainTable = Table()
        mainTable.setFillParent(true)
        stage.addActor(mainTable)
        mainTable.debug()

        val settingsTable = Table()
        var buttonsTable = Table()

        mainTable.add(settingsTable).width(550f)
        settingsTable.defaults().height(50f).space(10f)

        settingsTable.add(Label("Size:", skin))
        sizeSelectBox.setItems("Small", "Normal", "Large")
        settingsTable.add(sizeSelectBox)
        settingsTable.row()

        settingsTable.add(Label("Climate:", skin))
        climateSelectBox.setItems("Cold", "Normal", "Hot")
        settingsTable.add(climateSelectBox)
        settingsTable.row()

        settingsTable.add(Label("Geo:", skin))
        geoSelectBox.setItems("Island", "Coast", "Сontinent")
        settingsTable.add(geoSelectBox)
        settingsTable.row()

        settingsTable.add(Label("Landscape:", skin))
        landscapeSelectBox.setItems("Desert", "Mountains", "Forest", "River")
        settingsTable.add(landscapeSelectBox)
        settingsTable.row()

        mainTable.add(buttonsTable).width(250f)
        buttonsTable.defaults().width(200f).height(50f).space(10f)

        val randomWorldButton = TextButton("Random World", skin)
        randomWorldButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                randomProperties()
            }
        })
        buttonsTable.add(randomWorldButton)
        buttonsTable.row()

        val playButton = TextButton("Play", skin)
        playButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                createWorld()
            }
        })
        buttonsTable.add(playButton)
        buttonsTable.row()

        val backButton = TextButton("Back", skin)
        backButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                CyberHive.setScreen(MainMenuScreen())
            }
        })
        buttonsTable.add(backButton)
    }

    fun randInt(min: Int, max: Int): Int {
        val rand = Random()
        return rand.nextInt((max - min) + 1) + min
    }

    fun randomProperties() {
        sizeSelectBox.setSelectedIndex(randInt(0, 2))
        climateSelectBox.setSelectedIndex(randInt(0, 2))
        geoSelectBox.setSelectedIndex(randInt(0, 2))
        landscapeSelectBox.setSelectedIndex(randInt(0, 3))
    }

    fun createWorld() {
        val dimension = when(sizeSelectBox.getSelectedIndex()) {
            World.Size.SMALL.ordinal -> 10
            World.Size.NORMAL.ordinal -> 20
            World.Size.LARGE.ordinal -> 20
            else -> 0
        }

        Storage.hardwareArray = Array(dimension, { IntArray(dimension) })
        Storage.softwareArray = Array(dimension, { IntArray(dimension) })
        Storage.virtualArray = Array(dimension, { IntArray(dimension) })

        Storage.cameraX = Constants.virtualWidth / 2f
        Storage.cameraY = Constants.virtualHeight / 2f
        Storage.cameraZoom = 1.0f

        CyberHive.setScreen(GameScreen())
    }
}