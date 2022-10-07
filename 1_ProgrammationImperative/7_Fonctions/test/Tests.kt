import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        Assert.assertTrue("Le test de la fonction interativePgcd avec les paramètres 253 et 636543", interativePgcd(253, 636543) == 1L)
        Assert.assertTrue("Le test de la fonction interativePgcd avec les paramètres 12 et 18", interativePgcd(12, 18) == 6L)
        Assert.assertTrue("Le test de la fonction interativePgcd avec les paramètres 12 et 17", interativePgcd(12, 17) == 1L)

        Assert.assertTrue("Le test de la fonction recursivePgcd avec les paramètres 253 et 636543", recursivePgcd(253, 636543) == 1L)
        Assert.assertTrue("Le test de la fonction recursivePgcd avec les paramètres 12 et 18", recursivePgcd(12, 18) == 6L)
        Assert.assertTrue("Le test de la fonction recursivePgcd avec les paramètres 12 et 17", recursivePgcd(12, 17) == 1L)

        Assert.assertTrue("Le test de la fonction encryptText avec les paramètres \"Hello World\" et \"123\"", encryptText("Hello World", "123") != "Hello World")
        Assert.assertTrue("Le test de la fonction decryptText avec les paramètres \"Hello World\" et \"123\"", decryptText(encryptText("Hello World", "123"), "123") == "Hello World")

        Assert.assertTrue("Le test de la fonction encryptText avec les paramètres \"Hello World\" et \"1234\"", encryptText("Hello World", "1234") != "Hello World")
        Assert.assertTrue("Le test de la fonction decryptText avec les paramètres \"Hello World\" et \"1234\"", decryptText(encryptText("Hello World", "1234"), "1234") == "Hello World")

    }
}