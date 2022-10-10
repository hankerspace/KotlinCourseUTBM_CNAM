import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {

        val taxis = listOf(1729L, 4104L, 13832L, 20683L, 32832L, 39312L, 40033L, 46683L, 64232L, 65728L, 110656L, 110808L, 134379L, 149389L, 165464L, 171288L, 195841L, 216027L, 216125L, 262656L)
        val taxi = taxi(20)
        taxis.forEach { Assert.assertTrue("Test de la fonction taxi(20) contient $it", taxi.contains(it)) }
    }
}