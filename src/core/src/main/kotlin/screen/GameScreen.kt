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

public class GameScreen(var game: CyberHive) : Screen {
    val camera = OrthographicCamera()
    val hexMap = HexMap()
    val stage = Stage()
    val topBar = TopBar();
    val bootmBar = BottomBar();
    {
        Gdx.input?.setInputProcessor(stage)
        camera.setToOrtho(false, CyberHive.VIRTUAL_WIDTH, CyberHive.VIRTUAL_HEIGHT)

        topBar.setY(CyberHive.VIRTUAL_HEIGHT - topBar.getHeight())
        stage.addActor(topBar)

        bootmBar.setY(0f)
        stage.addActor(bootmBar)
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
