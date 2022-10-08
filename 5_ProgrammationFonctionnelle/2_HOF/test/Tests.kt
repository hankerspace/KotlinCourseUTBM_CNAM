import org.junit.Assert
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class Test {
    @Test fun testSolution() {
        val out = ByteArrayOutputStream()
        System.setOut(PrintStream(out))
        main()

        val final = pokemonNames
            .filter { it.endsWith(it.first().lowercase()) }
            .map { "$it (${it.first()}[...]${it.last()})" }
            .sortedBy { it.length }
            .onEachIndexed { index, s -> "${index + 1}. $s" }

        Assert.assertTrue("Vérification des labdas",
            final.all {
                out.toString().contains(it)
            }
        )
    }
}