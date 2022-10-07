import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        Assert.assertTrue("Le test de la fonction compareBooleans avec les paramètres true et false", compareBooleans(a = true, b = false) == false)
        Assert.assertTrue("Le test de la fonction compareBooleans avec les paramètres false et true", compareBooleans(a = false, b = true) == false)
        Assert.assertTrue("Le test de la fonction compareBooleans avec les paramètres false et false", compareBooleans(a = false, b = false) == true)
        Assert.assertTrue("Le test de la fonction compareBooleans avec les paramètres true et true", compareBooleans(a = true, b = true) == false)

        Assert.assertTrue("Le test de la fonction compareIntegers avec les paramètres 1 et 2", compareIntegers(a = 1, b = 2) == 2)
        Assert.assertTrue("Le test de la fonction compareIntegers avec les paramètres 2 et 1", compareIntegers(a = 2, b = 1) == 2)
        Assert.assertTrue("Le test de la fonction compareIntegers avec les paramètres 1 et 1", compareIntegers(a = 1, b = 1) == 42)
        Assert.assertTrue("Le test de la fonction compareIntegers avec les paramètres 2 et 2", compareIntegers(a = 2, b = 2) == 42)

        Assert.assertTrue("Le test de la fonction compareDouble avec les paramètres 1.0 et 2.0", compareDouble(a = 1.0, b = 2.0) == 1.0)
        Assert.assertTrue("Le test de la fonction compareDouble avec les paramètres 2.0 et 1.0", compareDouble(a = 2.0, b = 1.0) == 1.0)
        Assert.assertTrue("Le test de la fonction compareDouble avec les paramètres 1.0 et 1.0", compareDouble(a = 1.0, b = 1.0) == 1.0)
        Assert.assertTrue("Le test de la fonction compareDouble avec les paramètres 2.0 et 2.0", compareDouble(a = 2.0, b = 2.0) == 2.0)
        Assert.assertTrue("Le test de la fonction compareDouble avec les paramètres 101.0 et 2.0", compareDouble(a = 101.0, b = 2.0) == 42.0)
        Assert.assertTrue("Le test de la fonction compareDouble avec les paramètres 2.0 et 101.0", compareDouble(a = 2.0, b = 101.0) == 42.0)

        Assert.assertTrue("Le test de la fonction compareStrings avec les paramètres \"Hello\" et \"Toto\"", compareStrings(a = "Hello", b = "Toto") == "Hello est plus longue que Toto")
        Assert.assertTrue("Le test de la fonction compareStrings avec les paramètres \"Toto\" et \"Hello\"", compareStrings(a = "Toto", b = "Hello") == "Hello est plus longue que Toto")
        Assert.assertTrue("Le test de la fonction compareStrings avec les paramètres \"Mille sabords !\" et \"Hadock\"", compareStrings(a = "Mille sabords !", b = "Hadock") == "Mille sabords ! est plus longue que Hadock")
        Assert.assertTrue("Le test de la fonction compareStrings avec les paramètres \"Hello\" et \"Hello\"", compareStrings(a = "Hello", b = "Hello") == "Les deux Strings sont identiques")
        Assert.assertTrue("Le test de la fonction compareStrings avec les paramètres \"Toto\" et \"Toto\"", compareStrings(a = "Toto", b = "Toto") == "Les deux Strings sont identiques")
        Assert.assertTrue("Le test de la fonction compareStrings avec les paramètres \"Hello\" et \"World\"", compareStrings(a = "Hello", b = "World") == "Les deux Strings sont de même taille")

        Assert.assertTrue("Le test de la fonction multipleCases avec le paramètre 1", multipleCases(1) == "a vaut un")
        Assert.assertTrue("Le test de la fonction multipleCases avec le paramètre 2", multipleCases(2) == "a vaut deux")
        Assert.assertTrue("Le test de la fonction multipleCases avec le paramètre 3", multipleCases(3) == "a vaut trois")
        Assert.assertTrue("Le test de la fonction multipleCases avec le paramètre 4", multipleCases(4) == "a vaut 4")
        Assert.assertTrue("Le test de la fonction multipleCases avec le paramètre -100", multipleCases(-100) == "a vaut -100")


    }
}