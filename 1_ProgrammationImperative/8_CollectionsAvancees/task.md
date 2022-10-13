# Cours

## Set

Un `Set` est une collection d'éléments qui ne contient pas de doublons. Il est possible de créer un `Set` à partir d'une liste en utilisant la fonction `toSet`:

```kotlin
val set = listOf(1, 2, 3, 4, 5, 5, 5).toSet()
println(set) // [1, 2, 3, 4, 5]
```

Il est possible de créer un `Set` vide en utilisant la fonction `emptySet`:

```kotlin
val set = emptySet<Int>()
println(set) // []
```

## Pair

Un `Pair` est une structure de données qui contient deux éléments. Il est possible de créer un `Pair` en utilisant la fonction `Pair`:

```kotlin
val pair = Pair(1, "Hello")
println(pair) // (1, Hello)
```

Il est possible de créer un `Pair` en utilisant l'opérateur `to`:

```kotlin
val pair = 1 to "Hello"
println(pair) // (1, Hello)
```

Il est possible d'accéder aux éléments d'un `Pair` en utilisant les propriétés `first` et `second`:

```kotlin
val pair = 1 to "Hello"
println(pair.first) // 1
println(pair.second) // Hello
```

## Map

Une `Map` est une collection d'éléments qui associe une clé à une valeur. Il est possible de créer une `Map` à partir d'une liste en utilisant la fonction `associate`:

```kotlin
val map = listOf(1, 2, 3, 4, 5).associate { it to it * it }
println(map) // {1=1, 2=4, 3=9, 4=16, 5=25}
```

Il est possible de créer une `Map` vide en utilisant la fonction `emptyMap`:

```kotlin
val map = emptyMap<Int, Int>()
println(map) // {}
```

Une map peut être créée à partir d'une liste de paires:

```kotlin
val map = listOf(1 to 1, 2 to 4, 3 to 9, 4 to 16, 5 to 25).toMap()
println(map) // {1=1, 2=4, 3=9, 4=16, 5=25}
```

Il est possible d'accéder aux valeurs d'une `Map` en utilisant l'opérateur `[]`:

```kotlin
val map = listOf(1 to 1, 2 to 4, 3 to 9, 4 to 16, 5 to 25).toMap()
println(map[1]) // 1
println(map[2]) // 4
println(map[3]) // 9
println(map[4]) // 16
println(map[5]) // 25
```

## Iterator

Un `Iterator` est un objet qui permet de parcourir une collection. Il est possible de créer un `Iterator` en utilisant la fonction `iterator`:

```kotlin
val iterator = listOf(1, 2, 3, 4, 5).iterator()
println(iterator.next()) // 1
println(iterator.next()) // 2
println(iterator.next()) // 3
println(iterator.next()) // 4
println(iterator.next()) // 5
```

Il est possible de vérifier si un `Iterator` a un élément suivant en utilisant la fonction `hasNext`:

```kotlin
val iterator = listOf(1, 2, 3, 4, 5).iterator()
println(iterator.hasNext()) // true
println(iterator.next()) // 1
println(iterator.hasNext()) // true
println(iterator.next()) // 2
println(iterator.hasNext()) // true
println(iterator.next()) // 3
println(iterator.hasNext()) // true
println(iterator.next()) // 4
println(iterator.hasNext()) // true
println(iterator.next()) // 5
println(iterator.hasNext()) // false
```

Il est possible de parcourir un `Iterator` en utilisant une boucle `while`:

```kotlin
val iterator = listOf(1, 2, 3, 4, 5).iterator()
while (iterator.hasNext()) {
    println(iterator.next())
}
```

Il est possible de parcourir un `Iterator` en utilisant une boucle `for`:

```kotlin
val iterator = listOf(1, 2, 3, 4, 5).iterator()
for (element in iterator) {
    println(element)
}
```

Il est possible de parcourir un `Iterator` en utilisant une boucle `for` et la fonction `withIndex`:

```kotlin
val iterator = listOf(1, 2, 3, 4, 5).iterator()
for ((index, element) in iterator.withIndex()) {
    println("$index: $element")
}
```

## Sequence

Une `Sequence` est une collection d'éléments qui ne sont pas forcément stockés en mémoire. Il est possible de créer une `Sequence` en utilisant la fonction `sequence`:

```kotlin
val sequence = sequence {
    yield(1)
    yield(2)
    yield(3)
    yield(4)
    yield(5)
}
println(sequence) // Sequence(...)
```

Il est possible de créer une `Sequence` vide en utilisant la fonction `emptySequence`:

```kotlin
val sequence = emptySequence<Int>()
println(sequence) // Sequence(...)
```

Il est possible de créer une `Sequence` à partir d'une liste en utilisant la fonction `asSequence`:

```kotlin
val sequence = listOf(1, 2, 3, 4, 5).asSequence()
println(sequence) // Sequence(...)
```

Il est possible de créer une `Sequence` à partir d'une liste en utilisant la fonction `asSequence` et la fonction `filter`:

```kotlin
val sequence = listOf(1, 2, 3, 4, 5).asSequence().filter { it % 2 == 0 }
println(sequence) // Sequence(...)
```

L'utilisation d'une `Sequence` permet de réduire la consommation mémoire:

```kotlin
val list = listOf(1, 2, 3, 4, 5)
val sequence = list.asSequence().filter { it % 2 == 0 }
println(list) // [1, 2, 3, 4, 5]
println(sequence) // Sequence(...)
```

Il est possible de parcourir une `Sequence` en utilisant une boucle `for`:

```kotlin
val sequence = listOf(1, 2, 3, 4, 5).asSequence()
for (element in sequence) {
    println(element)
}
```

Il est possible de parcourir une `Sequence` en utilisant une boucle `for` et la fonction `withIndex`:

```kotlin
val sequence = listOf(1, 2, 3, 4, 5).asSequence()
for ((index, element) in sequence.withIndex()) {
    println("$index: $element")
}
```

Le grand interêt des `Sequence` est qu'elles permettent de créer des pipelines de traitement:

Par exemple pour créer une `Sequence` qui contient les carrés des nombres pairs d'une liste:

```kotlin
val sequence = listOf(1, 2, 3, 4, 5).asSequence().filter { it % 2 == 0 }.map { it * it }
println(sequence) // Sequence(...)
```

# Exercice 

Utilisez la collection map pour mapper le nom d'un pays avec son drapeau.

Créez ensuite des fonctions pour 
1. afficher le drapeau d'un pays
2. afficher le drapeau d'un pays en fonction de son nom
3. afficher tous les drapeaux

