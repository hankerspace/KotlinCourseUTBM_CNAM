import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        Assert.assertTrue("Le test de la fonction compareIntegers avec les paramètres 5 et null", compareIntegers(5, null) == null)
        Assert.assertTrue("Le test de la fonction compareIntegers avec les paramètres null et 5", compareIntegers(null, 5) == null)
        Assert.assertTrue("Le test de la fonction compareIntegers avec les paramètres 5 et 5", compareIntegers(5, 5) == 5)
        Assert.assertTrue("Le test de la fonction compareIntegers avec les paramètres 5 et 10", compareIntegers(5, 10) == 10)

        Assert.assertTrue("Le test de la fonction countNullsInList avec la liste [1, 2, 3, 4, 5]", countNullsInList(listOf(1, 2, 3, 4, 5)) == 0)
        Assert.assertTrue("Le test de la fonction countNullsInList avec la liste [1, 2, null, 4, 5]", countNullsInList(listOf(1, 2, null, 4, 5)) == 1)
        Assert.assertTrue("Le test de la fonction countNullsInList avec la liste [null, null, null, null, null]", countNullsInList(listOf(null, null, null, null, null)) == 5)


    }
}