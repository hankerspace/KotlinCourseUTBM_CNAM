import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        Assert.assertTrue("Test de la fonction estPair", estPair(2))
        Assert.assertFalse("Test de la fonction estPair", estPair(3))

        Assert.assertEquals("Test de la fonction nombreDiviseurs", 4, nombreDiviseurs(6))
        Assert.assertEquals("Test de la fonction nombreDiviseurs", 2, nombreDiviseurs(2))
        Assert.assertEquals("Test de la fonction nombreDiviseurs", 4, nombreDiviseurs(10))

        Assert.assertTrue("Test de la fonction estPremier", estPremier(2))
        Assert.assertTrue("Test de la fonction estPremier", estPremier(3))
        Assert.assertFalse("Test de la fonction estPremier", estPremier(4))

        Assert.assertEquals("Test de la fonction primorielle", 4, primorielle(10))
        Assert.assertEquals("Test de la fonction primorielle", 25, primorielle(100))

        Assert.assertEquals("Test de la fonction nombreOr", 1.6, nombreOr(10), 0.1)
        Assert.assertEquals("Test de la fonction nombreOr", 1.6, nombreOr(10), 0.1)

        Assert.assertTrue("Test de la fonction estParfait", estParfait(6))
        Assert.assertFalse("Test de la fonction estParfait", estParfait(10))

        Assert.assertEquals("Test de la fonction estPalindrome", true, estPalindrome("radar"))
        Assert.assertEquals("Test de la fonction estPalindrome", false, estPalindrome("kotlin"))
        Assert.assertEquals("Test de la fonction estPalindrome", true, estPalindrome("kayak"))
        Assert.assertEquals("Test de la fonction estPalindrome", true, estPalindrome("a"))

        Assert.assertEquals("Test de la fonction estAnagramme", true, estAnagramme("kotlin", "kotlin"))
        Assert.assertEquals("Test de la fonction estAnagramme", false, estAnagramme("kotin", "kotlin"))
        Assert.assertEquals("Test de la fonction estAnagramme", true, estAnagramme("kayak", "kayak"))
        Assert.assertEquals("Test de la fonction estAnagramme", true, estAnagramme("a", "a"))





    }
}