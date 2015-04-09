package org.cyberhive.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import org.cyberhive.CyberHive
import org.cyberhive.storage.Storage

class MainMenuScreen : AbstractScreen() {
    init {
        val table = Table()
        table.setFillParent(true)
        table.defaults().width(300f).height(50f).space(10f)
        stage.addActor(table)

        val newGameButton = TextButton("New Game", skin)
        newGameButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                CyberHive.setScreen(WorldScreen())
            }
        })
        table.add(newGameButton)
        table.row()

        if (!Storage.prefs.get().isEmpty()) {
            val loadGameButton = TextButton("Load Game", skin)
            loadGameButton.addListener(object : ClickListener() {
                override fun clicked(event: InputEvent, x: Float, y: Float) {
                    Storage.loadStorage()
                    CyberHive.setScreen(GameScreen())
                }
            })
            table.add(loadGameButton)
            table.row()
        }

        val settingsButton = TextButton("Settings", skin)
        settingsButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                CyberHive.setScreen(SettingsScreen())
            }
        })
        table.add(settingsButton)
        table.row()

        val exitButton = TextButton("Exit", skin)
        exitButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                Gdx.app.exit()
            }
        })
        table.add(exitButton)
    }
}
