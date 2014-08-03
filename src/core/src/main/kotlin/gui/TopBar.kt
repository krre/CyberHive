package org.cyberhive.gui

import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Batch
import org.cyberhive.CyberHive
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup
import com.badlogic.gdx.scenes.scene2d.ui.Stack

public class TopBar() : Stack() {
    val energyLabel: Label
    val populationLabel: Label
    val blackoutLabel: Label
    val labelStyle =  Label.LabelStyle(BitmapFont(), Color.WHITE);
    {
        setSize(CyberHive.VIRTUAL_WIDTH, 40f)

        val colorBar = Rectangle()
        colorBar.setSize(getWidth(), getHeight())
        colorBar.fillColor = Color.TEAL
        addActor(colorBar)

        val horizontalGroup = HorizontalGroup()
        horizontalGroup.setSize(getWidth(), getHeight())
        horizontalGroup.space(10f)
        horizontalGroup.pad(10f)
        horizontalGroup.fill()
        addActor(horizontalGroup)

        energyLabel = Label("Energy: ${CyberHive.ENERGY} (${CyberHive.ENERGY_DYNAMIC})", labelStyle)
        horizontalGroup.addActor(energyLabel)

        val splitter0 = Rectangle()
        splitter0.setSize(2f, getHeight())
        horizontalGroup.addActor(splitter0)

        populationLabel = Label("Population: ${CyberHive.POPULATION} (${CyberHive.POPULATION_DYNAMIC})", labelStyle)
        horizontalGroup.addActor(populationLabel)

        val splitter1 = Rectangle()
        splitter1.setSize(2f, getHeight())
        horizontalGroup.addActor(splitter1)

        blackoutLabel = Label("Blackout: ${CyberHive.BLACKOUT}", labelStyle)
        horizontalGroup.addActor(blackoutLabel)

        val splitter2 = Rectangle()
        splitter2.setSize(2f, getHeight())
        horizontalGroup.addActor(splitter2)
    }
}

