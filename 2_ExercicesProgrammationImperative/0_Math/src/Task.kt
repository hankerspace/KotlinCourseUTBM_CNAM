fun estPair(n: Int): Boolean {
    return n % 2 == 0
}

fun estPremier(n: Int): Boolean {
    if (n < 2) return false
    for (i in 2..n / 2) {
        if (n % i == 0) return false
    }
    return true
}

fun primorielle(n: Int): Int {
    var count = 0
    for (i in 2..n) {
        if (estPremier(i)) count++
    }
    return count
}

fun nombreDiviseurs(n: Int): Int {
    var count = 0
    for (i in 1..n) {
        if (n % i == 0) count++
    }
    return count
}

fun nombreOr(n: Int): Double {
    var Un: Int
    var Un1 = 2
    var Un2 = 1
    var Vn: Double = 0.0
    var step = 0
    while (step < n) {
        Un = Un1 + Un2
        Vn = Un.toDouble() / Un1.toDouble()
        Un2 = Un1
        Un1 = Un
        step++
    }
    return Vn
}

fun estParfait(n: Int): Boolean {
    var sum = 0
    for (i in 1..n / 2) {
        if (n % i == 0) sum += i
    }
    return sum == n
}

fun fibonarielle(n: Int): Int {
    return if (n == 0) 1 else n * fibonarielle(n - 1)
}

fun estPalindrome(s: String): Boolean {
    for (i in 0..s.length / 2) {
        if (s[i] != s[s.length - i - 1]) return false
    }
    return true
}

fun estAnagramme(s1: String, s2: String): Boolean {
    if (s1.length != s2.length) return false
    val s1Sorted = s1.toCharArray().sorted()
    val s2Sorted = s2.toCharArray().sorted()
    for (i in 0..s1.length - 1) {
        if (s1Sorted[i] != s2Sorted[i]) return false
    }
    return true
}

fun main() {
    // Test de toutes les fonctions
    println("Est pair: ${estPair(2)}")
    println("Est premier: ${estPremier(2)}")
    println("Nombre de nombres premiers inférieurs à 10: ${primorielle(10)}")
    println("Nombre de diviseurs de 10: ${nombreDiviseurs(10)}")
    println("Nombre d'or itération 10 : ${nombreOr(10)}")
    println("Est parfait: ${estParfait(6)}")
    println("Est palindrome: ${estPalindrome("kayak")}")
    println("Est anagramme: ${estAnagramme("kayak", "kayak")}")

}