abstract class Shape {
    abstract fun area(): Double
    abstract fun perimeter(): Double
}

// Créer la classe Circle qui hérite de Shape et qui a un attribut radius de type Double
class Circle(val radius: Double) : Shape() {
    override fun area(): Double {
        return Math.PI * radius * radius
    }

    override fun perimeter(): Double {
        return 2 * Math.PI * radius
    }
}

// Créer la classe Rectangle qui hérite de Shape et qui a deux attributs width et height de type Double
open class Rectangle(val width: Double, val height: Double) : Shape() {
    override fun area(): Double {
        return width * height
    }

    override fun perimeter(): Double {
        return 2 * (width + height)
    }
}

// Créer la classe Square qui hérite de Rectangle ou de Shape, au choix.
class Square(side: Double) : Rectangle(side, side)

fun main(args: Array<String>) {
    val shapes = listOf(
            Circle(2.0),
            Rectangle(2.0, 3.0),
            Square(2.0)
    )
    println(shapes.map { it.area() })
}

fun testCircle(radius: Double) : Shape {
    return Circle(radius)
}

fun testRectangle(width: Double, height: Double) : Shape {
    return Rectangle(width, height)
}

fun testSquare(side: Double) : Shape {
    return Square(side)
}