// Créer la data class Task
data class Task(val title: String, val isDone: Boolean = false)

// Créer la data class TaskList
data class TodoList(val name: String, val tasks: List<Task>)

fun main() {
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
}