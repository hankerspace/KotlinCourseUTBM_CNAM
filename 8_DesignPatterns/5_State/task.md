# Cours

# Etat (State)

Le design pattern Etat (State) permet de changer le comportement d'un objet en fonction de son état interne. C'est un patron de conception comportemental.

## Exemple

Nous allons créer un objet `LightSwitch` qui peut être dans deux états : `on` et `off`. Nous allons créer une interface `State` qui va définir les méthodes `turnOn()` et `turnOff()` qui seront implémentées par les classes `OnState` et `OffState`. Nous allons créer une classe `LightSwitch` qui va avoir une propriété `state` qui sera de type `State`. Nous allons créer une méthode `setState()` qui va permettre de changer l'état de l'objet `LightSwitch`. Nous allons créer une méthode `turnOn()` qui va appeler la méthode `turnOn()` de l'objet `state`. Nous allons créer une méthode `turnOff()` qui va appeler la méthode `turnOff()` de l'objet `state`.

```kotlin
interface State {
    fun turnOn()
    fun turnOff()
}

class OnState : State {
    override fun turnOn() {
        println("Already on")
    }

    override fun turnOff() {
        println("Turning off")
    }
}

class OffState : State {
    override fun turnOn() {
        println("Turning on")
    }

    override fun turnOff() {
        println("Already off")
    }
}

class LightSwitch {
    var state: State = OffState()

    fun setState(state: State) {
        this.state = state
    }

    fun turnOn() {
        state.turnOn()
    }

    fun turnOff() {
        state.turnOff()
    }
}

fun main() {
    val lightSwitch = LightSwitch()
    lightSwitch.turnOn()
    lightSwitch.setState(OnState())
    lightSwitch.turnOn()
    lightSwitch.turnOff()
}
```

Sortie :

```text
Turning on
Already on
Turning off
```

# Exercice

Implémentez le design pattern Etat pour un objet `TrafficLight` qui peut être dans trois états : `red`, `yellow` et `green`. 

Lorsque l'on appelle la méthode `next()` de l'objet `TrafficLight`, l'état de l'objet doit changer. Par exemple, si l'état est `red`, il doit passer à `green` et si l'état est `green`, il doit passer à `orange`. Si l'état est `orange`, il doit passer à `red`.

Utilisez une interface `State` qui va définir la méthode `next()` qui sera implémentée par les classes `RedState`, `YellowState` et `GreenState`.


