package org.cyberhive.gui

import org.cyberhive.CyberHive
import com.badlogic.gdx.scenes.scene2d.ui.Stack
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.scenes.scene2d.InputEvent
import org.cyberhive.utils.Constants

public class BottomBar() : Stack() {
    init {
        setSize(Constants.virtualWidth, 40f)

        val colorBar = Rectangle()
        colorBar.setSize(getWidth(), getHeight())
        colorBar.fillColor = Color.TEAL
        addActor(colorBar)

        val skin = Skin(Gdx.files?.internal("uiskin.json"));
        val nextButton = TextButton("NEXT", skin)
        nextButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                CyberHive.energy += 1
                CyberHive.topBar?.updateEnergy()
            }
        })
        addActor(nextButton)
    }
}
