package org.cyberhive.screen

import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import org.cyberhive.CyberHive
import org.cyberhive.utils.Constants

class GameMenuScreen : AbstractScreen() {
    init {
        val table = Table()
        table.setFillParent(true)
        table.defaults().width(300f).height(50f).space(10f)
        stage.addActor(table)

        val continueButton = TextButton("Continue", skin)
        continueButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                CyberHive.setScreen(GameScreen())
            }
        })
        table.add(continueButton)
        table.row()

        val loadGameButton = TextButton("Load Game", skin)
        loadGameButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                CyberHive.setScreen(FileScreen(Constants.load))
            }
        })
        table.add(loadGameButton)
        table.row()

        val saveGameButton = TextButton("Save Game", skin)
        saveGameButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                CyberHive.setScreen(FileScreen(Constants.save))
            }
        })
        table.add(saveGameButton)
        table.row()

        val settingsButton = TextButton("Settings", skin)
        settingsButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                CyberHive.setScreen(SettingsScreen())
            }
        })
        table.add(settingsButton)
        table.row()

        val mainMenuButton = TextButton("Main Menu", skin)
        mainMenuButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                CyberHive.setScreen(MainMenuScreen())
            }
        })
        table.add(mainMenuButton)
    }
}
