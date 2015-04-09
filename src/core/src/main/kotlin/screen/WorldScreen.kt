package org.cyberhive.screen

import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import org.cyberhive.CyberHive
import java.util.Random

class WorldScreen : AbstractScreen() {
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
        val sizeSelectBox = SelectBox<String>(skin)
        sizeSelectBox.setItems("Small", "Normal", "Large")
        settingsTable.add(sizeSelectBox)
        settingsTable.row()

        settingsTable.add(Label("Climate:", skin))
        val climateSelectBox = SelectBox<String>(skin)
        climateSelectBox.setItems("Cold", "Normal", "Hot")
        settingsTable.add(climateSelectBox)
        settingsTable.row()

        settingsTable.add(Label("Geo:", skin))
        val geoSelectBox = SelectBox<String>(skin)
        geoSelectBox.setItems("Island", "Coast", "Сontinent")
        settingsTable.add(geoSelectBox)
        settingsTable.row()

        settingsTable.add(Label("Landscape:", skin))
        val landscapeSelectBox = SelectBox<String>(skin)
        landscapeSelectBox.setItems("Desert", "Mountains", "Forest", "River")
        settingsTable.add(landscapeSelectBox)
        settingsTable.row()

        mainTable.add(buttonsTable).width(250f)
        buttonsTable.defaults().width(200f).height(50f).space(10f)

        val randomWorldButton = TextButton("Random World", skin)
        randomWorldButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                sizeSelectBox.setSelectedIndex(randInt(0, 2))
                climateSelectBox.setSelectedIndex(randInt(0, 2))
                geoSelectBox.setSelectedIndex(randInt(0, 2))
                landscapeSelectBox.setSelectedIndex(randInt(0, 3))
            }
        })
        buttonsTable.add(randomWorldButton)
        buttonsTable.row()

        val playButton = TextButton("Play", skin)
        playButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                CyberHive.instance.setScreen(GameScreen())
            }
        })
        buttonsTable.add(playButton)
        buttonsTable.row()

        val backButton = TextButton("Back", skin)
        backButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                CyberHive.instance.setScreen(MenuScreen())
            }
        })
        buttonsTable.add(backButton)
    }

    fun randInt(min: Int, max: Int): Int {
        val rand = Random()
        return rand.nextInt((max - min) + 1) + min
    }
}