package org.cyberhive

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import org.cyberhive.screen.GameScreen

public class CyberHive() : Game() {
    override fun create() {
        setScreen(GameScreen(this))
    }

    override fun render() {
        super.render()
    }

    class object {
        public val VIRTUAL_WIDTH: Int = 800
        public val VIRTUAL_HEIGHT: Int = 480
    }
}
