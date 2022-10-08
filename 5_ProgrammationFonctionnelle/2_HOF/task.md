# Cours

## Fonctions de premier ordre

Voici certains exemples de fonctions de premier ordre disponibles dans la bibliothèque standard de Kotlin.

### Fonctions de transformation

Les fonctions de transformation sont des fonctions qui prennent une fonction en paramètre et retournent une fonction.

#### map

La fonction `map` prend une fonction en paramètre et retourne une fonction qui applique cette fonction à chaque élément de la collection.

```kotlin
val numbers = listOf(1, 2, 3)
val triple = { x: Int -> x * 3 }
val tripledNumbers = numbers.map(triple)
```

#### filter

La fonction `filter` prend une fonction en paramètre et retourne une fonction qui applique cette fonction à chaque élément de la collection et retourne une nouvelle collection contenant uniquement les éléments pour lesquels la fonction retourne `true`.

```kotlin
val numbers = listOf(1, 2, 3)
val isEven = { x: Int -> x % 2 == 0 }
val evenNumbers = numbers.filter(isEven)
```

#### fold

La fonction `fold` prend une fonction en paramètre et retourne une fonction qui applique cette fonction à chaque élément de la collection et retourne un résultat.

```kotlin
val numbers = listOf(1, 2, 3)
val sum = { x: Int, y: Int -> x + y }
val sumOfNumbers = numbers.fold(0, sum)
```

### Fonctions de composition

Les fonctions de composition sont des fonctions qui prennent deux fonctions en paramètre et retournent une fonction.

#### compose

La fonction `compose` prend deux fonctions en paramètre et retourne une fonction qui applique la première fonction à l'argument de la seconde fonction.

```kotlin
val addOne = { x: Int -> x + 1 }
val multiplyByTwo = { x: Int -> x * 2 }
val addOneThenMultiplyByTwo = compose(addOne, multiplyByTwo)
val result = addOneThenMultiplyByTwo(3) // 7
```

#### andThen

La fonction `andThen` prend deux fonctions en paramètre et retourne une fonction qui applique la seconde fonction à l'argument de la première fonction.

```kotlin
val addOne = { x: Int -> x + 1 }
val multiplyByTwo = { x: Int -> x * 2 }
val multiplyByTwoThenAddOne = andThen(multiplyByTwo, addOne)
val result = multiplyByTwoThenAddOne(3) // 7
```

### Fonctions de conversion

Les fonctions de conversion sont des fonctions qui prennent une fonction en paramètre et retournent une valeur.

#### run

La fonction `run` prend une fonction en paramètre et retourne le résultat de cette fonction.

```kotlin
val result = run { 1 + 1 }
```

#### let

La fonction `let` prend une fonction en paramètre et retourne le résultat de cette fonction.

```kotlin
val result = 1.let { it + 1 }
```

#### apply

La fonction `apply` prend une fonction en paramètre et retourne l'objet sur lequel la fonction a été appelée.

```kotlin
val result = StringBuilder().apply { append("Hello") }.append(" World").toString()
```

#### also

La fonction `also` prend une fonction en paramètre et retourne l'objet sur lequel la fonction a été appelée.

```kotlin
val result = 1.also { it + 1 }
```

#### with

La fonction `with` prend une fonction en paramètre et retourne le résultat de cette fonction.

```kotlin
val result = with(1) { this + 1 }
```

#### takeIf

La fonction `takeIf` prend une fonction en paramètre et retourne l'objet sur lequel la fonction a été appelée si la fonction retourne `true`.

```kotlin
val result = 1.takeIf { it > 0 }
```

#### takeUnless

La fonction `takeUnless` prend une fonction en paramètre et retourne l'objet sur lequel la fonction a été appelée si la fonction retourne `false`.

```kotlin
val result = 1.takeUnless { it < 0 }
```

### Fonctions de contrôle

Les fonctions de contrôle sont des fonctions qui prennent une fonction en paramètre et retournent une valeur.

#### repeat

La fonction `repeat` prend un nombre et une fonction en paramètre et exécute la fonction le nombre de fois indiqué.

```kotlin
repeat(3) { println("Hello") }
```

### Fonctions de traitement

Les fonctions de traitement sont des fonctions qui prennent une fonction en paramètre et retournent une valeur.

#### forEach

La fonction `forEach` prend une fonction en paramètre et exécute cette fonction pour chaque élément de la collection.

```kotlin
val numbers = listOf(1, 2, 3)
numbers.forEach { println(it) }
```

#### onEach

La fonction `onEach` prend une fonction en paramètre et exécute cette fonction pour chaque élément de la collection.

```kotlin
val numbers = listOf(1, 2, 3)
numbers.onEach { println(it) }
```

#### forEachIndexed

La fonction `forEachIndexed` prend une fonction en paramètre et exécute cette fonction pour chaque élément de la collection en passant en paramètre l'index de l'élément.

```kotlin
val numbers = listOf(1, 2, 3)
numbers.forEachIndexed { index, number -> println("$index: $number") }
```

#### onEachIndexed

La fonction `onEachIndexed` prend une fonction en paramètre et exécute cette fonction pour chaque élément de la collection en passant en paramètre l'index de l'élément.

```kotlin
val numbers = listOf(1, 2, 3)
numbers.onEachIndexed { index, number -> println("$index: $number") }
```

La différence entre `forEach` et `onEach` est que `forEach` retourne `Unit` et `onEach` retourne la collection.

## Fonctions supplémentaires

Pour avoir plus d'infos ou découvrir plus de fonctions, je vous invite à consulter la [documentation officielle](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/index.html).

Vous pouvez également utiliser votre IDE pour visualiser les propositions de complétion sur chaque type de données.

# Exercices


