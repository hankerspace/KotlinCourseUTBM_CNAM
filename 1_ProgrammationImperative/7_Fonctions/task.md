# Cours

Nous avons vus dans le [cours 2_AppelDeFonction](course://1_ProgrammationImperative/2_AppelDeFonction/task.md) que les fonctions sont des blocs de code qui peuvent être appelés à plusieurs endroits dans un programme. Elles peuvent prendre des paramètres et retourner des valeurs.

Pour rappel, il existe des fonctions simples, des fonctions inline, des lambdas expressions et des fonctions anonymes.

Les avantage d'une fonction sont:

*   Elle permet de réutiliser du code
*  Elle permet de découper un programme en plusieurs parties
* Elle permet de rendre le code plus lisible
* Elle permet de rendre le code plus maintenable
* Elle permet de rendre le code plus testable
* Elle permet de rendre le code plus facile à débugger

Le principe de décomposer son code en fonctions est appelé la **factorisation**, c'est un des principes de la [programmation modulaire](https://fr.wikipedia.org/wiki/Programmation_modulaire). Nous utiliserons ce principe dans les prochains cours.

## Récursivité

La récursivité est une technique qui permet d'appeler une fonction à l'intérieur de la fonction elle-même. C'est une technique très puissante qui permet de résoudre certains problèmes de manière très simple.

La récursivité est utilisée dans les algorithmes de tri, de recherche, de parcours d'arbre, etc.

La construction d'une fonctione récurive se fait en 2 étapes:

1.  Trouver la condition d'arrêt
2. Trouver la condition de récursion

Si la condition d'arrêt n'est pas présente, la fonction va s'appeler à l'infini et provoquer un **StackOverflowError**.

Si la condition de récursion n'est pas présente, la fonction ne fera qu'une seule itération et ne fera rien de particulier.

### Exemple

Voici un exemple de fonction récursive qui calcule la factorielle d'un nombre:

```kotlin
fun factorial(n: Int): Int {
    if (n == 0) {
        return 1
    }
    return n * factorial(n - 1)
}
```

La fonction `factorial` prend en paramètre un nombre `n` et retourne la factorielle de ce nombre.

La fonction `factorial` appelle elle-même la fonction `factorial` à l'intérieur de son corps.

La fonction `factorial` appelle la fonction `factorial` avec un paramètre `n` qui est égal à `n - 1`.

La fonction `factorial` s'arrête quand le paramètre `n` est égal à `0`.

## Documentation

La documentation d'une fonction est très importante. Elle permet de comprendre ce que fait la fonction et comment l'utiliser.

La documentation d'une fonction se fait avec un commentaire au dessus de la fonction. Ce commentaire est appelé un **docstring** (parfois appelé **javadoc**).

Le docstring d'une fonction est composé de 3 parties:

*   Une description de la fonction
*  Les paramètres de la fonction
* Le retour de la fonction

Contrairement à un commentaire classique, le docstring est utilisé par les outils de documentation pour générer la documentation de la fonction. Il commence par /** et se termine par */. Chaque ligne du docstring commence par un *.
### Exemple

Voici un exemple de docstring:

```kotlin
/**
 * Retourne la factorielle d'un nombre
 *
 * @param n Le nombre dont on veut calculer la factorielle
 * @return La factorielle du nombre
 */
fun factorial(n: Int): Int {
    if (n == 0) {
        return 1
    }
    return n * factorial(n - 1)
}
```

# Exercices

Les exercices suivants permettent de mettre en pratique les notions vues dans ce cours.