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

