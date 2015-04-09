package org.cyberhive

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import org.cyberhive.debug.Debug
import org.cyberhive.screen.MainMenuScreen
import org.cyberhive.storage.Storage
import kotlin.properties.Delegates

class CyberHive() : Game() {
    override fun create() {
        instance = this
        if (Debug.isDebug) {
            setScreen(Debug.getStartScreen())
        } else {
            setScreen(MainMenuScreen())
        }
    }

    companion object {
        var instance: CyberHive by Delegates.notNull()

        fun print(message: Any) {
            Gdx.app.log("CyberHive", message.toString())
        }

        fun setScreen(screen: Screen) {
            instance.setScreen(screen)
        }
    }
}
