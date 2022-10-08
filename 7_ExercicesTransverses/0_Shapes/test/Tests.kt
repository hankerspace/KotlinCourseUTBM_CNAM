import org.junit.Assert
import org.junit.Test
import java.awt.Color

class Test {
    @Test fun testSolution() {
        Assert.assertTrue("Test de la forme Rectangle getShapeColor",
            Rectangle(Point(0, 0), 10, 10, Color.BLACK).getShapeColor() == Color.BLACK
        )

        Assert.assertTrue("Test de la forme Rectangle getAllVertices",
            Rectangle(Point(0, 0), 10, 10, Color.BLACK).getAllVertices() == listOf(
                Point(0, 0),
                Point(10, 0),
                Point(10, 10),
                Point(0, 10)
            )
        )

        Assert.assertTrue("Test de la forme Square getShapeColor",
            Square(Point(0, 0), 10, Color.BLACK).getShapeColor() == Color.BLACK
        )

        Assert.assertTrue("Test de la forme Square getAllVertices",
            Square(Point(0, 0), 10, Color.BLACK).getAllVertices() == listOf(
                Point(0, 0),
                Point(10, 0),
                Point(10, 10),
                Point(0, 10)
            )
        )

        Assert.assertTrue("Test de la forme Circle getShapeColor",
            Circle(Point(0, 0), 10, Color.BLACK).getShapeColor() == Color.BLACK
        )

        Assert.assertTrue("Test de la forme Triangle getShapeColor",
            Triangle(Point(0, 0), Point(10, 0), Point(0, 10), Color.BLACK).getShapeColor() == Color.BLACK
        )

        Assert.assertTrue("Test de la forme Triangle getAllVertices",
            Triangle(Point(0, 0), Point(10, 0), Point(0, 10), Color.BLACK).getAllVertices() == listOf(
                Point(0, 0),
                Point(10, 0),
                Point(0, 10)
            )
        )
    }
}