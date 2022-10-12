Le but de cet exercice est d'ajouter des opérateurs à la classe String pour pouvoir faire des opérations sur les chaînes de caractères.

Voici les différents opérateurs à implémenter et leur fonction :

- `+` : concatène deux chaînes de caractères
- `*` : répète une chaîne de caractères un certain nombre de fois
- `-` : retire une sous-chaîne de caractères d'une chaîne de caractères
- `/` : concatène une chaîne de caractères au début

Pour chaque opérateur, il faut implémenter une fonction qui prend en paramètre la chaîne de caractères sur laquelle on veut faire l'opération et un autre paramètre qui dépend de l'opérateur.

Par exemple, pour l'opérateur `+`, on doit pouvoir faire :

```kotlin
"Hello" + "World" // "HelloWorld"
```

Pour l'opérateur `*`, on doit pouvoir faire :

```kotlin
"Hello" * 3 // "HelloHelloHello"
```

Pour l'opérateur `-`, on doit pouvoir faire :

```kotlin
"HelloWorld" - "World" // "Hello"
```

Pour l'opérateur `/`, on doit pouvoir faire :

```kotlin
"World" / "Hello" // "HelloWorld"
```

Les opérateurs doivent pouvoir être combinés entre eux. Par exemple, on doit pouvoir faire :

```kotlin
"Hello" + "World" * 3 / "World" // "WorldHelloWorldWorldWorld"
```
