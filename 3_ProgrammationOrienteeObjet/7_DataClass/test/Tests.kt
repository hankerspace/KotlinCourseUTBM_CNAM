import org.junit.Assert
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class Test {
    @Test fun testSolution() {
        val out = ByteArrayOutputStream()
        System.setOut(PrintStream(out))

        // Create a list of tasks
        val tasks = listOf(
            Task("Wash the dishes", true),
            Task("Do the laundry"),
            Task("Buy groceries", true),
            Task("Prepare dinner", true),
            Task("Call mom"),
            Task("Book the holidays"),
            Task("Practice on SoloLearn", true)
        )
        val todoList = TodoList("Today's tasks", tasks)
        println(todoList)

        Assert.assertTrue("Vérification de la tâche Wash the dishes",
            out.toString().contains("Wash the dishes") && out.toString().contains("true"))
        Assert.assertTrue("Vérification de la tâche Do the laundry",
            out.toString().contains("Do the laundry") && out.toString().contains("false"))
        Assert.assertTrue("Vérification de la tâche Buy groceries",
            out.toString().contains("Buy groceries") && out.toString().contains("true"))
        Assert.assertTrue("Vérification de la tâche Prepare dinner",
            out.toString().contains("Prepare dinner") && out.toString().contains("true"))
        Assert.assertTrue("Vérification de la tâche Call mom",
            out.toString().contains("Call mom") && out.toString().contains("false"))
        Assert.assertTrue("Vérification de la tâche Book the holidays",
            out.toString().contains("Book the holidays") && out.toString().contains("false"))
        Assert.assertTrue("Vérification de la tâche Practice on SoloLearn",
            out.toString().contains("Practice on SoloLearn") && out.toString().contains("true"))
        Assert.assertTrue("Vérification du nom de la liste",
            out.toString().contains("Today's tasks"))
    }
}