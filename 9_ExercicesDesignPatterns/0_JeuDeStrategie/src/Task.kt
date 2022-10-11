data class Point(val x: Int, val y: Int)
enum class Faction { HUMANS, ORCS, ELFS }

interface Factoryable {
    fun buildUnit(constructor: () -> Unit): Unit
}
interface Moveable {
    fun move(pos: Point)
}
interface Attackable {
    fun attacked(damage: Int)
}

abstract class Unit() : Attackable {
    abstract val faction: Faction
    abstract var hp: Int
    abstract var pos: Point
}

abstract class Building() : Unit(), Factoryable

class Barracks(x: Int, y: Int) : Building() {
    override val faction: Faction = Faction.HUMANS
    override var hp: Int = 1000 // Default HP : 100
    override var pos: Point = Point(x, y)
    override fun attacked(damage: Int) {
        hp -= damage
        if(hp <= 0) {
            // TODO : Destroy the building
        }
    }
    override fun buildUnit(constructor: () -> Unit) : Unit {
        return constructor()
    }
}