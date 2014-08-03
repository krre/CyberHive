package org.cyberhive.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import org.cyberhive.CyberHive
import org.cyberhive.map.HexMap
import com.badlogic.gdx.scenes.scene2d.Stage
import org.cyberhive.gui.TopBar
import org.cyberhive.gui.BottomBar
import org.cyberhive.utils.OrthoCamController
import com.badlogic.gdx.InputMultiplexer

public class GameScreen(var game: CyberHive) : Screen {
    val camera = OrthographicCamera()
    var cameraController: OrthoCamController
    val hexMap = HexMap()
    val stage = Stage()
    val topBar = TopBar()
    val bottomBar = BottomBar();
    {
        camera.setToOrtho(false, CyberHive.virtualWidth, CyberHive.virtualHeight)
        cameraController = OrthoCamController(camera)

        val inputMultiplexer = InputMultiplexer(stage, cameraController)
        Gdx.input?.setInputProcessor(inputMultiplexer)

        topBar.setY(CyberHive.virtualHeight - topBar.getHeight())
        stage.addActor(topBar)

        bottomBar.setY(0f)
        stage.addActor(bottomBar)
    }


    override fun render(delta: Float) {
        Gdx.gl?.glClearColor(1f, 1f, 1f, 1f)
        Gdx.gl?.glClear(GL20.GL_COLOR_BUFFER_BIT)

        camera.update()

        hexMap.renderer.setView(camera)
        hexMap.renderer.render()

        stage.act();
        stage.draw();
    }

    override fun resize(width: Int, height: Int) {
        stage.getViewport()?.update(width, height, true)
    }

    override fun show() {
    }

    override fun hide() {
    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun dispose() {
        hexMap.dispose()
        stage.dispose()
    }
}
