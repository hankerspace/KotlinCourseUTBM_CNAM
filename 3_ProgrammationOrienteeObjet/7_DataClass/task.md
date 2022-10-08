# Cours

## Data class

Une data class est une classe qui contient uniquement des données. Elle est déclarée avec le mot-clé `data` :

```kotlin
data class User(val name: String, val age: Int)
```

Une data class est un type spécial de classe. Elle est immuable, c'est-à-dire qu'on ne peut pas la modifier après l'avoir créée. Elle contient des méthodes utiles pour comparer des instances, et pour les afficher.

Elle crée donc automatiquement des méthodes pour :

- Comparer deux instances de la classe avec `==` et `!=` (méthode `equals`)
- Comparer deux instances de la classe avec `>`, `<`, `>=` et `<=` (méthode `compareTo`)
- Afficher une instance de la classe (méthode `toString`)
- Copier une instance de la classe (méthode `copy`)
- Hasher une instance de la classe (méthode `hashCode`)
- Récupérer les valeurs des propriétés d'une instance de la classe (méthode `componentN`)
- Etc

Si vous le souhaitez, vous pouvez toujours surcharger ces méthodes.

Par exemple, on peut créer une instance de `User` :

```kotlin
val user = User("John", 42)
```

On peut ensuite accéder aux propriétés de l'instance :

```kotlin
user.name // "John"
user.age // 42
```

On peut aussi comparer deux instances de `User` :

```kotlin
val user1 = User("John", 42)
val user2 = User("John", 42)
user1 == user2 // true
```

Enfin, on peut afficher une instance de `User` :

```kotlin
val user = User("John", 42)
println(user) // User(name=John, age=42)
```

## Restrictions

Une data class doit respecter certaines règles :

- Elle doit avoir au moins une propriété
- Toutes ses propriétés doivent être `val` (pas de `var`)
- Elle ne peut pas être `abstract`, `open`, `sealed` ou `inner`
- Elle ne peut pas hériter d'une autre classe (mais elle peut implémenter des interfaces)
- Elle ne peut pas avoir de constructeur secondaire
- Elle ne peut pas avoir de bloc d'initialisation
- Etc

# Exercice

Prenez le temps de comprendre le fonctionnement du code main afin de créez les classes demandées.



