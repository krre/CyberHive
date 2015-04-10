package org.cyberhive.screen

import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import org.cyberhive.CyberHive
import org.cyberhive.utils.Constants
import org.cyberhive.utils.File

class FileScreen(val operation: File) : AbstractScreen() {
    init {
        val table = Table()
        table.setFillParent(true)
        table.defaults().width(300f).height(50f).space(10f)
        stage.addActor(table)

        if (operation == File.LOAD) {
            val loadButton = TextButton("Load", skin)
            loadButton.addListener(object : ClickListener() {
                override fun clicked(event: InputEvent, x: Float, y: Float) {
                    CyberHive.setScreen(GameScreen())
                }
            })
            table.add(loadButton)
            table.row()
        } else if (operation == File.SAVE) {
            val saveButton = TextButton("Save", skin)
            saveButton.addListener(object : ClickListener() {
                override fun clicked(event: InputEvent, x: Float, y: Float) {
                    CyberHive.setScreen(GameScreen())
                }
            })
            table.add(saveButton)
        }
    }
}
