# Cours

## Définition d'une classe

Une classe est un modèle qui permet de définir un type de données. Elle est composée de :

- des attributs (variables)
- des méthodes (fonctions)
- des constructeurs (fonctions spéciales)
- des propriétés (variables calculées)

Tous ces éléments sont définis dans le corps de la classe. Ils sont optionnels. Par exemple, une classe peut ne contenir que des méthodes.

La définition d'une classe se fait avec le mot-clé `class` suivi du nom de la classe. Le nom d'une classe commence toujours par une majuscule.

```kotlin
class Personne
```

En Kotlin, une classe est définie comme un type de données. Elle peut donc être utilisée comme type de retour d'une fonction ou comme type de paramètre d'une fonction.

```kotlin
fun afficherPersonne(personne: Personne) {
    println(personne)
}
```

### Attributs

Les attributs d'une classe sont définis dans le corps de la classe. Ils sont déclarés avec le mot-clé `var` ou `val` suivi du nom de l'attribut. Par convention, le nom des attributs commence toujours par une minuscule.

```kotlin
class Personne {
    var nom: String
    var prenom: String
}
```

### Méthodes

Les méthodes d'une classe sont définies dans le corps de la classe. Elles sont déclarées avec le mot-clé `fun` suivi du nom de la méthode. Par convention, le nom des méthodes commence toujours par une minuscule.

```kotlin
class Personne {
    fun afficher() {
        println("Personne")
    }
}
```

### Constructeurs

Les constructeurs d'une classe sont définis dans le corps de la classe. Ils sont déclarés avec le mot-clé `constructor` suivi du nom du constructeur. Par convention, le nom des constructeurs commence toujours par une majuscule.

```kotlin
class Personne {
    constructor(nom: String, prenom: String) {
        this.nom = nom
        this.prenom = prenom
    }
}
```

Une façon plus concise de définir un constructeur est d'utiliser le mot-clé `init`. Le constructeur est alors défini dans le bloc `init`.

```kotlin
class Personne(nom: String, prenom: String) {
    init {
        this.nom = nom
        this.prenom = prenom
    }
}
```

Kotlin permet de définir plusieurs constructeurs pour une même classe. Pour cela, il faut définir un constructeur primaire et des constructeurs secondaires. Le constructeur primaire est défini dans le corps de la classe. Les constructeurs secondaires sont définis avec le mot-clé `constructor` suivi du nom du constructeur. Par convention, le nom des constructeurs commence toujours par une majuscule.

```kotlin
class Personne(nom: String, prenom: String) {
    var nom: String
    var prenom: String

    init {
        this.nom = nom
        this.prenom = prenom
    }

    constructor(nom: String) : this(nom, "")
}
```

### Constructeur façon Kotlin

Kotlin permet de définir un constructeur de façon plus concise. Il suffit de définir les attributs de la classe dans le constructeur.

```kotlin
class Personne(var nom: String, var prenom: String)
```

Ce code permet de définir les attributs `nom` et `prenom` de la classe `Personne`. Il permet également de définir un constructeur qui prend en paramètre les valeurs des attributs `nom` et `prenom`.

### Propriétés

Les propriétés d'une classe sont définies dans le corps de la classe. Elles sont déclarées avec le mot-clé `val` suivi du nom de la propriété. Par convention, le nom des propriétés commence toujours par une minuscule.

```kotlin
class Personne {
    val nomComplet: String
        get() = "$nom $prenom"
}
```

### Visibilité des attributs, méthodes et propriétés

Par défaut, les attributs, méthodes et propriétés d'une classe sont publics. Il est possible de les rendre privés en les déclarant avec le mot-clé `private`.

```kotlin
class Personne {
    private var nom: String
    private var prenom: String

    private fun afficher() {
        println("Personne")
    }

    public val nomComplet: String // public inutile car implicite
        get() = "$nom $prenom"
}
```

Un attribut, une méthode ou une propriété privée ne peut être utilisée que dans la classe où elle est définie. Elle ne peut pas être utilisée dans une autre classe (ou dans le main).

## Utilisation d'une classe

### Instanciation d'une classe

Une classe est instanciée en utilisant du nom de la classe. Contrairement à Java, il n'est pas nécessaire d'utiliser le mot-clé `new`.

```kotlin
val personne = Personne()
```

Si le constructeur de la classe prend des paramètres, il faut les passer en paramètre de l'instanciation.

```kotlin
val personne = Personne("Dupont", "Jean")
```

### Utilisation des attributs

Les attributs d'une classe sont utilisés en utilisant le nom de l'attribut.

```kotlin
val personne = Personne("Dupont", "Jean")
println(personne.nom)
println(personne.prenom)
```

### Utilisation des méthodes

Les méthodes d'une classe sont utilisées en utilisant le nom de la méthode.

```kotlin
val personne = Personne("Dupont", "Jean")
personne.afficher()
```

### Utilisation des propriétés

Les propriétés d'une classe sont utilisées en utilisant le nom de la propriété.

```kotlin
val personne = Personne("Dupont", "Jean")
println(personne.nomComplet)
```

# Exercice


