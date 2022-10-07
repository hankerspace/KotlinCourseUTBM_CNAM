import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        val zoo = Zoo(listOf(
            Cat("Tom"),
            Dog("Spike"),
            Fish("Nemo"),
        ))
        zoo.move()
        zoo.shout()
        Assert.assertTrue("Test du zoo",
            zoo.animals.size == 3 && zoo.animals[0].name == "Tom" && zoo.animals[1].name == "Spike" && zoo.animals[2].name == "Nemo")

    }
}