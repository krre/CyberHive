package org.cyberhive.gui

import com.badlogic.gdx.graphics.g2d.Batch
import org.cyberhive.CyberHive
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup
import com.badlogic.gdx.scenes.scene2d.Actor

open class Rectangle() : Actor() {
    var fillColor = Color.WHITE
    set(value) { renderer.setColor(value) }
    private val renderer = ShapeRenderer();
    {
        setSize(100f, 100f)
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

