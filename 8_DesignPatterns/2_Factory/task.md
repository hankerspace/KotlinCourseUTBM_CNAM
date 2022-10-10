# Cours

## Fabrique (Factory)

La fabrique est un patron de conception qui permet de créer des objets sans avoir à spécifier la classe concrète de l'objet à créer. Cela permet de déléguer la création d'objets à une classe spécialisée, la fabrique.

### Exemple

```kotlin
interface Shape {
    fun draw()
}

class Circle : Shape {
    override fun draw() {
        println("Circle::draw()")
    }
}

class Rectangle : Shape {
    override fun draw() {
        println("Rectangle::draw()")
    }
}

class Square : Shape {
    override fun draw() {
        println("Square::draw()")
    }
}

class ShapeFactory {
    fun getShape(shapeType: String): Shape? {
        return when (shapeType) {
            "CIRCLE" -> Circle()
            "RECTANGLE" -> Rectangle()
            "SQUARE" -> Square()
            else -> null
        }
    }
}

fun main() {
    val shapeFactory = ShapeFactory()

    val circle = shapeFactory.getShape("CIRCLE")
    circle?.draw()

    val rectangle = shapeFactory.getShape("RECTANGLE")
    rectangle?.draw()

    val square = shapeFactory.getShape("SQUARE")
    square?.draw()
}
```

Une enumération peut être utilisée pour définir les types d'objets à créer.

```kotlin
enum class ShapeType {
    CIRCLE, RECTANGLE, SQUARE
}

class ShapeFactory {
    fun getShape(shapeType: ShapeType): Shape? {
        return when (shapeType) {
            ShapeType.CIRCLE -> Circle()
            ShapeType.RECTANGLE -> Rectangle()
            ShapeType.SQUARE -> Square()
        }
    }
}

fun main() {
    val shapeFactory = ShapeFactory()

    val circle = shapeFactory.getShape(ShapeType.CIRCLE)
    circle?.draw()

    val rectangle = shapeFactory.getShape(ShapeType.RECTANGLE)
    rectangle?.draw()

    val square = shapeFactory.getShape(ShapeType.SQUARE)
    square?.draw()
}
```

# Exercice

Nous allons nous servir de la fabrique pour créer un parser de fichier correspondant au type de fichier à parser.

## Parser

Créer une interface `Parser` qui contient une méthode `parse` qui retourne un `String`.

Créer une classe `JsonParser` qui implémente l'interface `Parser` et qui retourne le texte `Parsing JSON` dans la méthode `parse`.

Créer une classe `XmlParser` qui implémente l'interface `Parser` et qui retourne le texte `Parsing XML` dans la méthode `parse`.

Créer une classe `ParserFactory` qui contient une méthode `getParser` qui prend en paramètre un `String` qui correspond au fichier à parser et qui retourne un `Parser` correspondant au type de fichier à parser.

<div class="hint">
Utilisez l'extension du nom du fichier pour savoir quel parser utiliser.

Par exemple, si le nom du fichier est `file.json`, utilisez le parser `JsonParser`.

Si le nom du fichier est `file.xml`, utilisez le parser `XmlParser`.

Si le nom du fichier est `file.txt`, retournez une `Exception`.
</div>

## Pour aller plus loin

Utilisez une fonction d'extension de String pour créer le parser correspondant.

```kotlin
// Usage
"file.json".getParser()
```




