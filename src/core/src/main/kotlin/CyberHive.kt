package org.cyberhive

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import org.cyberhive.gui.TopBar
import org.cyberhive.screen.GameScreen
import org.cyberhive.screen.MenuScreen
import kotlin.properties.Delegates

public class CyberHive() : Game() {
    override fun create() {
        instance = this
        setScreen(MenuScreen())

    }

    companion object {
        var instance: CyberHive by Delegates.notNull()
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
