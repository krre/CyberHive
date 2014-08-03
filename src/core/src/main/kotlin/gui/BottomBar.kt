package org.cyberhive.gui

import org.cyberhive.CyberHive
import com.badlogic.gdx.scenes.scene2d.ui.Stack
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.scenes.scene2d.InputEvent

public class BottomBar() : Stack() {
    {
        setSize(CyberHive.VIRTUAL_WIDTH, 40f)

        val colorBar = Rectangle()
        colorBar.setSize(getWidth(), getHeight())
        colorBar.fillColor = Color.TEAL
        addActor(colorBar)

        val skin = Skin(Gdx.files?.internal("uiskin.json"));
        val nextButton = TextButton("NEXT", skin)
        nextButton.addListener(object: ClickListener() {
            override fun clicked(enent: InputEvent?, x: Float, y: Float) {
                CyberHive.print("next")
            }
        });
        addActor(nextButton)
    }
}
