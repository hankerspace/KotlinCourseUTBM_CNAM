# Cours

## Extension de fonctions

L'extension de fonctions est une technique qui permet d'ajouter des méthodes à des types existants. C'est une technique très puissante qui permet de créer des bibliothèques de fonctions très puissantes.

### Exemple

```kotlin
fun String.lastChar(): Char = this.get(this.length - 1)
```

Cette fonction ajoute une méthode `lastChar()` à la classe `String`. Cette méthode retourne le dernier caractère de la chaîne de caractères.

### Usage

```kotlin
fun main(args: Array<String>) {
    println("Kotlin".lastChar())
}
```

## Surcharge d'opérateurs

La surcharge d'opérateurs permet de définir des opérateurs pour des types existants. 

L'extension de fonction peut être utilisée pour définir des opérateurs. Il faut ajouter le mot clé `operator` devant la définition. Par exemple, pour définir l'opérateur `+` pour les chaînes de caractères, on peut écrire :

```kotlin
operator fun String.plus(other: String): String = this + other
```

Cette fonction ajoute une méthode `plus()` à la classe `String`. Cette méthode retourne la concaténation des deux chaînes de caractères.

### Exemple

```kotlin
fun main() {
    val s = "Hello"
    println(s.lastChar())
    println(s + " world")
}
```
