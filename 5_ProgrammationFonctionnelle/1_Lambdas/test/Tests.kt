import org.junit.Assert
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class Test {
    @Test fun testSolution() {
        val voyelle = { s: String -> s[0] in "aeiouyAEIOUY" }
        val plusDe5 = { s: String -> s.length > 5 }
        val moinsDe8 = { s: String -> s.length < 8 }


        val out = ByteArrayOutputStream()
        System.setOut(PrintStream(out))
        main()
        Assert.assertTrue("Vérification des labdas",
            pokemonNames.filter {
                // Utilisez vos lambdas ici pour filtrer les pokemons
                voyelle(it) && plusDe5(it) && moinsDe8(it)
            }.all {
                out.toString().contains(it)
            }
        )
    }
}