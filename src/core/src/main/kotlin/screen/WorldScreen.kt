package org.cyberhive.screen

import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import org.cyberhive.CyberHive

class WorldScreen : AbstractScreen() {
    init {
        val mainTable = Table()
        mainTable.setFillParent(true)
        stage.addActor(mainTable)
        mainTable.debug()

        val settingsTable = Table()
        var buttonsTable = Table()

        mainTable.add(settingsTable).width(550f)
        mainTable.add(buttonsTable).width(250f)

        buttonsTable.defaults().width(200f).height(50f).space(10f)

        val randomWorldButton = TextButton("Random World", skin)
        randomWorldButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                CyberHive.print("random world")
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
}