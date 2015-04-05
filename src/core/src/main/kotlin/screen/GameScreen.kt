package org.cyberhive.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputAdapter
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.math.Vector2
import org.cyberhive.CyberHive
import org.cyberhive.gui.BottomBar
import org.cyberhive.gui.TopBar
import org.cyberhive.map.HexMap
import org.cyberhive.utils.Constants
import org.cyberhive.utils.OrthoCamController

class GameScreen() : AbstractScreen() {
    val cameraController: OrthoCamController
    val hexMap = HexMap()
    val inputDetector: InputAdapter
    val topBar = TopBar()
    var isDrag = false
    var stageCoords = Vector2()
    val bottomBar = BottomBar()
    init {
        cameraController = OrthoCamController(camera)
        inputDetector = object: InputAdapter() {
            override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
                isDrag = true
                return true
            }

            override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
                if (!isDrag) {
                    CyberHive.print("x = $screenX y = $screenY")
                    stage.screenToStageCoordinates(stageCoords.set(screenX.toFloat(), screenY.toFloat()))
                    CyberHive.print("offset = ${cameraController.offset.x} ${cameraController.offset.y}")

                } else {
                    isDrag = false
                }
                return true
            }
        }

        val inputMultiplexer = InputMultiplexer(stage, cameraController, inputDetector)
        Gdx.input.setInputProcessor(inputMultiplexer)

        topBar.setY(Constants.virtualHeight - topBar.getHeight())
        stage.addActor(topBar)

        bottomBar.setY(0f)
        stage.addActor(bottomBar)
    }

    override fun render(delta: Float) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        camera.update()

        hexMap.renderer.setView(camera)
        hexMap.renderer.render()

        stage.act();
        stage.draw();
    }

    override fun dispose() {
        super.dispose()
        hexMap.dispose()
    }
}
