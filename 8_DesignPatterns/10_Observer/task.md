# Cours

## Observeur (Observer)

Le design pattern Observer est un patron de conception comportemental qui permet de créer un mécanisme de souscription à des événements. Il permet de créer un mécanisme de notification automatique entre plusieurs objets.

Le design pattern Observer est également appelé **Listener**.

### Exemple

Nous allons créer un système de notification de changement de température. Nous allons créer une classe `TemperatureSensor` qui va nous permettre de récupérer la température actuelle. Nous allons créer une classe `TemperatureDisplay` qui va nous permettre d'afficher la température actuelle. Nous allons créer une classe `TemperatureAlert` qui va nous permettre d'afficher une alerte si la température est trop élevée.

````kotlin
interface TemperatureObserver {
    fun update(temperature: Int)
}

class TemperatureSensor {
    var temperature: Int = 0
        set(value) {
            field = value
            notifyObservers()
        }

    private val observers = mutableListOf<TemperatureObserver>()

    fun addObserver(observer: TemperatureObserver) {
        observers.add(observer)
    }

    fun removeObserver(observer: TemperatureObserver) {
        observers.remove(observer)
    }

    private fun notifyObservers() {
        observers.forEach { it.update(temperature) }
    }
}


class TemperatureDisplay : TemperatureObserver {
    override fun update(temperature: Int) {
        println("La température est de $temperature °C")
    }
}

class TemperatureAlert : TemperatureObserver {
    override fun update(temperature: Int) {
        if (temperature > 30) {
            println("Attention, la température est trop élevée !")
        }
    }
}

fun main() {
    val sensor = TemperatureSensor()
    val display = TemperatureDisplay()
    val alert = TemperatureAlert()

    sensor.addObserver(display)
    sensor.addObserver(alert)

    sensor.temperature = 20
    sensor.temperature = 40
}
````

Sortie :

````text
La température est de 20 °C
La température est de 40 °C
Attention, la température est trop élevée !
````

# Exercice 

Utilisez le design pattern Observer afin de créer un système de gestion des entrées dans un magasin. 

Vous devez créer une porte d'entrée qui va permettre de détecter les entrées et les sorties. 

Vous devez créer une classe `Display` qui va permettre d'afficher le nombre de personnes dans le magasin. Vous devez prendre en compte les entrées et les sorties.

Vous devez créer une classe `Security` qui va se charger de fouiller aléatoirement les clients qui entrent. La sécurité a une chance sur deux de fouiller un client.

Vous devez créer une classe `Cashier` qui va dire bonjour lorsque quelqu'un entre dans le magasin. Et qui va dire au revoir lorsque quelqu'un sort du magasin.

