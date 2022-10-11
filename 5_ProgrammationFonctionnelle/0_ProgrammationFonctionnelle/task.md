# Programmation fonctionnelle

## Introduction

Kotlin est un langage de programmation qui supporte la programmation fonctionnelle.

La programmation fonctionnelle est un paradigme de programmation qui utilise l'utilisation de fonctions pour résoudre des problèmes. Elle est basée sur l'utilisation de fonctions, et de fonctions qui prennent en paramètre d'autres fonctions.

Ses grandes forces sont la simplicité et la modularité. Il est facile de comprendre et de lire un code écrit en programmation fonctionnelle. En effet, chaque fonction est indépendante, et ne dépend pas des autres fonctions. Chaque fonction est donc indépendante, et peut être réutilisée dans d'autres programmes.

Les principales caractéristiques d'un langage de programmation fonctionnel sont:

* Les fonctions sont des variables
* Les fonctions peuvent être passées en paramètre
* Les fonctions peuvent être retournées par une autre fonction
* Les fonctions peuvent être déclarées dans une fonction
* Fonctions anonymes
* Fonctions lambda
* Fonctions récursives
* Etc.

# Création de fonctions

## Fonctions anonymes (ou lambda)

Les fonctions anonymes sont des fonctions qui n'ont pas de nom. Elles sont déclarées dans une variable, et peuvent être utilisées comme n'importe quelle autre variable.

```kotlin
val f = { x: Int -> x * x }
```

## Fonctions de premier ordre (ou de haut niveau)

Les fonctions de premier ordre sont des fonctions qui prennent en paramètre une autre fonction, ou qui retournent une fonction.

```kotlin
fun main(args: Array<String>) {
    val f = { x: Int -> x * x }
    val g = { x: Int -> x + 1 }
    val h = { x: Int -> f(x) + g(x) }
}
```

## Variable it

La variable `it` est une variable implicite qui représente le premier paramètre d'une fonction lambda.

Par exemple, la fonction forEach prend en paramètre une fonction lambda qui prend en paramètre un élément de la liste, et qui ne retourne rien.

```kotlin
val list = listOf(1, 2, 3, 4, 5)
list.forEach { println(it) }
```

La variable it peut être remplaçée par une variable explicite.

```kotlin
val list = listOf(1, 2, 3, 4, 5)
list.forEach { element -> println(element) }
```


# Appel de fonctions

## Fonctions anonymes

Les fonctions anonymes sont appelées en utilisant la variable qui les contient.

```kotlin
val f = { x: Int -> x * x }
f(2) // 4
```

## Fonctions de premier ordre

Les fonctions de premier ordre sont appelées en utilisant la variable qui les contient.

```kotlin
fun main(args: Array<String>) {
    val f = { x: Int -> x * x }
    val g = { x: Int -> x + 1 }
    val h = { x: Int -> f(x) + g(x) }
    h(2) // 9
}
```

# Exemples

Exécutez les exemples suivants pour voir comment les fonctions anonymes et de premier ordre sont utilisées.