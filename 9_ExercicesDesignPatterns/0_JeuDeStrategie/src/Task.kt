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
    abstract fun createUnit(): Unit
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
}


object Game : UnitLifeObserver {

    val players = mutableListOf<Player>()

    fun addPlayer(player: Player) {
        players.add(player)
    }

    fun onPlayerTurn(player: Player) {
        println("-- Tour du joueur ${player.faction} --")
        println("-- Quelle action souhaitez-vous effectuer ? --")
        println("1. Créer une unité")
        println("2. Déplacer une unité")
        println("3. Attaquer une unité")
        println("4. Passer son tour")
        val action = readLine()!!.toInt()
        when(action) {
            1 -> {
                println("Quelle unité souhaitez-vous créer ?")
                println("1. Caserne")
                println("2. Forge")
                println("3. Autel des héros")
                println("4. Tour des mages")
                val unitType = readLine()!!.toInt()
                val unit = when(unitType) {
                    1 -> {
                       BuildingFactory.createBarracks(player.defaultPos, player.faction)
                    }
                    2 -> {
                        BuildingFactory.createForge(player.defaultPos, player.faction)
                    }
                    3 -> {
                        BuildingFactory.createAltar(player.defaultPos, player.faction)
                    }
                    4 -> {
                        BuildingFactory.createMageTower(player.defaultPos, player.faction)
                    }
                    else -> {
                        throw Exception("Invalid unit type")
                    }
                }
                player.units.add(unit)
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
            }
            3 -> {
                println("Quelle unité souhaitez-vous faire attaquer ?")
                for((i, unit) in player.units.filterIsInstance<Character>().withIndex()) {
                    println("${i+1}. ${unit.javaClass.simpleName} (${unit.pos.x}, ${unit.pos.y})")
                }
                val unitIndex = readLine()!!.toInt()
                val unit = player.units.filterIsInstance<Character>()[unitIndex-1]
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
                break
            }
        }
    }
    override fun onUnitCreated(unit: Unit) {
    //TODO
    }
}

fun main() {

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






