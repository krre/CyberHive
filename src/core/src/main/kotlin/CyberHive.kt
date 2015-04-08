package org.cyberhive

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import org.cyberhive.debug.Debug
import org.cyberhive.screen.MenuScreen
import org.cyberhive.storage.Storage
import kotlin.properties.Delegates

class CyberHive() : Game() {
    override fun create() {
        instance = this
        if (Debug.isDebug) {
            setScreen(Debug.getStartScreen())
        } else {
            setScreen(MenuScreen())
        }
    }

    companion object {
        var instance: CyberHive by Delegates.notNull()

        fun print(message: Any) {
            Gdx.app.log("CyberHive", message.toString())
        }
    }
}
