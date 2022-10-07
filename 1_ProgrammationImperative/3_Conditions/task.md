# Cours

Dans ce chapitre, nous allons apprendre à utiliser les conditions en Kotlin.

### if

La condition `if` est la plus simple. Elle prend une expression booléenne et exécute le bloc d'instructions si l'expression est vraie.

```kotlin
fun main(args: Array<String>) {
    val a = 2
    val b = 3
    if (a > b) {
        println("a > b")
    } else {
        println("a <= b")
    }
}
```

### when

La condition `when` est une alternative à la condition `if`. Elle prend une expression et compare sa valeur à chaque branche. Si la valeur correspond à une branche, le bloc d'instructions correspondant est exécuté. Si aucune branche ne correspond, le bloc d'instructions de la branche `else` est exécuté.

```kotlin
fun main(args: Array<String>) {
    val x = 1
    when (x) {
        1 -> println("x == 1")
        2 -> println("x == 2")
        else -> {
            println("x is neither 1 nor 2")
        }
    }
}
```

## Opérateurs

### Opérateurs de comparaison

Les opérateurs de comparaison sont les mêmes que ceux que vous avez déjà utilisés en Java.

| Opérateur | Signification     |
|-----------|-------------------|
| ==        | égal              |
| !=        | différent         |
| \>        | supérieur         |
| <         | inférieur         |
| \>=       | supérieur ou égal |
| <=        | inférieur ou égal |

### Opérateurs logiques

Les opérateurs logiques sont les mêmes que ceux que vous avez déjà utilisés en Java.

- L'opérateur `&&` est l'opérateur logique ET. Il retourne `true` si les deux expressions sont vraies.
- L'opérateur `||` est l'opérateur logique OU. Il retourne `true` si au moins une des deux expressions est vraie.
- L'opérateur `!` est l'opérateur logique NON. Il retourne `true` si l'expression est fausse.

### Opérateur ternaire

En Kotlin, il n'y a pas d'opérateur ternaire. Vous pouvez utiliser une expression conditionnelle à la place.

```kotlin
val a = 1
val b = 2
val max = if (a > b) a else b
```


# Exercice

Complétez les fonctions pour qu'elles retournent les valeurs attendues.

<div class="hint">
  La taille d'une String est accessible avec la propriété <code>length</code>.
</div>

<div class="hint">
  Pour la fonction <code>multipleCases</code>, vous pouvez utiliser <code>when</code>.
</div>