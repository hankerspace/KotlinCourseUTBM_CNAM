# Cours

## Boucles

En Kotlin, il existe deux types de boucles : les boucles `for` (pour) et les boucles `while` (tant que).

### Boucles `for`

Les boucles `for` sont utilisées pour parcourir des collections. Elles sont très similaires aux boucles `for` en Java. On peut nommer cette utilisation un "for each" (pour chaque).

```kotlin
val list = listOf("a", "b", "c")
for (s in list) {
    println(s)
}
```

La boucle `for` peut également être utilisée pour parcourir des intervalles de nombres. Par exemple, pour afficher les nombres de 1 à 5 :

```kotlin
for (i in 1..5) {
    println(i)
}
```

### Boucles `while`

Les boucles `while` sont utilisées pour répéter une action tant qu'une condition est vraie.

```kotlin
var x = 5
while (x > 0) {
    println(x)
    x--
}
```

### Boucles `do-while`

Les boucles `do-while` sont une variante de la boucle `while`. Elles sont utilisées pour répéter une action tant qu'une condition est vraie. La différence avec les boucles `while` est que la condition
est testée à la fin de la boucle.

```kotlin
var x = 5
do {
    println(x)
    x--
} while (x > 0)
```

# Exercice

Utilisez les boucles précédentes pour compléter les exercices suivants.

Pour rappel, des notions sur les variables ont été données au [cours 1_Bonjour](course://1_ProgrammationImperative/1_Bonjour/task.md)

<div class="hint">
  Une variable peut être utilisée pour stocker le résultat de la boucle. La variable doit alors être déclarée avant la boucle.
</div>

<div class="hint">
    L'opérateur <code>+=</code> permet d'ajouter une valeur à une variable.
</div>

<div class="hint">
    L'exercice sur la jolie table de multiplication ne requiert pas un nombre précis d'espaces au sein des colonnes, mais vous pouvez essayer de respecter cette règle supplémentaire si vous le souhaitez.
</div>



<div class="hint">
    L'opérateur <code>in</code> permet de tester si une valeur est comprise dans un intervalle. 
Par exemple, <code>5 in 1..10</code> renvoie <code>true</code>. 
Cela peut être utile pour vérifier si un nombre est compris dans un intervalle.
Cet opérateur fonctionne aussi avec les chaînes de caractères.
Par exemple, <code>"a" in "a".."z"</code> renvoie <code>true</code>.
</div>


