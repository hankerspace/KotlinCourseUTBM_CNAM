# Cours

## Singleton

Un singleton est un objet qui ne peut être instancié qu'une seule fois. Il est donc impossible d'en créer plusieurs. Il est souvent utilisé pour gérer des ressources partagées, comme une connexion à une base de données.

En Kotlin, on peut créer un singleton en déclarant un objet. Par exemple :

```kotlin
object Database {
    val connection = "jdbc://..."
}
```

On peut ensuite accéder à l'objet `Database` comme une variable :

```kotlin
Database.connection
```

## Companion object

Un companion object est un objet qui est associé à une classe. Il est déclaré dans la classe, et on peut y accéder en utilisant le nom de la classe :

```kotlin
class Database {
    companion object {
        val connection = "jdbc://..."
    }
}

Database.connection
```

# Exercice : Singleton

Créez un système de logger qui permet de logger des messages d'information et d'erreur. 
Le logger doit être un singleton, et doit avoir une méthode `log` qui prend en paramètre un message et un niveau de log (en provenance d'une enum). 

La méthode `log` doit afficher le message et le niveau de log dans la console.

Exemple de rendu :

```kotlin
Logger.log("Hello world", LogLevel.INFO)
// INFO: Hello world
Logger.log("Something went wrong", LogLevel.ERROR)
// ERROR: Something went wrong
```
