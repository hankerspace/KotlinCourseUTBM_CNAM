# Cours

## Héritage

L'héritage est un concept fondamental de la programmation orientée objet. Il s'agit de la capacité à créer une nouvelle classe à partir d'une classe existante. Cette nouvelle classe hérite des données et des méthodes de la classe existante. Cela permet de créer des objets qui sont plus faciles à manipuler et à réutiliser.

Lors d'une relation d'héritage, une classe est appelée classe parente et l'autre classe est appelée classe fille. La classe fille hérite des données et des méthodes de la classe parente. La classe fille peut ajouter ses propres données et méthodes. La classe fille peut également redéfinir les méthodes de la classe parente.

Un moyen mnémotechnique est de se dire que la classe fille **est un** de la classe parente. Par exemple, un chat est un animal. Un chat est donc une classe fille de la classe parente Animal.

En Kotlin, l'héritage est défini par le mot-clé `:`, suivi du nom de la classe parente. Par exemple, la classe `Chat` hérite de la classe `Animal` :

```kotlin
class Chat : Animal() {
    // ...
}
```

Par défaut une classe est `final` et ne peut donc pas être héritée. Pour permettre l'héritage, il faut ajouter le mot-clé `open` devant la déclaration de la classe :

```kotlin
open class Animal {
    // ...
}
```

## Exemple

Voici un exemple de relation d'héritage entre deux classes :

```kotlin
open class Animal {
    fun manger() {
        println("Je mange")
    }
}

class Chat : Animal() {
    fun miauler() {
        println("Miaou")
    }
}
```

La classe Chat hérite de la classe Animal. La classe Chat peut donc utiliser les méthodes de la classe Animal. La classe Chat peut également ajouter ses propres méthodes.

Ainsi, la classe Chat peut utiliser la méthode manger() de la classe Animal :

```kotlin
val chat = Chat()
chat.manger()
```

La classe Chat peut également utiliser sa propre méthode miauler() :

```kotlin
val chat = Chat()
chat.miauler()
```

## Redéfinition de méthodes

La classe fille peut redéfinir les méthodes de la classe parente. Par exemple, la classe Chat peut redéfinir la méthode manger() de la classe Animal :

La redéfinition se fait en définissant une méthode avec le même nom dans la classe fille. La classe fille peut alors utiliser sa propre méthode manger(). Le mot clé `override` est utilisé pour indiquer que la méthode est redéfinie.

Par défaut une méthode est `final` et ne peut donc pas être redéfinie. Pour permettre la redéfinition, il faut ajouter le mot-clé `open` devant la déclaration de la méthode.

```kotlin
open class Animal {
    open fun manger() {
        println("Je mange")
    }
}

class Chat : Animal() {
    fun miauler() {
        println("Miaou")
    }

    override fun manger() {
        println("Je mange du poisson")
    }
}
```

## Constructeur

La classe fille peut également redéfinir le constructeur de la classe parente. Par exemple, la classe Chat peut redéfinir le constructeur de la classe Animal :

```kotlin
open class Animal(val nom: String) {
  fun manger() {
    println("$nom mange")
  }
}

class Chat(nom: String) : Animal("Chat $nom") {
  fun miauler() {
    println("Miaou")
  }
}
```

Dans cet exemple, la classe Chat redéfinit le constructeur de la classe Animal. La classe Chat appelle le constructeur de la classe Animal en lui passant le nom du chat. La classe Chat peut alors utiliser le nom du chat dans ses méthodes.

## Polymorphisme

Le polymorphisme est un concept fondamental de la programmation orientée objet. Il permet de définir des classes qui peuvent être utilisées de manière interchangeable. Par exemple, on peut définir une classe `Animal` qui contient une méthode `crier` qui affiche le son que fait l'animal. On peut ensuite définir des classes `Chien` et `Chat` qui héritent de `Animal` et qui redéfinissent la méthode `crier` pour afficher le son que fait le chien ou le chat. On peut ensuite créer une liste d'animaux et ajouter des chiens et des chats à cette liste. On peut ensuite parcourir cette liste et appeler la méthode `crier` sur chaque animal. Le programme affichera alors le son que fait le chien ou le chat.

## Exemple

```kotlin
open class Animal {
    open fun crier() {
        println("Je ne sais pas crier")
    }
}

class Chien : Animal() {
    override fun crier() {
        println("Wouaf")
    }
}

class Chat : Animal() {
    override fun crier() {
        println("Miaou")
    }
}

fun main() {
    val animaux = listOf(Chien(), Chat())
    for (animal in animaux) {
        animal.crier()
    }
}
```

### Protected

Les membres d'une classe peuvent être déclarés `protected`. Un membre `protected` est accessible dans la classe et dans les classes filles. Par contre il ne sera pas visible en dehors (autres classes, etc).

```kotlin
open class Animal {
    protected fun manger() {
        println("Je mange")
    }
}

class Chat : Animal() {
    fun miauler() {
        println("Miaou")
    }

    override fun manger() {
        println("Je mange du poisson")
    }
}
```

# Exercice

Suivez les instructions pour mener a bien l'exercice.


