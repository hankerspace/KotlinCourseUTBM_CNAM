import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        Assert.assertTrue("Le test de la fonction mergeTwoLists avec les paramètres listOf(1, 2, 3), listOf(4, 5, 6)", mergeTwoLists(listOf(1, 2, 3), listOf(4, 5, 6)) == listOf(1, 4, 2, 5, 3, 6))
        Assert.assertTrue("Le test de la fonction mergeTwoLists avec les paramètres listOf(1, 2, 3), listOf(4, 5, 6, 7, 8)", mergeTwoLists(listOf(1, 2, 3), listOf(4, 5, 6, 7, 8)) == listOf(1, 4, 2, 5, 3, 6, 7, 8))
        Assert.assertTrue("Le test de la fonction mergeTwoLists avec les paramètres listOf(1, 2, 3, 4), listOf(5, 6)", mergeTwoLists(listOf(1, 2, 3, 4), listOf(5, 6)) == listOf(1, 5, 2, 6, 3, 4))

        Assert.assertTrue("Le test de la fonction twoDimensionalList avec le paramètre listOf(1, 2, 3, 4, 5, 6)", twoDimensionalList(listOf(1, 2, 3, 4, 5, 6)) == listOf(listOf(2, 4, 6), listOf(1, 3, 5)))
        Assert.assertTrue("Le test de la fonction twoDimensionalList avec le paramètre listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)", twoDimensionalList(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)) == listOf(listOf(2, 4, 6, 8), listOf(1, 3, 5, 7, 9)))

        Assert.assertTrue("Le test de la fonction shuffleSentence avec le paramètre \"Hello world, how are you?\"", shuffleSentence("Hello world, how are you?") != "Hello world, how are you?")

        val result1 = shuffleSentence("Ceci est une longue phrase pour vérifier que la fonction fonctionne correctement")
        val result2 = shuffleSentence("Ceci est une longue phrase pour vérifier que la fonction fonctionne correctement")
        Assert.assertTrue("Le test de la fonction shuffleSentence avec le paramètre \"Ceci est une longue phrase pour vérifier que la fonction fonctionne correctement\"", result1 != result2)
    }
}