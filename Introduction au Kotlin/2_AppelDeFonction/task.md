# Cours
Les fonctions peuvent être écrites sous différentes formes en Kotlin.

### Fonctions simples
Une fonction simple est définie par le mot clé `fun`, suivi du nom de la fonction, des paramètres et du type de retour.

```kotlin
fun add(a: Int, b: Int): Int {
    return a + b
}
```

### Fonctions inline (en ligne)
Une fonction inline est définie par le mot clé `fun`, suivi du nom de la fonction, des paramètres et de l'instruction de la fonction, le tout en une seule ligne.

Dans l'exemple suivant, le type de retour est déduit par le compilateur.

Le mot clé `return` n'est pas utilisé dans une fonction inline.

```kotlin
fun add(a: Int, b: Int) = a + b
```

### Lambdas expressions
Une lambda expression est une fonction inline qui n'a pas de nom. 
La lambda expression peut être stockée dans une variable.
La lambda expression peut être passée en paramètre d'une autre fonction.

La lambda expression est définie par les paramètres, le symbole `->` et l'instruction de la fonction, le tout entre accolades.

```kotlin
val add = { a: Int, b: Int -> a + b }
```

### Fonctions anonymes
Une fonction anonyme est définie par le mot clé `fun`, suivi des paramètres et de l'instruction de la fonction, le tout en une seule ligne.

La fonction anonyme peut être stockée dans une variable.

```kotlin
val add = fun(a: Int, b: Int): Int {
    return a + b
}
```

## Appel de fonction
Une fonction est appelée en écrivant son nom, suivi des paramètres.

Dans les 4 précédents exemples, la fonction `add` peut être appelée de la manière suivante:

```kotlin
fun main(args: Array<String>) {
    println(add(1, 2))
}
```

# Exercice

Dans l'exercice vous devez compléter les fonctions de test. 

Utilisez des appels aux fonctions définies au début du fichier pour compléter les tests.
