package org.cyberhive.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import org.cyberhive.CyberHive

public fun main(arg: Array<String>) {
    val config = LwjglApplicationConfiguration()
    config.width = 1280
    config.height = 720
    LwjglApplication(CyberHive(), config)
}
