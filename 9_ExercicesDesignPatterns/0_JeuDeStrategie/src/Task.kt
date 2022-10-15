import kotlin.math.sqrt

data class Point(val x: Int, val y: Int) {
    fun distanceTo(other: Point): Double {
        val dx = x - other.x
        val dy = y - other.y
        return sqrt((dx * dx + dy * dy).toDouble())
    }
}
enum class Faction { HUMANS, ORCS, ELFS }

interface Factoryable {
    fun buildUnit(): Unit
}
interface Moveable {
    fun move(pos: Point)
}
interface Attackable {
    fun attacked(damage: Int)
}

interface Attacker {
    fun attack(unit: Unit)
}

interface UnitLifeObserver {
    fun onUnitDied(unit: Unit)
    fun onUnitCreated(unit: Unit)
}

class OutOfRangeException : Exception("Out of range")
class OutOfManaException : Exception("Out of mana")

abstract class Unit(var pos: Point) : Attackable {
    val unitLifeObserver: UnitLifeObserver = Game
    abstract val faction: Faction
    abstract var hp: Int

    override fun attacked(damage: Int) {
        hp -= damage
        if(hp <= 0) {
            die()
        }
    }

    fun die() {
        unitLifeObserver.onUnitDied(this)
    }
}

abstract class Building(pos: Point) : Unit(pos), Factoryable {
    protected abstract fun createUnit(): Unit
    override fun buildUnit() : Unit {
        val unit = createUnit()
        unitLifeObserver.onUnitCreated(unit)
        return unit
    }
}
abstract class Character(pos: Point) : Unit(pos), Moveable, Attacker {
    abstract val damage: Int
    abstract val range: Int
    override fun move(pos: Point) {
        this.pos = pos
    }
    override fun attack(unit: Unit) {
        if(pos.distanceTo(unit.pos) > range) {
            throw OutOfRangeException()
        }
        unit.attacked(damage)
    }
}

abstract class Footman(pos: Point) : Character(pos)

abstract class Archer(pos: Point) : Character(pos)

abstract class Hero(pos: Point) : Character(pos) {
    override fun attack(unit: Unit) {
        if(pos.distanceTo(unit.pos) > range) {
            throw OutOfRangeException()
        }
        else if(pos.distanceTo(unit.pos) > range/2.0) {
            unit.attacked(damage / 2) // Attack with half damage
        }
        else {
            unit.attacked(damage)
        }
    }
}

abstract class Mage(pos: Point, var mana: Int) : Character(pos) {
    override fun attack(unit: Unit) {
        if(pos.distanceTo(unit.pos) > range) {
            throw OutOfRangeException()
        }
        else if(mana < 10) {
            throw OutOfManaException()
        }
        mana -= 10
        unit.attacked(damage * 2) // Attack with double damage if enough mana
    }
}


class Player(val faction: Faction, val defaultPos: Point) {
    val units = mutableListOf<Unit>()

    val isPlayerAlive : Boolean
        get() = units.isNotEmpty()
}


object Game : UnitLifeObserver {

    var turn = 0
    val players = mutableListOf<Player>()

    fun addPlayer(player: Player) {
        // Check if player with the same faction already exists
        if(players.any { it.faction == player.faction }) {
            throw Exception("Player with the same faction already exists")
        }
        // Create the four buildings using BuildingFactory
        val barracks = BuildingFactory.createBarracks(player.defaultPos, player.faction)
        val forge = BuildingFactory.createForge(player.defaultPos, player.faction)
        val altar = BuildingFactory.createAltar(player.defaultPos, player.faction)
        val mageTower = BuildingFactory.createMageTower(player.defaultPos, player.faction)
        // Add the buildings to the player's units
        player.units.addAll(listOf(barracks, forge, altar, mageTower))
        players.add(player)
    }

