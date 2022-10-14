open class MyException(message: String) : Exception(message)
class NegativeNumberException() : MyException("Le nombre est négatif")
class ZeroNumberException() : MyException("Le nombre est nul")
class EvenNumberException() : MyException("Le nombre est pair")
class PrimeNumberException() : MyException("Le nombre est premier")

fun isPrime(n: Int): Boolean {
    if (n <= 1) return false
    for (i in 2..n / 2) {
        if (n % i == 0) return false
    }
    return true
}

fun main() {
    try {
        println("Entrez un nombre :")
        val number = readLine()!!.toInt()

        if (number < 0) throw NegativeNumberException()
        if (number == 0) throw ZeroNumberException()
        if (number % 2 == 0) throw EvenNumberException()
        if (isPrime(number)) throw PrimeNumberException()

        println("Votre nombre est $number")
    } catch (e: MyException) {
        println(e.message)
    } catch (e: Exception) {
        println("Une erreur inconnue est survenue")
    }
}


