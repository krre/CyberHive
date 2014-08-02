package org.cyberhive.gui

import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.graphics.g2d.Batch
import org.cyberhive.CyberHive
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType
import com.badlogic.gdx.graphics.Color

open class Bar() : Actor() {
    private val renderer = ShapeRenderer();
    private val HEIGHT = 40f
    {
        setWidth(CyberHive.VIRTUAL_WIDTH)
        setHeight(HEIGHT)
        renderer.setColor(Color.TEAL)
    }

    override fun draw(batch: Batch?, parentAlpha: Float) {
        batch?.end()

        renderer.setProjectionMatrix(batch?.getProjectionMatrix());
        renderer.setTransformMatrix(batch?.getTransformMatrix());
        renderer.translate(getX(), getY(), 0f);

        renderer.begin(ShapeType.Filled)
        renderer.rect(0f, 0f, getWidth(), getHeight())
        renderer.end()

        batch?.begin()

    }
}