    fun onPlayerTurn(player: Player) {
        println("-- Tour du joueur ${player.faction} --")
        // List units
        println("Liste des unités :")
        player.units.forEachIndexed { index, unit ->
            println("${index + 1} - ${unit.javaClass.simpleName} (${unit.hp} HP) en ${unit.pos}")
        }
        println("-- Quelle action souhaitez-vous effectuer ? --")
        println("1. Créer une unité")
        println("2. Déplacer une unité")
        println("3. Attaquer une unité")
        println("4. Passer son tour")

        val action = readLine()!!.toInt()
        when(action) {
            1 -> {
                println("Quelle bâtiment souhaitez-vous utiliser ?")
                player.units.filterIsInstance<Building>().forEachIndexed { index, building ->
                    println("${index + 1}. ${building.javaClass.simpleName}")
                }
                val buildingIndex = readLine()!!.toInt() - 1
                val building = player.units.filterIsInstance<Building>()[buildingIndex]
                val unit = building.buildUnit()
                println("Unité créée : ${unit.javaClass.simpleName} (${unit.hp} HP) en ${unit.pos}")
            }
            2 -> {
                println("Quelle unité souhaitez-vous déplacer ?")
                for((i, unit) in player.units.filterIsInstance<Character>().withIndex()) {
                    println("${i+1}. ${unit.javaClass.simpleName} (${unit.pos.x}, ${unit.pos.y})")
                }
                val unitIndex = readLine()!!.toInt()
                val unit = player.units.filterIsInstance<Character>()[unitIndex-1]
                println("Où souhaitez-vous la déplacer ?")
                println("x = ")
                val x = readLine()!!.toInt()
                println("y = ")
                val y = readLine()!!.toInt()
                unit.move(Point(x, y))
                println("Unité ${unit.javaClass.simpleName} déplacée en ($x, $y)")
            }
            3 -> {
                println("Quelle unité souhaitez-vous faire attaquer ?")
                for((i, unit) in player.units.filterIsInstance<Character>().withIndex()) {
                    println("${i+1}. ${unit.javaClass.simpleName} (${unit.pos.x}, ${unit.pos.y})")
                }
                val unitIndex = readLine()!!.toInt()
                val unit = player.units.filterIsInstance<Character>()[unitIndex-1]
                println("Quelle unité souhaitez-vous attaquer ?")
                for((i, target) in players.filter { it.faction != player.faction }.map { unit }.withIndex()) {
                    println("${i+1}. ${target.javaClass.simpleName} (${target.pos.x}, ${target.pos.y})")
                }
                val targetIndex = readLine()!!.toInt()
                val target = players.filter { it.faction != player.faction }.map { unit }[targetIndex-1]
                unit.attack(target)
                println("Unité ${unit.javaClass.simpleName} attaque ${target.javaClass.simpleName} en (${target.pos.x}, ${target.pos.y}) avec ${unit.damage} dégâts. Nouvelle vie : ${target.hp}")
            }
            4 -> {
                println("Tour passé")
            }
            else -> {
                throw Exception("Invalid action")
            }
        }

    }

    override fun onUnitDied(unit: Unit) {
        // Find the unit in all the players units list
        for(player in players) {
            if(player.units.contains(unit)) {
                player.units.remove(unit)
                return
            }
        }
    }
    override fun onUnitCreated(unit: Unit) {
        // Add unit to the player units list
        // Find the player with same faction
        for(player in players) {
            if(player.faction == unit.faction) {
                player.units.add(unit)
                return
            }
        }
    }

    fun playTurn() {
        turn++
        println("Début du tour $turn")
        for(player in players) {
            onPlayerTurn(player)
        }
        println("Fin du tour $turn")
    }

    fun isGameOver() : Boolean {
        return players.count { it.isPlayerAlive } <= 1
    }

    fun getWinner() : Player? {
        return players.firstOrNull { it.isPlayerAlive }
    }
}

/**
 * Units database
 */

class BuildingFactory {
    companion object {
       fun createBarracks(pos: Point, faction: Faction) : Building {
           return when(faction) {
               Faction.HUMANS -> HumanBarracks(pos)
               Faction.ORCS -> OrcBarracks(pos)
               Faction.ELFS -> ElfBarracks(pos)
           }
       }

         fun createForge(pos: Point, faction: Faction) : Building {
              return when(faction) {
                Faction.HUMANS -> HumanForge(pos)
                Faction.ORCS -> OrcForge(pos)
                Faction.ELFS -> ElfForge(pos)
              }
         }

            fun createAltar(pos: Point, faction: Faction) : Building {
                return when(faction) {
                    Faction.HUMANS -> HumanAltar(pos)
                    Faction.ORCS -> OrcAltar(pos)
                    Faction.ELFS -> ElfAltar(pos)
                }
            }

            fun createMageTower(pos: Point, faction: Faction) : Building {
                return when(faction) {
                    Faction.HUMANS -> HumanMageTower(pos)
                    Faction.ORCS -> OrcMageTower(pos)
                    Faction.ELFS -> ElfMageTower(pos)
                }
            }
    }
}

class HumanBarracks(pos: Point) : Building(pos) {
    override val faction: Faction = Faction.HUMANS
    override var hp: Int = 1000 // Default HP : 100
    override fun createUnit(): Unit {
        return HumanFootman(pos)
    }
}

class OrcBarracks(pos: Point) : Building(pos) {
    override val faction: Faction = Faction.ORCS
    override var hp: Int = 1000 // Default HP : 100
    override fun createUnit(): Unit {
        return OrcFootman(pos)
    }
}

class ElfBarracks(pos: Point) : Building(pos) {
    override val faction: Faction = Faction.ELFS
    override var hp: Int = 1000 // Default HP : 100
    override fun createUnit(): Unit {
        return ElfFootman(pos)
    }
}

class HumanForge(pos: Point) : Building(pos) {
    override val faction: Faction = Faction.HUMANS
    override var hp: Int = 1000 // Default HP : 100
    override fun createUnit(): Unit {
        return HumanArcher(pos)
    }
}

