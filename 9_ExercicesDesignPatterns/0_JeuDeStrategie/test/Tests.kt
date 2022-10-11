import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        //TODO: implement your test here
        Assert.assertTrue("Test myFunction with 1, 2, 3, 4", myFunction(1, 2, 3, 4) == 27)
        Assert.assertTrue("Test myFunction with 2, 3, 4, 5", myFunction(2, 3, 4, 5) == 99)
        Assert.assertTrue("Test myFunction with 3, 4, 5, 6", myFunction(3, 4, 5, 6) == 219)
        Assert.assertTrue("Test myFunction with 4, 5, 6, 7", myFunction(4, 5, 6, 7) == 387)
        Assert.assertTrue("Test myFunction with 5, 6, 7, 8", myFunction(5, 6, 7, 8) == 603)


    }
}