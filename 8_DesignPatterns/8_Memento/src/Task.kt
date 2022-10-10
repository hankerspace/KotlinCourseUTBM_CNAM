import java.util.*

class TextEditor {
    private var text = ""
    private var history = Stack<TextEditorMemento>()

    fun write(text: String) {
        history.push(TextEditorMemento(this.text))
        this.text += text
    }

    fun undo() {
        if (history.isEmpty()) return
        val memento = history.pop()
        text = memento.text
    }

    fun show() = println(text)

    data class TextEditorMemento(val text: String)
}

fun main(args: Array<String>) {
    // Exemple de main de test
    val editor = TextEditor()
    editor.write("Ceci ")
    editor.write("est ")
    editor.write("un ")
    editor.write("test.")
    editor.show()
    editor.undo()
    editor.show()
    editor.undo()
    editor.show()
    editor.undo()
    editor.show()
}