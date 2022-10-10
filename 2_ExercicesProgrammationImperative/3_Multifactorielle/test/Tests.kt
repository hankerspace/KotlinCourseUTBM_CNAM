import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        Assert.assertTrue("Test multifactorial(1)", multifactorial(1) == 1L)
        Assert.assertTrue("Test multifactorial(2)", multifactorial(2) == 2L)
        Assert.assertTrue("Test multifactorial(3)", multifactorial(3) == 12L)
        Assert.assertTrue("Test multifactorial(4)", multifactorial(4) == 288L)
        Assert.assertTrue("Test multifactorial(5)", multifactorial(5) == 34560L)
        Assert.assertTrue("Test multifactorial(6)", multifactorial(6) == 24883200L)
        Assert.assertTrue("Test multifactorial(7)", multifactorial(7) == 125411328000L)

    }
}