abstract class Troll {
    open val attackPower: Int = 10
    open val armor: Int = 0
    open val speed: Int = 5

    fun attack() {
        println("The Troll attacks for $attackPower damage")
    }

    fun defense() {
        println("The Troll defends with $armor armor")
    }

    fun move() {
        println("The Troll moves $speed spaces")
    }
}

// Créez ici les différentes classes de Troll demandées

class SimpleTroll : Troll()

class ClubbedTroll(troll: Troll) : Troll() {
    override val attackPower: Int = troll.attackPower + 10
    override val armor: Int = troll.armor
    override val speed: Int = troll.speed - 1
}

class ArmoredTroll(troll: Troll) : Troll() {
    override val attackPower: Int = troll.attackPower
    override val armor: Int = troll.armor + 5
    override val speed: Int = troll.speed - 2
}

class BootedTroll(troll: Troll) : Troll() {
    override val attackPower: Int = troll.attackPower
    override val armor: Int = troll.armor
    override val speed: Int = troll.speed + 5
}

fun main(args: Array<String>) {
    // Exemple de test

    // Création d'un troll simple
    var troll: Troll = SimpleTroll()
    troll.attack()
    troll.defense()
    troll.move()

    // Ajout d'un club au troll
    troll = ClubbedTroll(troll)
    troll.attack()
    troll.defense()
    troll.move()

    // Ajout d'une armure au troll
    troll = ArmoredTroll(troll)
    troll.attack()
    troll.defense()
    troll.move()

    // Ajout de bottes au troll
    troll = BootedTroll(troll)
    troll.attack()
    troll.defense()
    troll.move()
}


