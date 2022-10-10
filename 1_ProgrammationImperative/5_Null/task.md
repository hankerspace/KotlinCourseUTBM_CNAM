# Cours

## Le type null en Kotlin

En Kotlin, une variable peut être déclarée comme pouvant contenir une valeur nulle. Pour cela, il suffit de déclarer la variable avec le type `?` à la fin du type de la variable.

```kotlin 
var name: String? = null
```

## Test de nullité

Pour tester si une variable est nulle, on utilise l'opérateur `===` ou `!==` avec `null` comme valeur de comparaison. La comparaison `==` et `!=` est aussi possible mais est moins performante.

<div class="hint">
Le test `a == b` est équivalent à `a?.equals(b) ?: (b === null)`
</div>

```kotlin
var name: String? = null
if (name === null) {
    println("name is null")
} else {
    println("name is not null")
}
```

## Accès à une variable nullable

### Opérateur safe call `?.`
Pour accéder à une variable qui peut contenir une valeur nulle, il faut utiliser l'opérateur `?` pour vérifier que la variable n'est pas nulle.

```kotlin
val name: String? = null
println(name?.length)
```

Si la variable est nulle, le résultat de l'expression sera nul. Si la variable n'est pas nulle, le résultat de l'expression sera la valeur de la variable.

### Opérateur unsafe call `!!`

Il est possible d'accéder à la valeur de la variable sans vérifier si elle est nulle en utilisant l'opérateur `!!`. Si la variable est nulle, une exception sera levée.

```kotlin
val name: String? = null
println(name!!.length)
```

## Opérateur Elvis

Il est possible de définir une valeur par défaut pour une variable qui peut contenir une valeur nulle en utilisant l'opérateur `?:`.

```kotlin
val name: String? = null
println(name?.length ?: 0)
```

Si la variable est nulle, le résultat de l'expression sera la valeur de droite de l'opérateur `?:`. Si la variable n'est pas nulle, le résultat de l'expression sera la valeur de la variable.

# Exercices

Complétez les exercices suivant pour vous entraîner à utiliser les variables nullable.