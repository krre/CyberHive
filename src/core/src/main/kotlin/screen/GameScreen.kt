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
import com.badlogic.gdx.InputAdapter
import com.badlogic.gdx.math.Vector2

public class GameScreen(var game: CyberHive) : Screen {
    val camera = OrthographicCamera()
    val cameraController: OrthoCamController
    val hexMap = HexMap()
    val stage = Stage()
    val inputDetector: InputAdapter
    val topBar = TopBar()
    var isDrag = false
    var stageCoords = Vector2()
    val bottomBar = BottomBar();
    init {
        camera.setToOrtho(false, CyberHive.virtualWidth, CyberHive.virtualHeight)
        cameraController = OrthoCamController(camera)
        inputDetector = object: InputAdapter() {
            override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
                isDrag = true
                return true
            }

            override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
                if (!isDrag) {
                    CyberHive.print("x = ${screenX} y = ${screenY}")
                    stage.screenToStageCoordinates(stageCoords.set(screenX.toFloat(), screenY.toFloat()))
                    CyberHive.print("offset = ${cameraController.offset.x} ${cameraController.offset.y}")

                } else {
                    isDrag = false
                }
                return true
            }
        }

        val inputMultiplexer = InputMultiplexer(stage, cameraController, inputDetector)
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
