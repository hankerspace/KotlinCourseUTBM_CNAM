// Créez une enum ShapeType qui possède un attribut privé sides qui indique le nombre de côtés de chaque shape.
// Peuplez votre enum avec différentes formes (Triangle, Square, Pentagon, Hexagon, Heptagon, Octagon, Nonagon, Decagon, ...).
// Créez une méthode getSidesCount qui retourne le nombre de côtés de la forme.
enum class ShapeType(private val sides: Int) {
    CIRCLE(0),
    SQUARE(4),
    TRIANGLE(3),
    PENTAGON(5),
    HEXAGON(6),
    HEPTAGON(7),
    OCTAGON(8),
    NONAGON(9),
    DECAGON(10),
    HENDECAGON(11),
    DODECAGON(12);

    fun getSidesCount() : Int {
        return sides
    }
}

// Créez une classe Shape qui prend en paramètre de constructeur un ShapeType.
// Surcharguez la méthode toString() pour qu'elle utilise ShapeType::printSides().
// Exemple de sortie: SQUARE has 4 sides
class Shape(val shapeType: ShapeType) {
    override fun toString(): String = "${shapeType.name} has ${shapeType.getSidesCount()} sides"
}

fun main(args: Array<String>) {
    val shapes = listOf(Shape(ShapeType.CIRCLE), Shape(ShapeType.SQUARE), Shape(ShapeType.TRIANGLE), Shape(ShapeType.PENTAGON), Shape(ShapeType.HEXAGON), Shape(ShapeType.HEPTAGON), Shape(ShapeType.OCTAGON), Shape(ShapeType.NONAGON), Shape(ShapeType.DECAGON), Shape(ShapeType.HENDECAGON), Shape(ShapeType.DODECAGON))
    for (shape in shapes) {
        println(shape)
    }
}
