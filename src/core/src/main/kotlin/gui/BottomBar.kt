package org.cyberhive.gui

import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup
import org.cyberhive.CyberHive
import com.badlogic.gdx.scenes.scene2d.ui.Stack
import com.badlogic.gdx.graphics.Color

public class BottomBar() : Stack() {
    {
        setSize(CyberHive.VIRTUAL_WIDTH, 40f)

        val colorBar = Rectangle()
        colorBar.setSize(getWidth(), getHeight())
        colorBar.fillColor = Color.TEAL
        addActor(colorBar)
    }
}
