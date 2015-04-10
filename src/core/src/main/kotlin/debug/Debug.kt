package org.cyberhive.debug

import com.badlogic.gdx.Screen
import org.cyberhive.screen.*
import org.cyberhive.utils.Constants
import org.cyberhive.utils.File

object Debug {
    val isDebug = false
    val startScreen = "World"

    fun getStartScreen() : Screen {
        return when (startScreen) {
            "MainMenu" -> MainMenuScreen()
            "GameMenu" -> GameMenuScreen()
            "World" -> WorldScreen()
            "Game" -> GameScreen()
            "Settings" -> SettingsScreen()
            "FileLoad" -> FileScreen(File.LOAD)
            "FileSave" -> FileScreen(File.SAVE)
            else -> MainMenuScreen()
        }
    }
}
