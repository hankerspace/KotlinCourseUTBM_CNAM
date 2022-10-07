interface Movable {
    fun move()
}

interface Shoutable {
    fun shout()
}

abstract class Animal {
    abstract val name: String
}

// Créez la classe Cat qui hérite de Animal et implémente les interfaces Movable et Shoutable
class Cat(override val name: String) : Animal(), Movable, Shoutable {
    override fun move() {
        println("$name is moving")
    }

    override fun shout() {
        println("Meow")
    }
}

// Créez la classe Dog qui hérite de Animal et implémente les interfaces Movable et Shoutable
class Dog(override val name: String) : Animal(), Movable, Shoutable {
    override fun move() {
        println("$name is moving")
    }

    override fun shout() {
        println("Woof")
    }
}

// Créez la classe Snake qui hérite de Animal et implémente l'interface Shoutable
class Fish(override val name: String) : Animal(), Movable {
    override fun move() {
        println("$name is swimming")
    }
}


// Créez la classe Zoo qui contient une liste d'animaux et implémente l'interface Movable et Shoutable
// La méthode move() doit faire bouger tous les animaux du zoo, et la méthode shout() doit faire crier tous les animaux du zoo
class Zoo(val animals: List<Animal>) : Movable, Shoutable {
    override fun move() {
        for(animal in animals) {
            if(animal is Movable) {
                animal.move()
            }
        }
    }

    override fun shout() {
        for(animal in animals) {
            if(animal is Shoutable) {
                animal.shout()
            }
        }
    }
}

fun main(args: Array<String>) {
    // Test du zoo
    val zoo = Zoo(listOf(
        Cat("Tom"),
        Dog("Spike"),
        Fish("Nemo"),
    ))
    zoo.move()
    zoo.shout()
}




