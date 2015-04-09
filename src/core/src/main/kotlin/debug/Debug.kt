package org.cyberhive.debug

import com.badlogic.gdx.Screen
import org.cyberhive.screen.*

object Debug {
    val isDebug = true
    val startScreen = "Game"

    fun getStartScreen() : Screen {
        return when (startScreen) {
            "MainMenu" -> MainMenuScreen()
            "GameMenu" -> GameMenuScreen()
            "World" -> WorldScreen()
            "Game" -> GameScreen()
            "Settings" -> SettingsScreen()
            else -> MainMenuScreen()
        }
    }
}
