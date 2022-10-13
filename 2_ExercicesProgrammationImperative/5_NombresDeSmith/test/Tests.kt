import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        Assert.assertTrue("Test de la fonction isSmith(100)", isSmith(100) == false)
        Assert.assertTrue("Test de la fonction isSmith(22)", isSmith(22))
        Assert.assertTrue("Test de la fonction isSmith(4)", isSmith(4))
        Assert.assertTrue("Test de la fonction isSmith(378)", isSmith(378))
        Assert.assertTrue("Test de la fonction isSmith(4937775)", isSmith(4937775))
        Assert.assertTrue("Test de la fonction isSmith(123456789)", isSmith(123456789) == false)
        Assert.assertTrue("Test de la fonction isSmith(987654321)", isSmith(987654321) == false)
    }
}