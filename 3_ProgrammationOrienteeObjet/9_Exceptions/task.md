# Cours

Les exceptions sont des objets qui sont lancés lorsqu'une erreur survient. Elles sont utilisées pour gérer les erreurs et les exceptions.

En Kotlin, les exceptions sont des objets qui héritent de la classe `Throwable`. 

De multiples exceptions sont déjà définies dans la bibliothèque standard de Kotlin.


## Les exceptions

La classe `Exception` est la classe mère de toutes les exceptions. Elle est utilisée pour gérer les erreurs. Elle est définie comme suit :

```kotlin
class Exception(message: String) : Throwable(message)
```

Les exceptions sont lancées avec le mot clé `throw`. Par exemple, si on veut lancer une exception lorsqu'une division par zéro est effectuée, on peut écrire :

```kotlin
fun div(a: Int, b: Int): Int {
    if (b == 0) {
        throw Exception("Division par zéro")
    }
    return a / b
}
```

Certaines exceptions sont lancées automatiquement par Kotlin. Par exemple, si on essaie d'accéder à un élément d'une liste qui n'existe pas, une exception de type `IndexOutOfBoundsException` est lancée.

## Exceptions personnalisées

On peut créer ses propres exceptions en héritant de la classe `Exception`. Par exemple, on peut créer une exception `NegativeNumberException` qui est lancée lorsqu'un nombre négatif est utilisé :

```kotlin
class NegativeNumberException(message: String) : Exception(message)

fun div(a: Int, b: Int): Int {
    if (b < 0) {
        throw NegativeNumberException("Le nombre $b est négatif")
    }
    return a / b
}
```

## Les blocs `try` et `catch`

On peut utiliser les blocs `try` et `catch` pour gérer les exceptions. Le bloc `try` contient le code qui peut lancer une exception. Le bloc `catch` contient le code qui sera exécuté si une exception est lancée. Par exemple, on peut utiliser un bloc `try` et `catch` pour gérer une division par zéro :

```kotlin
fun div(a: Int, b: Int): Int {
    try {
        return a / b
    } catch (e: Exception) {
        println("Une erreur est survenue : ${e.message}")
    }
    return 0
}
```

## Les blocs `try`, `catch` et `finally`

On peut utiliser un bloc `finally` pour exécuter du code après le bloc `try` ou le bloc `catch`. Par exemple, on peut utiliser un bloc `finally` pour fermer un fichier :

```kotlin
fun readFile(path: String) {
    val file = File(path)
    try {
        val lines = file.readLines()
        println(lines)
    } catch (e: Exception) {
        println("Une erreur est survenue : ${e.message}")
    } finally {
        file.close()
    }
}
```

## Les blocs `try` et `catch` avec plusieurs exceptions

On peut utiliser plusieurs blocs `catch` pour gérer plusieurs exceptions. Par exemple, on peut utiliser un bloc `catch` pour gérer une division par zéro et un autre bloc `catch` pour gérer un nombre négatif :

```kotlin
fun div(a: Int, b: Int): Int {
    try {
        return a / b
    } catch (e: ArithmeticException) {
        println("Une erreur est survenue : ${e.message}")
    } catch (e: NegativeNumberException) {
        println("Une erreur est survenue : ${e.message}")
    }
    return 0
}
```

Attention : les blocs `catch` doivent être placés dans l'ordre des classes des exceptions. Par exemple, si on inverse les blocs `catch` de l'exemple précédent, on aura une erreur de compilation :

```kotlin
fun div(a: Int, b: Int): Int {
    try {
        return a / b
    } catch (e: NegativeNumberException) {
        println("Une erreur est survenue : ${e.message}")
    } catch (e: ArithmeticException) {
        println("Une erreur est survenue : ${e.message}")
    }
    return 0
}
```

```
Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
    The exception NegativeNumberException is already caught by the alternative Exception
    at div(task.kt:1)
    at taskKt.main(task.kt:1)
    at taskKt.main(task.kt)
```

Ceci est dû au fait que la classe `NegativeNumberException` hérite de la classe `ArithmeticException`. Il faut donc placer le bloc `catch` de la classe `NegativeNumberException` après le bloc `catch` de la classe `ArithmeticException`.

# Exercice

Demandez à l'utilisateur de saisir un nombre. Si le nombre est négatif, lancez une exception `NegativeNumberException`. Si le nombre est pair, lancez une exception `EvenNumberException`. Si le nombre est nul, lancez une exception `ZeroNumberException`. Si le nombre est premier (un nombre premier est un nombre qui n'est divisible que par 1 et par lui-même), lancez une exception `PrimeNumberException`. Sinon, affichez le nombre.

Vous veillerez à afficher un message d'erreur différent pour chaque exception.


