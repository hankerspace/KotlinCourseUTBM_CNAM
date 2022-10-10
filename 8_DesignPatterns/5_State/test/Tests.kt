import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        Assert.assertTrue("Etat suivant le next() de RedState est GreenState", RedState().next() is GreenState)
        Assert.assertTrue("Etat suivant le next() de GreenState est OrangeState", GreenState().next() is OrangeState)
        Assert.assertTrue("Etat suivant le next() de OrangeState est RedState", OrangeState().next() is RedState)
    }
}