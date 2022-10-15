import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        Assert.assertTrue("Test de la fonction doors avec 1", doors(1) == listOf(1))
        Assert.assertTrue("Test de la fonction doors avec 2", doors(2) == listOf(1))
        Assert.assertTrue("Test de la fonction doors avec 3", doors(3) == listOf(1))
        Assert.assertTrue("Test de la fonction doors avec 4", doors(4) == listOf(1, 4))
        Assert.assertTrue("Test de la fonction doors avec 5", doors(5) == listOf(1, 4))
        Assert.assertTrue("Test de la fonction doors avec 6", doors(6) == listOf(1, 4))
        Assert.assertTrue("Test de la fonction doors avec 7", doors(7) == listOf(1, 4))
        Assert.assertTrue("Test de la fonction doors avec 100", doors(100) == listOf(1, 4, 9, 16, 25, 36, 49, 64, 81, 100))

    }
}