import org.junit.Assert
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class Test {

    @Test fun testSolution() {
        val out = ByteArrayOutputStream()
        System.setOut(PrintStream(out))

        Logger.log(LogLevel.INFO, "This is an info message")
        Assert.assertTrue("Test du logger avec un niveau INFO",
            out.toString().contains("INFO") && out.toString().contains("This is an info message")
            )

        out.reset()
        Logger.log(LogLevel.WARNING, "This is a warning message")
        Assert.assertTrue("Test du logger avec un niveau WARNING",
            out.toString().contains("WARNING") && out.toString().contains("This is a warning message")
            )

        out.reset()
        Logger.log(LogLevel.ERROR, "This is an error message")
        Assert.assertTrue("Test du logger avec un niveau ERROR",
            out.toString().contains("ERROR") && out.toString().contains("This is an error message")
            )
    }
}