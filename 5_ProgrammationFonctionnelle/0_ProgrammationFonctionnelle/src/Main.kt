fun sum(a: Int, b: Int) = a + b

fun sub(a: Int, b: Int) = a - b

fun mul(a: Int, b: Int) = a * b

fun highOrderFunction(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

fun main() {
    // Create lambdas
    val lambda1 = { println("Hello") }
    val lambda2 = { println("World") }
    val lambda3 = { println("!!") }
    // Create a list of lambdas
    val lambdas = listOf(lambda1, lambda2, lambda3)
    // Execute lambdas
    lambdas.forEach { it() }

    // Create a list of lambdas
    val lambdas2 = listOf({ println("Hello") }, { println("World") }, { println("!!") })
    // Execute lambdas
    lambdas2.forEach { it() }

    // High order function
    println(highOrderFunction(1, 2, ::sum))
    println(highOrderFunction(1, 2, ::sub))
    println(highOrderFunction(1, 2, ::mul))

    // Blocks of HOF
    val numbers = 1..100
    numbers
        .filter { it % 2 == 0 }
        .map { highOrderFunction(it, 2, ::mul) }
        .forEach { println(it) }

    // Or
    val evenNumbersMinus100 = (1..1000)
        .filter { number -> number % 2 == 0 }
        .map { highOrderFunction(it, 100, ::sub) }
    println(evenNumbersMinus100)
}
