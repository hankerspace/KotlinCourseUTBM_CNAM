# Cours

## Pont (Bridge)

Le design pattern Pont (Bridge) permet de séparer une abstraction de son implémentation afin qu'elles puissent être développées indépendamment l'une de l'autre.

Le pattern Pont est un design pattern de type structurel. Son but est de préférer la composition à l'héritage. Les détails d'implémentation sont poussés d'une hiérarchie à un autre objet avec une hiérarchie séparée.

Le pattern Pont est souvent utilisé lorsque on doit étendre une classe dans plusieurs dimensions indépendantes. 

Par exemple, la classe `Forme` peut être étendue en deux dimensions indépendantes : en couleur et en forme. On peut créer une classe `FormeRondeVerte` et une classe `FormeRondeBleue` qui étendent `FormeRonde` et `FormeVerte` respectivement. Cependant, il y a 2 problèmes avec cette approche :

1. La classe `FormeRondeVerte` hérite de `FormeRonde` et `FormeVerte` et donc elle hérite de toutes les méthodes de ces deux classes. Cependant, elle n'a pas besoin de toutes ces méthodes. Cela peut causer des problèmes de performance et de complexité.
2. Si on veut ajouter une nouvelle forme ou une nouvelle couleur, il faut créer une nouvelle classe pour chaque combinaison. Par exemple, si on veut ajouter une forme triangulaire, il faut créer 3 classes : `FormeTriangulaire`, `FormeTriangulaireRouge` et `FormeTriangulaireBleue`.

Le pattern Pont permet de résoudre ces problèmes en séparant l'abstraction de son implémentation. On peut créer une classe `Forme` qui contient une référence à une classe `Couleur` et une méthode `dessiner()` qui appelle la méthode `remplir()` de la classe `Couleur`. On peut ensuite créer des classes `FormeRonde` et `FormeTriangulaire` qui étendent `Forme` et des classes `CouleurRouge` et `CouleurBleue` qui étendent `Couleur`.

Ainsi, on peut créer une forme ronde rouge en créant une instance de `FormeRonde` et en lui passant une instance de `CouleurRouge` en paramètre. On peut ensuite appeler la méthode `dessiner()` de la forme ronde rouge pour dessiner la forme ronde rouge.

### Exemple

```kotlin
interface Couleur {
    fun remplir()
}

class CouleurRouge : Couleur {
    override fun remplir() {
        println("Remplissage de la forme avec la couleur rouge")
    }
}

class CouleurBleue : Couleur {
    override fun remplir() {
        println("Remplissage de la forme avec la couleur bleue")
    }
}

abstract class Forme(protected val couleur: Couleur) {
    abstract fun dessiner()
}

class FormeRonde(couleur: Couleur) : Forme(couleur) {
    override fun dessiner() {
        println("Dessin d'une forme ronde")
        couleur.remplir()
    }
}

class FormeTriangulaire(couleur: Couleur) : Forme(couleur) {
    override fun dessiner() {
        println("Dessin d'une forme triangulaire")
        couleur.remplir()
    }
}

fun main() {
    val formeRondeRouge = FormeRonde(CouleurRouge())
    formeRondeRouge.dessiner()

    val formeTriangulaireBleue = FormeTriangulaire(CouleurBleue())
    formeTriangulaireBleue.dessiner()
}
```

### Résultat

```
Dessin d'une forme ronde
Remplissage de la forme avec la couleur rouge
Dessin d'une forme triangulaire
Remplissage de la forme avec la couleur bleue
```

# Exercice

Nous allons utiliser le design pattern bridge pour enchanter des armes. Nous allons créer une interface `Enchantement` qui contient une méthode `appliquerEnchantement()` et deux classes `EnchantementFeu` et `EnchantementGlace` qui étendent `Enchantement`. 

Nous allons ensuite créer une interface `Arme` qui contient une méthode `attaquer()` et deux classes `Epee` et `Hache` qui étendent `Arme`. 

Enfin, nous allons créer une classe `ArmeEnchante` qui contient une référence à une arme et un enchantement et qui étend `Arme`. La méthode `attaquer()` de la classe `ArmeEnchante` appelle la méthode `attaquer()` de l'arme et la méthode `appliquerEnchantement()` de l'enchantement.

