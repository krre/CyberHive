package org.cyberhive

import com.badlogic.gdx.Game
import org.cyberhive.screen.GameScreen
import com.badlogic.gdx.Gdx

public class CyberHive() : Game() {
    override fun create() {
        setScreen(GameScreen(this))
    }

    override fun render() {
        super.render()
    }

    class object {
        val VIRTUAL_WIDTH: Float = 800f
        val VIRTUAL_HEIGHT: Float = 480f

        fun print(message: String) {
            Gdx.app?.log("CyberHive", message)
        }
    }
}
