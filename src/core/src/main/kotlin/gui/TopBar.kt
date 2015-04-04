package org.cyberhive.gui

import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.Gdx
import org.cyberhive.CyberHive
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup
import com.badlogic.gdx.scenes.scene2d.ui.Stack
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import org.cyberhive.utils.Constants

public class TopBar() : Stack() {
    val energyLabel: Label
    val populationLabel: Label
    val blackoutLabel: Label
    init {
        CyberHive.topBar = this
        setSize(Constants.virtualWidth, 40f)
        val skin = Skin(Gdx.files?.internal("uiskin.json"));

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

        energyLabel = Label("", skin)
        updateEnergy()
        horizontalGroup.addActor(energyLabel)

        val splitter0 = Rectangle()
        splitter0.setSize(2f, getHeight())
        horizontalGroup.addActor(splitter0)

        populationLabel = Label("", skin)
        updatePopulation()
        horizontalGroup.addActor(populationLabel)

        val splitter1 = Rectangle()
        splitter1.setSize(2f, getHeight())
        horizontalGroup.addActor(splitter1)

        blackoutLabel = Label("", skin)
        updateBlackout()
        horizontalGroup.addActor(blackoutLabel)

        val splitter2 = Rectangle()
        splitter2.setSize(2f, getHeight())
        horizontalGroup.addActor(splitter2)
    }

    fun updateEnergy() {
        energyLabel.setText("Energy: ${CyberHive.energy} (${CyberHive.energyDynamic})")
    }

    fun updatePopulation() {
        populationLabel.setText("Population: ${CyberHive.population} (${CyberHive.populationDynamic})")
    }

    fun updateBlackout() {
        blackoutLabel.setText("Blackout: ${CyberHive.blackout}")
    }
}

