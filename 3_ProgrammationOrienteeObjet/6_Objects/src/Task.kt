// Créez la classe LogLevel qui contient des niveaux de log
enum class LogLevel {
    INFO,
    WARNING,
    ERROR
}

// Créez une classe Logger avec la méthode log
object Logger {
    fun log(level: LogLevel, message: String) {
        println("$level: $message")
    }
}

fun main() {
    Logger.log(LogLevel.INFO, "This is an info message")
    Logger.log(LogLevel.WARNING, "This is a warning message")
    Logger.log(LogLevel.ERROR, "This is an error message")
}

