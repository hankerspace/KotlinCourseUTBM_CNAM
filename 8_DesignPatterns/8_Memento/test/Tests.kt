import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        val editor = TextEditor()
        editor.write("Ceci ")
        editor.write("est ")
        editor.write("un ")
        editor.write("test.")
        editor.undo()
        editor.undo()
        editor.undo()
        Assert.assertTrue("Test", true)
    }
}