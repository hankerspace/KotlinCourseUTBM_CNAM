# Cours

## Décorateur (Decorator)

Le décorateur est un patron de conception structurel qui permet de modifier le comportement d'un objet en l'entourant d'un autre objet avec une interface similaire.

Afin d'implémenter le patron de conception décorateur, nous avons besoin d'une classe à décorer et d'une classe décorateur. La classe décorateur doit implémenter la même interface que la classe à décorer. La classe décorateur doit avoir une référence vers la classe à décorer. La classe décorateur doit implémenter toutes les méthodes de l'interface de la classe à décorer. La classe décorateur doit déléguer les appels aux méthodes de l'interface à la classe à décorer. La classe décorateur peut ajouter de nouvelles méthodes à l'interface de la classe à décorer. La classe décorateur peut ajouter de nouvelles fonctionnalités à la classe à décorer.

### Exemple

Nous allons utiliser le décorateur pour ajouter des fonctionnalités à un objet sans modifier son code.

Nous allons créer une classe `Sandwich` qui représente un sandwich. Nous allons ensuite créer une classe `SandwichDecorator` qui va nous permettre d'ajouter des fonctionnalités à notre sandwich.

```kotlin
class Sandwich {
    fun make() = "Pain"
}

abstract class SandwichDecorator(private val sandwich: Sandwich) : Sandwich() {
    override fun make() = sandwich.make()
}

class Ketchup(sandwich: Sandwich) : SandwichDecorator(sandwich) {
    override fun make() = super.make() + " + Ketchup"
}

class Mayonnaise(sandwich: Sandwich) : SandwichDecorator(sandwich) {
    override fun make() = super.make() + " + Mayonnaise"
}

class Oignon(sandwich: Sandwich) : SandwichDecorator(sandwich) {
    override fun make() = super.make() + " + Oignon"
}
```

Nous pouvons maintenant créer un sandwich avec des fonctionnalités supplémentaires.

```kotlin
fun main() {
    val sandwich = Sandwich()
    println(sandwich.make()) // Pain

    val sandwichKetchup = Ketchup(sandwich)
    println(sandwichKetchup.make()) // Pain + Ketchup

    val sandwichKetchupMayonnaise = Mayonnaise(sandwichKetchup)
    println(sandwichKetchupMayonnaise.make()) // Pain + Ketchup + Mayonnaise

    val sandwichKetchupMayonnaiseOignon = Oignon(sandwichKetchupMayonnaise)
    println(sandwichKetchupMayonnaiseOignon.make()) // Pain + Ketchup + Mayonnaise + Oignon
}
```

# Exercice

Nous allons utiliser le décorateur pour équiper un `Troll` avec une arme et un bouclier.

Utilisez la classe `Troll` pour créer un `SimpleTroll` puis les décorateurs suivants :
- un `ClubbedTroll` qui ajoute un gourdin au troll. 
- un `ArmoredTroll` qui ajoute une armure au troll.
- un `BootedTroll` qui ajoute des bottes au troll.
