package org.cyberhive.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import org.cyberhive.CyberHive

fun main(arg: Array<String>) {
    val config = LwjglApplicationConfiguration()
    config.width = 800
    config.height = 480
    LwjglApplication(CyberHive(), config)
}
