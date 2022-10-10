# Cours

## Souvenir (Memento)

Le design pattern Memento permet de sauvegarder l'état d'un objet pour le restaurer plus tard.

Sans violer le principe d'encapsulation, capture et externalise l'état interne d'un objet.

### Exemple

```kotlin
enum class StarType {
    SUN,
    RED_GIANT,
    WHITE_DWARF,
    SUPERNOVA,
    DEAD,
}

interface StarMemento {
}


data class Star(
    var type: StarType,
    var age: Long,
    var mass: Double,
    var radius: Double,
) {
    data class StarMementoInternal(
        val starType: StarType,
        val age: Long,
        val mass: Double,
        val radius: Double,
    ) : StarMemento

    fun timePasses() {
        when (type) {
            StarType.SUN -> {
                age += 1000000
                mass += 1000000
                radius += 1000000
            }
            StarType.RED_GIANT -> {
                age += 100000
                mass -= 100000
                radius -= 100000
            }
            StarType.WHITE_DWARF -> {
                age += 100000
                mass -= 100000
                radius -= 100000
            }
            StarType.SUPERNOVA -> {
                age += 100000
                mass -= 100000
                radius -= 100000
            }
            StarType.DEAD -> {
                age += 100000
                mass -= 100000
                radius -= 100000
            }
        }
    }

    fun evolve() {
        when (type) {
            StarType.SUN -> {
                type = StarType.RED_GIANT
            }
            StarType.RED_GIANT -> {
                type = StarType.WHITE_DWARF
            }
            StarType.WHITE_DWARF -> {
                type = StarType.SUPERNOVA
            }
            StarType.SUPERNOVA -> {
                type = StarType.DEAD
            }
            StarType.DEAD -> {
                type = StarType.DEAD
            }
        }
    }

    fun getMemento(): StarMemento {
        return StarMementoInternal(
            type,
            age,
            mass,
            radius,
        )
    }

    fun setMemento(memento: StarMemento) {
        val state: StarMementoInternal = memento as StarMementoInternal
        type = state.starType
        age = state.age
        mass = state.mass
        radius = state.radius
    }

}

fun main() {
    val star = Star(StarType.SUN, 1000000, 1000000.0, 1000000.0)
    val memento = star.getMemento()
    star.timePasses()
    star.evolve()
    println(star)
    println("Rolling back to memento")
    star.setMemento(memento!!)
    println(star)
}
```

### Résultat

```text
Star(type=RED_GIANT, age=2000000, mass=2000000.0, radius=2000000.0)
Rolling back to memento
Star(type=SUN, age=1000000, mass=1000000.0, radius=1000000.0)
```

# Exercice

Nous allons utiliser le memento pour sauvegarder l'état d'un logiciel de traitement de texte.

Nous allons créer une classe `TextEditor` qui va permettre d'écrire du texte. Cet éditeur de texte possèdera les méthodes

* `write(text: String)` : permet d'écrire du texte
* `undo()` : permet d'annuler la dernière action
* `show()` : permet d'afficher le texte

Il contiendra également une propriété `text` qui contiendra le texte écrit.

Nous allons créer une classe `TextEditorMemento` qui va permettre de sauvegarder l'état de l'éditeur de texte. C'est cette classe qui sera sauvegardée dans la pile des modifications.


