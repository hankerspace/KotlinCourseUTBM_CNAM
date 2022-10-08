import java.awt.Color
import kotlin.math.cos
import kotlin.math.sin

data class Point(val x: Int, val y: Int)

interface Drawable {
    fun getAllVertices(): List<Point>
    fun getShapeColor() : Color
}

// Créez les classes Circle, Rectangle, Square et Triangle qui implémentent l'interface Drawable
// Vous pouvez créer des classes supplémentaires si vous le souhaitez
// Les classes Circle, Rectangle et Square doivent avoir un constructeur prenant en paramètre un Point représentant le centre

abstract class Shape(val color: Color) : Drawable {
    override fun getShapeColor() = color
}

class Circle(val center: Point, val radius: Int, color: Color) : Shape(color) {
    override fun getAllVertices(): List<Point> {
        val vertices = mutableListOf<Point>()
        var angle = 0.0
        do {
            val radAngle = angle * 2.0 * Math.PI
            val x = (center.x + radius * cos(radAngle)).toInt()
            val y = (center.y + radius * sin(radAngle)).toInt()
            vertices.add(Point(x, y))
            angle += 0.01
        } while (angle < 360)

        return vertices
    }
}

open class Rectangle(val topLeft: Point, val width: Int, val height: Int, color: Color) : Shape(color) {
    override fun getAllVertices(): List<Point> {
        val vertices = mutableListOf<Point>()
        vertices.add(topLeft)
        vertices.add(Point(topLeft.x + width, topLeft.y))
        vertices.add(Point(topLeft.x + width, topLeft.y + height))
        vertices.add(Point(topLeft.x, topLeft.y + height))
        return vertices
    }
}

class Square(topLeft: Point, width: Int, color: Color) : Rectangle(topLeft, width, width, color)

class Triangle(val p1: Point, val p2: Point, val p3: Point, color: Color) : Shape(color) {
    override fun getAllVertices(): List<Point> {
        val vertices = mutableListOf<Point>()
        vertices.add(p1)
        vertices.add(p2)
        vertices.add(p3)
        return vertices
    }
}

fun main() {
    // Create a list of 100 random shapes
    val randomShapes = take100RandomShapes()

    Renderer.render(randomShapes)
}

val take100RandomShapes = {
    (1..100).map {
        val color = Color((Math.random() * 0x1000000).toInt())
        when ((Math.random() * 4).toInt()) {
            0 -> Circle(Point((Math.random() * 800).toInt(), (Math.random() * 800).toInt()), (Math.random() * 200).toInt(), color)
            1 -> Rectangle(Point((Math.random() * 800).toInt(), (Math.random() * 800).toInt()), (Math.random() * 100).toInt(), (Math.random() * 100).toInt(), color)
            2 -> Square(Point((Math.random() * 800).toInt(), (Math.random() * 800).toInt()), (Math.random() * 100).toInt(), color)
            else -> Triangle(Point((Math.random() * 800).toInt(), (Math.random() * 800).toInt()), Point((Math.random() * 800).toInt(), (Math.random() * 800).toInt()), Point((Math.random() * 800).toInt(), (Math.random() * 800).toInt()), color)
        }
    }
}
