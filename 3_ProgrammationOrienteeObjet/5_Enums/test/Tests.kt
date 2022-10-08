import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        Assert.assertTrue("Test du type CIRCLE",
            "CIRCLE" in Shape(ShapeType.CIRCLE).toString() &&
                    "0" in Shape(ShapeType.CIRCLE).toString())
        Assert.assertTrue("Test du type SQUARE",
            "SQUARE" in Shape(ShapeType.SQUARE).toString() &&
                    "4" in Shape(ShapeType.SQUARE).toString())
        Assert.assertTrue("Test du type TRIANGLE",
            "TRIANGLE" in Shape(ShapeType.TRIANGLE).toString() &&
                    "3" in Shape(ShapeType.TRIANGLE).toString())
        Assert.assertTrue("Test du type PENTAGON",
            "PENTAGON" in Shape(ShapeType.PENTAGON).toString() &&
                    "5" in Shape(ShapeType.PENTAGON).toString())
        Assert.assertTrue("Test du type HEXAGON",
            "HEXAGON" in Shape(ShapeType.HEXAGON).toString() &&
                    "6" in Shape(ShapeType.HEXAGON).toString())
        Assert.assertTrue("Test du type HEPTAGON",
            "HEPTAGON" in Shape(ShapeType.HEPTAGON).toString() &&
                    "7" in Shape(ShapeType.HEPTAGON).toString())
        Assert.assertTrue("Test du type OCTAGON",
            "OCTAGON" in Shape(ShapeType.OCTAGON).toString() &&
                    "8" in Shape(ShapeType.OCTAGON).toString())
        Assert.assertTrue("Test du type NONAGON",
            "NONAGON" in Shape(ShapeType.NONAGON).toString() &&
                    "9" in Shape(ShapeType.NONAGON).toString())
        Assert.assertTrue("Test du type DECAGON",
            "DECAGON" in Shape(ShapeType.DECAGON).toString() &&
                    "10" in Shape(ShapeType.DECAGON).toString())

    }
}