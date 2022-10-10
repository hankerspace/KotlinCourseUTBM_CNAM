import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        Assert.assertTrue("Test classe SimpleTroll", SimpleTroll() is Troll)
        Assert.assertTrue("Test classe ClubbedTroll", ClubbedTroll(SimpleTroll()) is Troll)
        Assert.assertTrue("Test classe ArmoredTroll", ArmoredTroll(SimpleTroll()) is Troll)
        Assert.assertTrue("Test classe BootedTroll", BootedTroll(SimpleTroll()) is Troll)
    }
}