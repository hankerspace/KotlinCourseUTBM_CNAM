# Cours

## Variables

Les variables en Kotlin peuvent être déclarées de deux façons différentes. La première consiste à déclarer la variable avec le mot clé `var` et la seconde avec le mot clé `val`. La différence entre les deux est que `var` permet de modifier la valeur de la variable alors que `val` ne permet pas de modifier la valeur de la variable.

```kotlin
var a = 1
a = 2
val b = 1
b = 2 // Erreur
```

Une variable peut avoir un type explicite ou implicite. Si le type est explicite, il est défini après le nom de la variable. Si le type est implicite, il est déduit du type de la valeur de la variable.

```kotlin
val a: Int = 1
val b = 1
```

### Rappel sur les types de variables

| Type | Description |
| --- | --- |
| `Boolean` | Valeur booléenne |
| `Byte` | Entier signé sur 8 bits |
| `Short` | Entier signé sur 16 bits |
| `Int` | Entier signé sur 32 bits |
| `Long` | Entier signé sur 64 bits |
| `Float` | Nombre à virgule flottante sur 32 bits |
| `Double` | Nombre à virgule flottante sur 64 bits |
| `Char` | Caractère Unicode |
| `String` | Chaîne de caractères |

Les types que nous utiliseront le plus souvent sont `Int`, `Double`, et `String`.

### Portée

La portée d'une variable est la zone du programme où elle est accessible. Une variable déclarée dans une fonction n'est accessible que dans cette fonction. Une variable déclarée dans une classe est accessible dans la classe et dans les classes qui en héritent.

# Exercice

## Bonjour

Modifiez le contenu de la fonction pour renvoyer une String "Bonjour nom" où nom est le nom passé en paramètre de la fonction.

Vous <i>pouvez</i> utiliser une variable pour stocker le résultat avant de l'envoyer.

<div class="hint">
  Vous pouvez utiliser la concaténation de String
</div>
