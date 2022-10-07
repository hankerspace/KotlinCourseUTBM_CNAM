import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        Assert.assertTrue("Le test de la fonction testAdd n'a pas retourné le résultat attendu", testAdd() == 4)
        Assert.assertTrue("Le test de la fonction testAddWithParameters n'a pas retourné le résultat attendu", testAddWithParameters(10, 20) == 31)
        Assert.assertTrue("Le test de la fonction testSubtract n'a pas retourné le résultat attendu", testSubtract() == 0)
        Assert.assertTrue("Le test de la fonction testSubtractWithParameters n'a pas retourné le résultat attendu", testSubtractWithParameters(10, 20) == -9)
        Assert.assertTrue("Le test de la fonction testMultiply n'a pas retourné le résultat attendu", testMultiply() == 3)
        Assert.assertTrue("Le test de la fonction testMultiplyWithParameters n'a pas retourné le résultat attendu", testMultiplyWithParameters(10, 20) == 201)
        Assert.assertTrue("Le test de la fonction testDivide n'a pas retourné le résultat attendu", testDivide() == 1)
        Assert.assertTrue("Le test de la fonction testDivideWithParameters n'a pas retourné le résultat attendu", testDivideWithParameters(20, 10) == 3)
        Assert.assertTrue("Le test de la fonction testFunctionCombination n'a pas retourné le résultat attendu", testFunctionCombination() == -3)
    }
}