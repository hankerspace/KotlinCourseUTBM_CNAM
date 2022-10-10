# Cours

## Méthode modèle (Template Method)

Le design pattern Méthode modèle (Template Method) est un patron de conception comportemental qui permet de définir la structure d'un algorithme dans une classe mère, puis de laisser les classes filles redéfinir certains de ses étapes sans modifier la structure de l'algorithme.

Le patron Méthode modèle souligne les étapes générales dans la classe mère et permet aux implémentations concrètes des enfants de définir les détails.

Le patron Méthode modèle est souvent utilisé dans les bibliothèques et les frameworks pour fournir des fonctionnalités communes.

## Exemple

```kotlin
abstract class AbstractClass {
    fun templateMethod() {
        primitiveOperation1()
        primitiveOperation2()
    }

    abstract fun primitiveOperation1()
    abstract fun primitiveOperation2()
}

class ConcreteClass : AbstractClass() {
    override fun primitiveOperation1() {
        println("ConcreteClass.primitiveOperation1()")
    }

    override fun primitiveOperation2() {
        println("ConcreteClass.primitiveOperation2()")
    }
}

fun main() {
    val concreteClass = ConcreteClass()
    concreteClass.templateMethod()
}
```

## Résultat

```text
ConcreteClass.primitiveOperation1()
ConcreteClass.primitiveOperation2()
```

# Exercice

Nous allons utiliser le patron Méthode modèle pour créer une application de séduction basé sur les méthodes de Barney Stinson.

![img.png](img.png)

Les techniques de séduction (Trick) de Barney Stinson suivent tout le temps la même structure :

1. Il commence par préparer son environnement (accesoires, costumes, etc.)
2. Il utilise une phrase d'accroche
3. Il termine par le bouquet final de la technique de séduction

Nous allons créer une classe abstraite `Trick` qui contiendra la structure de la technique de séduction. 

Cette classe abstraite contiendra les méthodes abstraites suivantes :

- `prepareEnvironment()` : prépare l'environnement
- `start()` : phrase d'accroche
- `end()` : bouquet final

Et la méthode : 

- `perform()` : méthode finale qui appelle les méthodes précédentes dans l'ordre

Les classes filles `TrickLVM` (Lorenzo von Matterhorn), `TrickSD` (Scuba Diver) et `TrickSNASA` (Secret NASA) implémenteront les détails de chaque technique de séduction.

Vous créerez une classe `BarneyStinson` qui effectuera la technique de séduction définie en attribut. Vous testerez votre code avec les différentes techniques de séduction.

## Références

[https://how-i-met-your-mother.fandom.com/wiki/The_Playbook_(book)](https://how-i-met-your-mother.fandom.com/wiki/The_Playbook_(book)) contient les détails des différents Tricks de Barney Stinson. Afin de vous aider dans leur implémentation.



