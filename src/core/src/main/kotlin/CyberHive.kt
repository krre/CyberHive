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
        val VIRTUAL_WIDTH = 800f
        val VIRTUAL_HEIGHT = 480f

        var ENERGY = 0
        var ENERGY_DYNAMIC = 0
        var POPULATION = 0
        var POPULATION_DYNAMIC = 0
        var BLACKOUT = 0

        fun print(message: String) {
            Gdx.app?.log("CyberHive", message)
        }
    }
}
