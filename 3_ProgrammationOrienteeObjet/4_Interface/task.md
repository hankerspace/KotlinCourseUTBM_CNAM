# Cours

## Interface

Les interfaces sont des classes abstraites qui ne contiennent que des méthodes abstraites. Elles servent à définir un comportement. Elles sont utilisées pour définir des comportements communs à plusieurs classes.

Elles sont définies avec le mot clé `interface` et les méthodes sont définies avec le mot clé `fun`.

### Exemple

```kotlin
interface Animal {
    fun manger()
    fun dormir()
    fun parler()
}
```

### Exemple d'utilisation

```kotlin
class Chat : Animal {
    override fun manger() {
        println("Je mange des croquettes")
    }

    override fun dormir() {
        println("Je dors dans un panier")
    }

    override fun parler() {
        println("Miaou")
    }
}
```

Une interface peut hériter d'une autre interface. Dans ce cas, les méthodes de l'interface parente sont héritées par l'interface enfant.

Les classes qui implémentent une interface doivent implémenter toutes les méthodes de l'interface.

## Implémentations

Une classe peut implémenter plusieurs interfaces. Dans ce cas, les méthodes de toutes les interfaces sont implémentées.

```kotlin
class Chat : Dormeur, Parleur, Mangeur {
    override fun manger() {
        println("Je mange des croquettes")
    }

    override fun dormir() {
        println("Je dors dans un panier")
    }

    override fun parler() {
        println("Miaou")
    }
}
```

## Héritage simple

En Kotlin on peut hériter d'une seule classe. Cependant, on peut implémenter plusieurs interfaces.

```kotlin
class Chat : Animal, Mangeur {
    override fun manger() {
        println("Je mange des croquettes")
    }

    override fun dormir() {
        println("Je dors dans un panier")
    }

    override fun parler() {
        println("Miaou")
    }
}
```

## Utilisation d'une interface

Une interface peut être utilisée comme type de variable. Dans ce cas, la variable peut contenir une instance de n'importe quelle classe qui implémente l'interface.

```kotlin
fun main() {
    val mangeur: Mangeur = Chat()
    mangeur.manger()
}
```

## Nommage des interfaces

Les interfaces sont nommées avec le suffixe `able` ou `ible`.

### Exemple

```kotlin
interface Eatable {
    fun eat()
}

interface Sleepable {
    fun sleep()
}
```

## Test de l'implémentation d'une interface

On peut tester si une classe implémente une interface ou une classe avec l'opérateur `is`.

```kotlin
fun main() {
    val animal: Animal = Chat()
    if (animal is Eatable) {
        animal.eat()
    }
}
```

# Exercice

