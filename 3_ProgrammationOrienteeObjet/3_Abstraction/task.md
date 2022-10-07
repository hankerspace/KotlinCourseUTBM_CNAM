# Cours

## Abstraction

### Introduction

L'abstraction est une notion fondamentale en programmation orientée objet. Elle permet de définir des classes abstraites, qui ne peuvent pas être instanciées, mais qui servent de base à d'autres classes. C'est une notion très importante en programmation orientée objet.

Pour savoir si une classe doit être abstraite ou non, il faut se demander si elle a une existence concrète possible ou non. Si oui, alors elle ne doit pas être abstraite. Si non, alors elle doit être abstraite.

### Définition

On définit une classe abstraite en utilisant le mot clé `abstract` devant le mot clé `class`. 

```kotlin
abstract class MaClasse
```

Une classe abstraite ne peut pas être instanciée. Si on essaie de le faire, on aura une erreur de compilation.

```kotlin
abstract class MaClasse

fun main() {
    val maClasse = MaClasse() // Erreur de compilation
}
```

### Méthodes abstraites

Une classe abstraite peut contenir des méthodes abstraites. Une méthode abstraite est une méthode qui n'a pas de corps. Elle est définie avec le mot clé `abstract` devant le mot clé `fun`.

```kotlin
abstract class MaClasse {
    abstract fun maMethode()
}
```

Une classe abstraite peut contenir des méthodes abstraites et des méthodes normales. Les méthodes normales peuvent avoir un corps.

```kotlin
abstract class MaClasse {
    abstract fun maMethode()
    
    fun maMethode2() {
        println("Je suis une méthode normale")
    }
}
```

Les méthodes abstraites doivent être implémentées dans les classes qui héritent de la classe abstraite. Pour cela, on utilise le mot clé `override` devant le mot clé `fun`.

```kotlin
abstract class MaClasse {
    abstract fun maMethode()
}

class MaClasseEnfant : MaClasse() {
    override fun maMethode() {
        println("Je suis une méthode abstraite")
    }
}
```

### Attributs abstraits

Une classe abstraite peut contenir des attributs abstraits. Un attribut abstrait est un attribut qui n'a pas de valeur. Il est défini avec le mot clé `abstract` devant le mot clé `var` ou `val`.

```kotlin
abstract class MaClasse {
    abstract val maVariable: Int
}
```

Les attributs abstraits doivent être implémentés dans les classes qui héritent de la classe abstraite. Pour cela, on utilise le mot clé `override` devant le mot clé `var` ou `val`.

```kotlin
abstract class MaClasse {
    abstract val maVariable: Int
}

class MaClasseEnfant : MaClasse() {
    override val maVariable: Int = 5
}
```

### Constructeurs abstraits

Une classe abstraite peut contenir des constructeurs abstraits. Un constructeur abstrait est un constructeur qui n'a pas de corps. Il est défini avec le mot clé `abstract` devant le mot clé `constructor`.

```kotlin
abstract class MaClasse {
    abstract constructor()
}
```

Les constructeurs abstraits doivent être implémentés dans les classes qui héritent de la classe abstraite. Pour cela, on utilise le mot clé `override` devant le mot clé `constructor`.

```kotlin
abstract class MaClasse {
    abstract constructor()
}

class MaClasseEnfant : MaClasse() {
    override constructor() {
        println("Je suis un constructeur abstrait")
    }
}
```

### Exemple

```kotlin
abstract class Personne(val nom: String, val prenom: String) {
    abstract fun sePresenter()
}

class Etudiant(nom: String, prenom: String, val numeroEtudiant: Int) : Personne(nom, prenom) {
    override fun sePresenter() {
        println("Je suis $prenom $nom et mon numéro d'étudiant est $numeroEtudiant")
    }
}

class Professeur(nom: String, prenom: String, val matiere: String) : Personne(nom, prenom) {
    override fun sePresenter() {
        println("Je suis $prenom $nom et je donne le cours de $matiere")
    }
}

fun main() {
    val etudiant = Etudiant("Dupont", "Jean", 123456)
    val professeur = Professeur("Martin", "Marie", "Mathématiques")
    
    etudiant.sePresenter()
    professeur.sePresenter()
}
```

# Exercices

Effectuez les exercices suivants en respectant les instructions.

<div class="hint">
    La valeur de PI peut être obtenue avec la constante <code>Math.PI</code>.
</div>