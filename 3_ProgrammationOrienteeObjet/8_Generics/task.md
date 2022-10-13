# Cours

## Generics

Les generics sont une fonctionnalité de Kotlin qui permet de créer des classes et des méthodes paramétrées. Cela permet de créer des classes et des méthodes qui peuvent être utilisées avec n'importe quel type de données.

Leur nom change en fonction du langage utilisé. En Java et C++, on les appelle les templates, dans la majorité des autres langages on les appelle génériques (generics).

### Déclaration

Pour déclarer une classe générique, on utilise le mot clé `class` suivi du nom de la classe, suivi de la liste des paramètres entre chevrons. On peut ensuite utiliser ces paramètres dans la classe.

```kotlin
class Box<T>(t: T) {
    var value = t
}
```

On peut aussi déclarer une classe générique avec plusieurs paramètres.

```kotlin
class Box<T, U>(t: T, u: U) {
    var value1 = t
    var value2 = u
}
```

### Utilisation

Pour utiliser une classe générique, on doit spécifier le type de données qu'on veut utiliser. 
```kotlin
val box: Box<Int> = Box(1)
```

On peut aussi utiliser plusieurs types de données.
```kotlin
val box: Box<Int, String> = Box(1, "Hello")
```

### Fonctions génériques

On peut aussi déclarer des fonctions génériques. Pour cela, on utilise le mot clé `fun` suivi du nom de la fonction, suivi de la liste des paramètres entre chevrons. On peut ensuite utiliser ces paramètres dans la fonction.

```kotlin
fun <T> boxInBox(t: T): Box<Box<T>> {
    return Box(Box(t))
}
```

On peut aussi déclarer des fonctions génériques avec plusieurs paramètres.

```kotlin
fun <T, U> boxInBox(t: T, u: U): Box<Box<T>, Box<U>> {
    return Box(Box(t), Box(u))
}
```

### Utilisation

Pour utiliser une fonction générique, on doit spécifier le type de données qu'on veut utiliser. 
```kotlin
val box: Box<Box<Int>> = boxInBox(1)
```

On peut aussi utiliser plusieurs types de données.
```kotlin
val box: Box<Box<Int>, Box<String>> = boxInBox(1, "Hello")
```

### Contraintes

On peut aussi ajouter des contraintes aux paramètres génériques. Pour cela, on utilise le mot clé `where` suivi du nom du paramètre, suivi du mot clé `:`, suivi du nom de l'interface ou de la classe que le paramètre doit implémenter ou hériter.

```kotlin
fun <T> boxInBox(t: T): Box<Box<T>> where T : Number {
    return Box(Box(t))
}
```

On peut aussi ajouter plusieurs contraintes.

```kotlin
fun <T> boxInBox(t: T): Box<Box<T>> where T : Number, T : Comparable<T> {
    return Box(Box(t))
}
```

## Exemple

Nous allons utiliser les generics pour créer une classe `MyPair` qui représente un couple de valeurs. Nous allons ensuite créer une fonction `swap` qui permet de permuter les valeurs du couple.

```kotlin
class MyPair<T, U>(val first: T, val second: U)

fun <T, U> swap(pair: MyPair<T, U>): MyPair<U, T> {
    return MyPair(pair.second, pair.first)
}
```

### Usage

```kotlin
val pair = MyPair<Int, String>(1, "Hello")
val swappedPair = swap(pair)
println(swappedPair.first) // Hello
println(swappedPair.second) // 1
```


# Exercice

Nous allons réimplémenter la LinkedList de Kotlin. 

La liste chaînée est une structure de données qui permet de stocker des données de manière linéaire. Chaque élément de la liste est relié à l'élément suivant par un lien. Le premier élément de la liste est appelé tête et le dernier élément est appelé queue.

![Liste chaînée](https://upload.wikimedia.org/wikipedia/commons/6/6d/Singly-linked-list.svg)

Nous allons utiliser les generics pour créer une liste chaînée qui peut stocker n'importe quel type de données.

1. Nous allons commencer par créer une classe `Node` qui représente un élément de la liste chaînée. Cette classe doit avoir deux propriétés : `value` qui représente la valeur de l'élément et `next` qui représente l'élément suivant.
2. Nous allons ensuite créer une classe `LinkedList` qui représente la liste chaînée. Cette classe doit avoir une propriété `head` qui représente la tête de la liste chaînée.
3. Nous allons ensuite créer une fonction `add` qui permet d'ajouter un élément à la fin de la liste chaînée.
4. Nous allons ensuite créer une fonction `remove` qui permet de supprimer un élément de la liste chaînée.
5. Nous allons ensuite créer une fonction `get` qui permet de récupérer un élément de la liste chaînée.
6. Nous allons ensuite créer une fonction `size` qui permet de récupérer la taille de la liste chaînée.
7. Nous allons ensuite créer une fonction `isEmpty` qui permet de savoir si la liste chaînée est vide.
8. Nous allons ensuite créer une fonction `contains` qui permet de savoir si la liste chaînée contient une valeur.





