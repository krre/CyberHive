package org.cyberhive.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import org.cyberhive.CyberHive

class MenuScreen : AbstractScreen() {
    private val verticalGroup = VerticalGroup()
    init {
        verticalGroup.setFillParent(true)
        stage.addActor(verticalGroup)

        val newGameButton = TextButton("New Game", skin)
        newGameButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                CyberHive.instance.setScreen(WorldScreen())
            }
        })
        verticalGroup.addActor(newGameButton)


        val loadGameButton = TextButton("Load Game", skin)
        loadGameButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                CyberHive.instance.setScreen(GameScreen())
            }
        })
        verticalGroup.addActor(loadGameButton)

        val exitButton = TextButton("Exit", skin)
        exitButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                Gdx.app.exit()
            }
        })
        verticalGroup.addActor(exitButton)
    }
}
