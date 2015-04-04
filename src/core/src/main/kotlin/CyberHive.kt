package org.cyberhive

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import org.cyberhive.gui.TopBar
import org.cyberhive.screen.GameScreen
import org.cyberhive.screen.MenuScreen

public class CyberHive() : Game() {
    override fun create() {
        setScreen(GameScreen())
    }

    companion object {
        var energy = 0
        var energyDynamic = 0
        var population = 0
        var populationDynamic = 0
        var blackout = 0

        var topBar: TopBar? = null

        fun print(message: Any) {
            Gdx.app.log("CyberHive", message.toString())
        }
    }
}
