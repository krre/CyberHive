package org.cyberhive.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.utils.viewport.FitViewport
import org.cyberhive.utils.Constants

open class AbstractScreen : ScreenAdapter() {
    val camera = OrthographicCamera()
    val stage = Stage(FitViewport(Constants.virtualWidth, Constants.virtualHeight))
//    val skin = Skin()
    val skin = Skin(Gdx.files.internal("uiskin.json"))
    init {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f)
        camera.setToOrtho(false, Constants.virtualWidth, Constants.virtualHeight)
        Gdx.input.setInputProcessor(stage)

//        unfortunately does not work
//        val generator = FreeTypeFontGenerator(Gdx.files.internal("fonts/arial.ttf"))
//        val parameter = FreeTypeFontGenerator.FreeTypeFontParameter()
//        parameter.size = 17
//        val font = generator.generateFont(parameter)
//        font.setColor(Color.RED)
//        generator.dispose()

//        skin.add("default-font", font, javaClass<BitmapFont>())
//        skin.addRegions(TextureAtlas(Gdx.files.internal("uiskin.atlas")))
//        skin.load(Gdx.files.internal("uiskin.json"))
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
