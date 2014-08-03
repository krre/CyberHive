package org.cyberhive

import com.badlogic.gdx.Game
import org.cyberhive.screen.GameScreen
import com.badlogic.gdx.Gdx
import org.cyberhive.gui.TopBar

public class CyberHive() : Game() {
    override fun create() {
        setScreen(GameScreen(this))
    }

    override fun render() {
        super.render()
    }

    class object {
        val virtualWidth = 800f
        val virtualHeight = 480f

        var energy = 0
        var energyDynamic = 0
        var population = 0
        var populationDynamic = 0
        var blackout = 0

        var topBar: TopBar? = null

        fun print(message: String) {
            Gdx.app?.log("CyberHive", message)
        }
    }
}
