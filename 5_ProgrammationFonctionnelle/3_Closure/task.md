# Cours

## Closures
 
La documentation Kotlin définit les closures comme ceci : “A closure is a special kind of object that combines two things: a function, and the environment in which that function was created. The environment consists of any local variables that were in-scope at the time the closure was created”

En français, une closure est un objet qui combine deux choses : une fonction et l’environnement dans lequel cette fonction a été créée. L’environnement est constitué des variables locales qui étaient en portée au moment de la création de la closure.

Ainsi, les closures sont capables de capturer des variables locales et de les utiliser dans leur fonction. C’est ce qui permet de créer des fonctions anonymes.

### Exemples

```kotlin

fun main (args: Array<String>) {
  var sum=0
  val listOfInteger= arrayOf (0, 1, 2, 3, 4, 5, 6, 7)
  listOfInteger.forEach {
    sum+=it
    println (sum)
  }
}

```

Dans cet exemple, la closure est la fonction anonyme passée en paramètre à la méthode forEach. Cette fonction anonyme utilise la variable sum qui est définie dans le scope de la fonction main. La closure est donc capable de capturer la variable sum et de l’utiliser dans sa fonction.

```kotlin

var containsNegative = false
val ints = listOf(0, 1, 2, 3, 4, 5)
ints.forEach {
  if (it < 0)
  containsNegative = true
}
println(containsNegative)

```

Dans cet exemple, la closure est la fonction anonyme passée en paramètre à la méthode forEach. Cette fonction anonyme utilise la variable containsNegative qui est définie dans le scope de la fonction main. La closure est donc capable de capturer la variable containsNegative et de l’utiliser dans sa fonction.

# Exercices

Exécutez le code et observez le résultat.

D'après vous, quel aurait été le résultat avec :

```kotlin
println(counter())
println(counter())
println(counter())
println(counter())
println(counter())
```

