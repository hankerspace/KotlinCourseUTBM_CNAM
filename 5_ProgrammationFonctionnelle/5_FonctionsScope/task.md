# Cours

## Scope functions (let, run, with, apply, also)

### Let

La fonction `let` permet d'exécuter un bloc de code sur un objet. Elle retourne le résultat de ce bloc de code.

```kotlin
val a = "Hello"
val b = a.let {
    println(it)
    it + " World"
}

println(b)
```

### Run

La fonction `run` permet d'exécuter un bloc de code sur un objet. Elle retourne le résultat de ce bloc de code.

```kotlin
val a = "Hello"
val b = a.run {
    println(this)
    this + " World"
}

println(b)
```

La différence entre `let` et `run` est que `run` est une extension de `Any?` et `let` est une extension de `T?` (T est un type quelconque).

Ainsi, dans le cas où `a` est `null`, `let` ne sera pas exécuté, alors que `run` le sera.

### With

La fonction `with` permet d'exécuter un bloc de code sur un objet. Elle retourne le résultat de ce bloc de code.

```kotlin
val a = "Hello"
val b = with(a) {
    println(this)
    this + " World"
}

println(b)
```

La différence entre `let` et `with` est que `with` est une fonction et non une extension.

### Apply

La fonction `apply` permet d'exécuter un bloc de code sur un objet. Elle retourne l'objet sur lequel le bloc de code a été exécuté.

```kotlin
val a = "Hello"
val b = a.apply {
    println(this)
    this + " World"
}

println(b)
```

### Also

La fonction `also` permet d'exécuter un bloc de code sur un objet. Elle retourne l'objet sur lequel le bloc de code a été exécuté.

```kotlin
val a = "Hello"
val b = a.also {
    println(it)
    it + " World"
}

println(b)
```

La différence entre `also` et `apply` est que `also` retourne l'objet sur lequel le bloc de code a été exécuté, alors que `apply` retourne le résultat du bloc de code.
