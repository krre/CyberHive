package org.cyberhive.debug

import com.badlogic.gdx.Screen
import org.cyberhive.screen.GameScreen
import org.cyberhive.screen.MenuScreen
import org.cyberhive.screen.WorldScreen

object Debug {
    val isDebug = true
    val startScreen = "Game"

    fun getStartScreen() : Screen {
        return when (startScreen) {
            "Menu" -> MenuScreen()
            "World" -> WorldScreen()
            "Game" -> GameScreen()
            else -> MenuScreen()
        }
    }
}
