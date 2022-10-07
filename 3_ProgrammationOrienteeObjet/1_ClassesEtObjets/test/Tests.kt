import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        Assert.assertTrue("Test de la fonction createPersonne", createPersonne("Doe", "John", 42) is Personne)
        Assert.assertTrue("Test de la fonction createPersonnesAndTestNomComplet", createPersonnesAndTestNomComplet() == listOf("Doe John", "Doe Jane", "Doe Jack", "Doe Jill"))
        Assert.assertTrue("Test de la fonction createPersonnesAndTestEstMajeur", createPersonnesAndTestEstMajeur() == listOf(true, true, false, false))
    }
}