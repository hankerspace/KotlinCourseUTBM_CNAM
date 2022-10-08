# Cours

## Enumérations

### Définition 

Les énumérations sont des types de données qui permettent de définir un ensemble de valeurs possibles. Elles sont définies avec le mot clé `enum` et sont définies comme des classes.

```kotlin
enum class Color {
    RED, GREEN, BLUE
}
```

Les énumérations peuvent avoir des propriétés et des méthodes.

```kotlin
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF);

    fun containsRed() = (rgb and 0xFF0000 != 0)
}
```

Les énumérations peuvent avoir des constructeurs et des méthodes. Les constructeurs sont appelés pour chaque valeur de l'énumération. Les méthodes sont appelées avec la notation `EnumClass.method()`.

```kotlin
enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}
```

### Usage

Comme les classes, les énumérations peuvent être utilisées comme type de retour, de paramètre et comme type de variable.

```kotlin
fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard"
        Color.GREEN -> "George"
        Color.BLUE -> "Barton"
    }

fun getWarmth(color: Color) = when (color) {
    Color.RED, Color.BLUE -> "warm"
    Color.GREEN -> "neutral"
}
```

*Par convention les énumérations sont définies en majuscules.*

# Exercice

<div class="hint">
Le nom d'une enum peut être récupéré avec l'attribut `name`.

Exemple :
    
```kotlin
enum class Color {
    RED, GREEN, BLUE
}

println(Color.RED.name) // RED
```
</div>

