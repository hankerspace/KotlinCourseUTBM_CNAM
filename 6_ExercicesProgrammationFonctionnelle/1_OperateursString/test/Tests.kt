import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        Assert.assertTrue("Test de l'opérateur +", "Hello" + "World" == "HelloWorld")
        Assert.assertTrue("Test de l'opérateur *", "Hello" * 3 == "HelloHelloHello")
        Assert.assertTrue("Test de l'opérateur /", "Hello" / "World" == "WorldHello")
        Assert.assertTrue("Test de l'opérateur -", "HelloWorld" - "World" == "Hello ")
    }
}