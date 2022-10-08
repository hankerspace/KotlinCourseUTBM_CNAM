// version 1.1.4-3

import java.awt.*
import java.awt.Shape
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.SwingUtilities

object Renderer : JPanel() {

    val shapes = mutableListOf<Drawable>()

    init {
        preferredSize = Dimension(800, 800)
        background = Color.white
    }

    override fun paint(gg: Graphics) {
        super.paintComponent(gg)
        val g = gg as Graphics2D
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON)

        shapes.forEach {
            g.color = it.getShapeColor()
            val vertices = it.getAllVertices()
            val x = vertices.map { it.x }.toIntArray()
            val y = vertices.map { it.y }.toIntArray()
            g.drawPolygon(x, y, vertices.size)
        }
    }

    fun render(shapes: List<Drawable>) {
        this.shapes += shapes
        SwingUtilities.invokeLater {
            val f = JFrame()
            with (f) {
                defaultCloseOperation = JFrame.EXIT_ON_CLOSE
                title = "Shapes"
                isResizable = false
                add(this@Renderer, BorderLayout.CENTER)
                pack()
                setLocationRelativeTo(null)
                isVisible = true
            }
        }
    }
}
