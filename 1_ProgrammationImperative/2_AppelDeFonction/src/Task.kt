// Une fonction avec un corps
fun addPlusOne(a: Int, b: Int): Int {
    return a + b + 1
}

// Une fonction inline
fun subtractPlusOne(a: Int, b: Int): Int = a - b + 1

// Une lambda expression
val multiplyPlusOne = { a: Int, b: Int -> a * b + 1}

// Une fonction anonyme
val dividePlusOne = fun (a: Int, b: Int): Int = a / b + 1

fun testAdd(): Int {
    // retourne le résultat de l'appel à la fonction addPlusOne avec les paramètres 1 et 2
    return addPlusOne(1, 2)
}

fun testAddWithParameters(a: Int, b: Int): Int {
    // retourne le résultat de l'appel à la fonction addPlusOne avec les paramètres a et b passés en paramètre
    return addPlusOne(a, b)
}

fun testSubtract(): Int {
    // retourne le résultat de l'appel à la fonction subtractPlusOne avec les paramètres 1 et 2
    return subtractPlusOne(1, 2)
}

fun testSubtractWithParameters(a: Int, b: Int): Int {
    // retourne le résultat de l'appel à la fonction subtractPlusOne avec les paramètres a et b passés en paramètre
    return subtractPlusOne(a, b)
}

fun testMultiply(): Int {
    // retourne le résultat de l'appel à la fonction multiplyPlusOne avec les paramètres 1 et 2
    return multiplyPlusOne(1, 2)
}

fun testMultiplyWithParameters(a: Int, b: Int): Int {
    // retourne le résultat de l'appel à la fonction multiplyPlusOne avec les paramètres a et b passés en paramètre
    return multiplyPlusOne(a, b)
}

fun testDivide(): Int {
    // retourne le résultat de l'appel à la fonction dividePlusOne avec les paramètres 1 et 2
    return dividePlusOne(1, 2)
}

fun testDivideWithParameters(a: Int, b: Int): Int {
    // retourne le résultat de l'appel à la fonction dividePlusOne avec les paramètres a et b passés en paramètre
    return dividePlusOne(a, b)
}

fun testFunctionCombination(): Int {
    // utiliser résultat de l'appel à la fonction addPlusOne avec les paramètres 1 et 2 en tant que premier paramètre de la fonction subtractPlusOne
    // utiliser résultat de l'appel à la fonction addPlusOne avec les paramètres 3 et 4 en tant que second paramètre de la fonction subtractPlusOne
    // retourner le résultat final de l'appel à la fonction subtractPlusOne
    return subtractPlusOne(addPlusOne(1, 2), addPlusOne(3, 4))
}