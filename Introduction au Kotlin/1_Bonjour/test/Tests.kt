import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        Assert.assertTrue("Le test avec le nom Thomas n'a pas renvoyé Bonjour Thomas", bonjour("Thomas") == "Bonjour Thomas")
        Assert.assertTrue("Le test avec le nom Jean-Pierre n'a pas renvoyé Bonjour Jean-Pierre", bonjour("Jean-Pierre") == "Bonjour Jean-Pierre")
    }
}