val counter = { var count = 0; { count++ } }

fun main(args: Array<String>) {
    val c1 = counter()
    val c2 = counter()
    println(c1())
    println(c1())
    println(c2())
    println(c1())
    println(c2())
}