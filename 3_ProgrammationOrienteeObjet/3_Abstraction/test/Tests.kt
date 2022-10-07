import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        Assert.assertTrue("Test de area de Circle avec comme paramètre 2", testCircle(2.0).area() == Math.PI * 2.0 * 2.0)
        Assert.assertTrue("Test de area de Circle avec comme paramètre 44", testCircle(44.0).area() == Math.PI * 44.0 * 44.0)
        Assert.assertTrue("Test de perimeter de Circle avec comme paramètre 44", testCircle(44.0).perimeter() == 2 * Math.PI * 44.0)
        Assert.assertTrue("Test de perimeter de Circle avec comme paramètre 3", testCircle(3.0).perimeter() == 2 * Math.PI * 3.0)

        Assert.assertTrue("Test de area de Rectangle avec comme paramètres 2 et 3", testRectangle(2.0, 3.0).area() == 6.0)
        Assert.assertTrue("Test de area de Rectangle avec comme paramètres 20 et 30", testRectangle(20.0, 30.0).area() == 600.0)
        Assert.assertTrue("Test de perimeter de Rectangle avec comme paramètres 20 et 30", testRectangle(20.0, 30.0).perimeter() == 100.0)
        Assert.assertTrue("Test de perimeter de Rectangle avec comme paramètres 2 et 3", testRectangle(2.0, 3.0).perimeter() == 10.0)


        Assert.assertTrue("Test de area de Square avec comme paramètre 2", testSquare(2.0).area() == 4.0)
        Assert.assertTrue("Test de area de Square avec comme paramètre 23", testSquare(23.0).area() == 529.0)
        Assert.assertTrue("Test de perimeter de Square avec comme paramètre 23", testSquare(23.0).perimeter() == 92.0)
        Assert.assertTrue("Test de perimeter de Square avec comme paramètre 2", testSquare(2.0).perimeter() == 8.0)



    }
}