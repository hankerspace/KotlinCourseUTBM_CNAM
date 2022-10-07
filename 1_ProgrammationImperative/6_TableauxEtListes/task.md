# Cours

Au cours des précédents chapitres, vous avez dû travailler avec des tableaux et des listes.
Ce Chapitre fait un point précis sur ces notions et explore les différents usages possibles.

## Tableaux

### Déclaration

Un tableau est une variable qui contient plusieurs valeurs.
Pour déclarer un tableau, on utilise la syntaxe suivante :

```kotlin
val tableau = arrayOf(1, 2, 3, 4, 5)
```

On peut aussi déclarer un tableau vide :

```kotlin
val tableauVide = arrayOf<Int>()
```

### Accès aux éléments

Pour accéder à un élément du tableau, on utilise la syntaxe suivante :

```kotlin
val tableau = arrayOf(1, 2, 3, 4, 5)
val premierElement = tableau[0]
val dernierElement = tableau[tableau.size - 1]
```

### Parcours

Pour parcourir un tableau, on utilise la syntaxe suivante :

```kotlin
val tableau = arrayOf(1, 2, 3, 4, 5)
for (element in tableau) {
    println(element)
}
```

### Modification

Pour modifier un élément du tableau, on utilise la syntaxe suivante :

```kotlin
val tableau = arrayOf(1, 2, 3, 4, 5)
tableau[0] = 10
```

### Ajout

Pour ajouter un élément à la fin du tableau, on utilise la syntaxe suivante :

```kotlin
val tableau = arrayOf(1, 2, 3, 4, 5)
tableau += 6
```

### Suppression

Pour supprimer un élément du tableau, on utilise la syntaxe suivante :

```kotlin
val tableau = arrayOf(1, 2, 3, 4, 5)
tableau -= 3
```

## Listes

### Déclaration

Une liste est une variable qui contient plusieurs valeurs.
Pour déclarer une liste, on utilise la syntaxe suivante :

```kotlin
val liste = listOf(1, 2, 3, 4, 5)
```

On peut aussi déclarer une liste vide :

```kotlin
val listeVide = listOf<Int>()
```

### Accès aux éléments

Pour accéder à un élément de la liste, on utilise la syntaxe suivante :

```kotlin
val liste = listOf(1, 2, 3, 4, 5)
val premierElement = liste[0]
val dernierElement = liste[liste.size - 1]
```

### Parcours

Pour parcourir une liste, on utilise la syntaxe suivante :

```kotlin
val liste = listOf(1, 2, 3, 4, 5)
for (element in liste) {
    println(element)
}
```

### Modification

Une liste est immuable, c'est-à-dire qu'elle ne peut pas être modifiée. Pour modifier une liste, il faut travailler avec un type spécifique : MutableList.

Une MutableList est une liste qui peut être modifiée. Il faut donc bien juger si une liste sera modifiée ou non et choisir le type de liste en conséquence.

Une mutable list contient les méthodes suivantes :
<ul>
<li><code>add(element)</code> : ajoute un élément à la fin de la liste</li>
<li><code>remove(element)</code> : supprime un élément de la liste</li>
<li><code>removeAt(index)</code> : supprime un élément à l'index donné</li>
<li><code>clear()</code> : supprime tous les éléments de la liste</li>
</ul>

Pour déclarer une mutable list et modifier un élément, on utilise la syntaxe suivante :

```kotlin
val liste = mutableListOf(1, 2, 3, 4, 5)
liste[0] = 10
```

### Ajout

Pour ajouter un élément à la fin de la liste, on utilise la syntaxe suivante :

```kotlin
val liste = mutableListOf(1, 2, 3, 4, 5)
liste.add(6)
```

### Suppression

Pour supprimer un élément de la liste, on utilise la syntaxe suivante :

```kotlin
val liste = mutableListOf(1, 2, 3, 4, 5)
liste.remove(3)
```

## Différence liste et tableaux

Les listes et les tableaux sont des types de données qui permettent de stocker plusieurs valeurs.

La principale différence entre les deux est que les listes sont immuables, c'est-à-dire qu'elles ne peuvent pas être modifiées. Les tableaux sont mutables, c'est-à-dire qu'ils peuvent être modifiés.

Lors de l'utilisation de mutablesList, Kotlin se charge de créer une nouvelle liste à chaque modification. Cela peut avoir un impact sur les performances.

Du point de vue d'un programmeur, une liste mutable est facile à utiliser, mais les performances sont moindres que pour un tableau.

Toutefois, les listes sont des types de données possédant de nombreuses méthodes qui permettent de les manipuler facilement.

## Dimensions

Un tableau ou une liste peut avoir plusieurs dimensions. Par exemple, un tableau à deux dimensions est un tableau de tableaux.

```kotlin
val tableau = arrayOf(
    arrayOf(1, 2, 3),
    arrayOf(4, 5, 6),
    arrayOf(7, 8, 9)
)
```

Pour accéder à un élément du tableau, on utilise la syntaxe suivante :

```kotlin
val tableau = arrayOf(
    arrayOf(1, 2, 3),
    arrayOf(4, 5, 6),
    arrayOf(7, 8, 9)
)
val premierElement = tableau[0][0]
val dernierElement = tableau[tableau.size - 1][tableau[tableau.size - 1].size - 1]
```

# Exercices

Réalisez les exercices suivants en utilisant les notions vues dans ce chapitre.

<div class="hint">
    Pour tester si un élément est pair, on peut utiliser le modulo : <code>element % 2 == 0</code>
    Pour tester si un élément est multiple de 3, on peut utiliser le modulo : <code>element % 3 == 0</code>
    Et ainsi de suite...
</div>

<div class="hint">
    Si vous ne pouvez pas appeler les méthodes add, remove, removeAt et clear, vérifiez que vous avez bien déclaré une mutable list et non une list.
</div>