class OrcForge(pos: Point) : Building(pos) {
    override val faction: Faction = Faction.ORCS
    override var hp: Int = 1000 // Default HP : 100
    override fun createUnit(): Unit {
        return OrcArcher(pos)
    }
}

class ElfForge(pos: Point) : Building(pos) {
    override val faction: Faction = Faction.ELFS
    override var hp: Int = 1000 // Default HP : 100
    override fun createUnit(): Unit {
        return ElfArcher(pos)
    }
}

class HumanAltar(pos: Point) : Building(pos) {
    override val faction: Faction = Faction.HUMANS
    override var hp: Int = 1000 // Default HP : 100
    override fun createUnit(): Unit {
        return HumanHero(pos)
    }
}

class OrcAltar(pos: Point) : Building(pos) {
    override val faction: Faction = Faction.ORCS
    override var hp: Int = 1000 // Default HP : 100
    override fun createUnit(): Unit {
        return OrcHero(pos)
    }
}

class ElfAltar(pos: Point) : Building(pos) {
    override val faction: Faction = Faction.ELFS
    override var hp: Int = 1000 // Default HP : 100
    override fun createUnit(): Unit {
        return ElfHero(pos)
    }
}

class HumanMageTower(pos: Point) : Building(pos) {
    override val faction: Faction = Faction.HUMANS
    override var hp: Int = 1000 // Default HP : 100
    override fun createUnit(): Unit {
        return HumanMage(pos)
    }
}

class OrcMageTower(pos: Point) : Building(pos) {
    override val faction: Faction = Faction.ORCS
    override var hp: Int = 1000 // Default HP : 100
    override fun createUnit(): Unit {
        return OrcMage(pos)
    }
}

class ElfMageTower(pos: Point) : Building(pos) {
    override val faction: Faction = Faction.ELFS
    override var hp: Int = 1000 // Default HP : 100
    override fun createUnit(): Unit {
        return ElfMage(pos)
    }
}

class HumanFootman(pos: Point) : Footman(pos) {
    override val faction: Faction = Faction.HUMANS
    override var hp: Int = 100 // Default HP : 100
    override val damage: Int = 10 // Default damage : 10
    override val range: Int = 2 // Default range : 1
}

class OrcFootman(pos: Point) : Footman(pos) {
    override val faction: Faction = Faction.ORCS
    override var hp: Int = 150
    override val damage: Int = 15
    override val range: Int = 1
}

class ElfFootman(pos: Point) : Footman(pos) {
    override val faction: Faction = Faction.ELFS
    override var hp: Int = 80
    override val damage: Int = 8
    override val range: Int = 3
}

class HumanArcher(pos: Point) : Archer(pos) {
    override val faction: Faction = Faction.HUMANS
    override var hp: Int = 50 // Default HP : 100
    override val damage: Int = 10 // Default damage : 10
    override val range: Int = 10 // Default range : 1
}

class OrcArcher(pos: Point) : Archer(pos) {
    override val faction: Faction = Faction.ORCS
    override var hp: Int = 75
    override val damage: Int = 15
    override val range: Int = 8
}

class ElfArcher(pos: Point) : Archer(pos) {
    override val faction: Faction = Faction.ELFS
    override var hp: Int = 40
    override val damage: Int = 8
    override val range: Int = 12
}

class HumanHero(pos: Point) : Hero(pos) {
    override val faction: Faction = Faction.HUMANS
    override var hp: Int = 100 // Default HP : 100
    override val damage: Int = 10 // Default damage : 10
    override val range: Int = 5 // Default range : 1
}

class OrcHero(pos: Point) : Hero(pos) {
    override val faction: Faction = Faction.ORCS
    override var hp: Int = 150
    override val damage: Int = 15
    override val range: Int = 5
}

class ElfHero(pos: Point) : Hero(pos) {
    override val faction: Faction = Faction.ELFS
    override var hp: Int = 80
    override val damage: Int = 8
    override val range: Int = 5
}

class HumanMage(pos: Point) : Mage(pos, 100) {
    override val faction: Faction = Faction.HUMANS
    override var hp: Int = 50 // Default HP : 100
    override val damage: Int = 10 // Default damage : 10
    override val range: Int = 10 // Default range : 1
}

class OrcMage(pos: Point) : Mage(pos, 150) {
    override val faction: Faction = Faction.ORCS
    override var hp: Int = 75
    override val damage: Int = 15
    override val range: Int = 8
}

class ElfMage(pos: Point) : Mage(pos, 80) {
    override val faction: Faction = Faction.ELFS
    override var hp: Int = 40
    override val damage: Int = 8
    override val range: Int = 12
}

fun main() {
    Game.addPlayer(Player(Faction.HUMANS, Point(0, 0)))
    Game.addPlayer(Player(Faction.ORCS, Point(10, 10)))
    while(!Game.isGameOver()) {
        Game.playTurn()
    }
    val winner = Game.getWinner()
    if (winner != null) {
        println("Le joueur ${winner.faction} a gagné !")
    }
}

