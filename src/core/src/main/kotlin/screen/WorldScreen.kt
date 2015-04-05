package org.cyberhive.screen

import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import org.cyberhive.CyberHive

class WorldScreen : AbstractScreen() {
    private val verticalGroup = VerticalGroup()
    init {
        verticalGroup.setFillParent(true)
        stage.addActor(verticalGroup)

        val newWorldButton = TextButton("New World", skin)
        newWorldButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                CyberHive.print("new world")
            }
        })
        verticalGroup.addActor(newWorldButton)

        val startButton = TextButton("Start Game", skin)
        startButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                CyberHive.instance.setScreen(GameScreen())
            }
        })
        verticalGroup.addActor(startButton)
    }
}