import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        val sentence = getLongestSentence()
        Assert.assertTrue("Test si chaque mot commence bien par la lettre de fin du mot précédent", sentence.split(" ").zipWithNext().all { it.first.last().uppercase() == it.second.first().uppercase() })
        Assert.assertTrue("Test si la fonction renvoie un résultat sans deux fois le même pokemon", sentence.split(" ").toSet().size == sentence.split(" ").size)
        Assert.assertTrue("Test si la fonction renvoie un résultat avec au moins 10 pokemons", sentence.split(" ").size >= 10)
        Assert.assertTrue("Test si la fonction renvoie un résultat avec au moins 20 pokemons", sentence.split(" ").size >= 20)
        Assert.assertTrue("Test si la fonction renvoie un résultat avec au moins 30 pokemons", sentence.split(" ").size >= 30)
        Assert.assertTrue("Test si la fonction renvoie un résultat avec au moins 40 pokemons", sentence.split(" ").size >= 40)
        Assert.assertTrue("Test si la fonction renvoie un résultat avec au moins 50 pokemons", sentence.split(" ").size >= 50)
    }
}