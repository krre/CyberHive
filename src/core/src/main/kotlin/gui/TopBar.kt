package org.cyberhive.gui

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import org.cyberhive.CyberHive
import org.cyberhive.storage.Storage
import org.cyberhive.utils.Constants

class TopBar() : Stack() {
    val energyLabel: Label
    val populationLabel: Label
    val blackoutLabel: Label
    init {
        Storage.topBar = this
        setSize(Constants.virtualWidth, 40f)
        val skin = Skin(Gdx.files.internal("uiskin.json"));

        val colorBar = Rectangle()
        colorBar.setSize(getWidth(), getHeight())
        colorBar.fillColor = Color.TEAL
        addActor(colorBar)

        val table = Table()
        table.setSize(getWidth(), getHeight())
        table.defaults().space(10f)
        addActor(table)

        energyLabel = Label("", skin)
        updateEnergy()
        table.add(energyLabel)

        val splitter0 = Rectangle()
        splitter0.setSize(2f, getHeight())
        table.add(splitter0)

        populationLabel = Label("", skin)
        updatePopulation()
        table.add(populationLabel)

        val splitter1 = Rectangle()
        splitter1.setSize(2f, getHeight())
        table.add(splitter1)

        blackoutLabel = Label("", skin)
        updateBlackout()
        table.add(blackoutLabel)

        val splitter2 = Rectangle()
        splitter2.setSize(2f, getHeight())
        table.add(splitter2)

        val plusButton = TextButton("+", skin)
        plusButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                CyberHive.print("+")
            }
        })
        table.add(plusButton).width(40f)

        val minusButton = TextButton("-", skin)
        minusButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                CyberHive.print("-")
            }
        })
        table.add(minusButton).width(40f)

        val menuButton = TextButton("Menu", skin)
        menuButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                CyberHive.print("menu")
            }
        })
        table.add(menuButton).width(60f)
    }

    fun updateEnergy() {
        energyLabel.setText("Energy: ${Storage.energy} (${Storage.energyDynamic})")
    }

    fun updatePopulation() {
        populationLabel.setText("Population: ${Storage.population} (${Storage.populationDynamic})")
    }

    fun updateBlackout() {
        blackoutLabel.setText("Blackout: ${Storage.blackout}")
    }
}

