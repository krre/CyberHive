package org.cyberhive.utils

import com.badlogic.gdx.InputAdapter
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.math.Vector3
import org.cyberhive.CyberHive

class OrthoCamController(val camera: OrthographicCamera) : InputAdapter() {
    val curr = Vector3()
    val last = Vector3(-1f, -1f, -1f)
    val delta = Vector3()
    val offset = Vector3()

    override fun touchDragged(x: Int, y: Int, pointer: Int): Boolean {
        camera.unproject(curr.set(x.toFloat(), y.toFloat(), 0f))
        if (!(last.x == -1f && last.y == -1f && last.z == -1f)) {
            camera.unproject(delta.set(last.x, last.y, 0f))
            delta.sub(curr)
            camera.position.add(delta.x, delta.y, 0f)
            offset.set(offset.x + delta.x, offset.y + delta.y, 0f)
        }
        last.set(x.toFloat(), y.toFloat(), 0f)
        return false
    }

    override fun touchUp(x: Int, y: Int, pointer: Int, button: Int): Boolean {
        last.set(-1f, -1f, -1f)
        return false
    }
}
