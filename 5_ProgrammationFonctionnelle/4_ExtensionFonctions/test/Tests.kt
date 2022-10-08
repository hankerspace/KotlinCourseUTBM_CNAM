import org.junit.Assert
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class Test {
    @Test fun testSolution() {
        val out = ByteArrayOutputStream()
        System.setOut(PrintStream(out))
        main()

        Assert.assertTrue("Vérification de l'extension",
            out.toString().contains("3, 2, 1")
        )
    }
}