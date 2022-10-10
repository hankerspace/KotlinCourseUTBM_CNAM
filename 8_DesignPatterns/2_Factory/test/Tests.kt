import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        val parser = "data.json".getParser()
        Assert.assertEquals("Parsing JSON", parser.parse())

        val parser2 = "data.xml".getParser()
        Assert.assertEquals("Parsing XML", parser2.parse())

        try {
            val parser3 = "data.txt".getParser()
            Assert.fail("Exception expected while parsing data.txt")
        } catch (e: Exception) {
        }
    }
}