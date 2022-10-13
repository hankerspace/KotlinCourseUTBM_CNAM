operator fun String.plus(other: String): String {
    return this + other
}

operator fun String.times(other: Int): String {
    return this.repeat(other)
}

operator fun String.div(other: String): String {
    return other + this
}

operator fun String.minus(other: String): String {
    return this.replace(other, " ")
}

fun main() {
    println("Hello" + "World")
    println("Hello" * 3)
    println("Hello" / "World")
    println("HelloWorld" - "World")
    println("Hello" + "World" * 3 / "World")
}

