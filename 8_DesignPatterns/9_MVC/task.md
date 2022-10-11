# Cours

## Modèle MVC (Model View Controller)

### Modèle

Le modèle est la partie qui contient les données de l'application. Il est responsable de la gestion des données et de la logique métier. Il est indépendant de la vue et du contrôleur.

### Vue

La vue est la partie qui contient l'interface utilisateur. Elle est responsable de l'affichage des données et de la communication avec l'utilisateur. Elle est indépendante du modèle et du contrôleur.

### Contrôleur

Le contrôleur est la partie qui contient la logique de l'application. Il est responsable de la gestion des événements et de la communication entre le modèle et la vue. Il est indépendant du modèle et de la vue.

### Exemple

```kotlin
class Model {
    var value = 0
}

class View {
    fun display(value: Int) {
        println("Value: $value")
    }
}

class Controller {
    private val model = Model()
    private val view = View()

    fun increment() {
        model.value++
        view.display(model.value)
    }
}

fun main() {
    val controller = Controller()
    controller.increment()
    controller.increment()
    controller.increment()
}
```

### Différence entre MVC et MVP

Le modèle MVP est très similaire au modèle MVC. La différence principale est que le contrôleur est remplacé par un présentateur. Le présentateur est responsable de la communication entre le modèle et la vue. Le présentateur est indépendant du modèle et de la vue.

# Exercice

Créez une application de calculatrice qui utilise le modèle MVC.

## Modèle

Le modèle doit contenir les données de la calculatrice.

## Vue

La vue doit contenir l'interface utilisateur. Elle doit afficher le résultat du calcul.

## Contrôleur

Le contrôleur doit contenir la logique de l'application. Il doit posséder les fonctions pour ajouter, soustraire, multiplier et diviser deux nombres.


