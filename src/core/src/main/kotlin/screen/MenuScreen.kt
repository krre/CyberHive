package org.cyberhive.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Button
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.viewport.FitViewport
import org.cyberhive.CyberHive
import org.cyberhive.utils.Constants

class MenuScreen : ScreenAdapter() {
    val camera = OrthographicCamera()
    val stage = Stage(FitViewport(Constants.virtualWidth, Constants.virtualHeight))
    private val verticalGroup = VerticalGroup()
    init {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f)
        camera.setToOrtho(false, Constants.virtualWidth, Constants.virtualHeight)
        Gdx.input.setInputProcessor(stage)

        verticalGroup.setFillParent(true)
        stage.addActor(verticalGroup)
        val skin = Skin(Gdx.files.internal("uiskin.json"))

        val newGameButton = TextButton("New Game", skin)
        newGameButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                CyberHive.print("new game")
            }
        })
        verticalGroup.addActor(newGameButton)


        val loadGameButton = TextButton("Load Game", skin)
        loadGameButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                CyberHive.instance.setScreen(GameScreen())
            }
        })
        verticalGroup.addActor(loadGameButton)

        val exitButton = TextButton("Exit", skin)
        exitButton.addListener(object: ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                Gdx.app.exit()
            }
        })
        verticalGroup.addActor(exitButton)
    }

    override fun render(delta: Float) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        stage.act();
        stage.draw();
    }

    override fun resize(width: Int, height: Int) {
        stage.getViewport().update(width, height, false)
    }

    override fun dispose() {
        stage.dispose()
    }

}
