abstract class Personnage(private val nom: String, private var x: Int, private var y: Int, private val vitesse: Int) {
    var pointsVie = 100
    var sous = 0

    /** Le personnage se deplace dans la direction (dx,dy) durant un temps t.  */
    fun seDeplacer(dx: Int, dy: Int, t: Int) {
        x = (x + dx * vitesse * t / Math.sqrt((dx * dx + dy * dy).toDouble())).toInt()
        y = (y + dy * vitesse * t / Math.sqrt((dx * dx + dy * dy).toDouble())).toInt()
    }

    abstract fun parler(): String?

    override fun toString(): String {
        return "$nom ($x, $y) $pointsVie $sous"
    }
}

open class Humain(nom: String?, x: Int, y: Int) : Personnage(nom!!, x, y, 5) {
    override fun parler(): String? {
        return "bonjour"
    }
}

open class Elfe(nom: String?, x: Int, y: Int) : Personnage(nom!!, x, y, 7) {
    override fun parler(): String? {
        return "Eldarie"
    }
}

open class Nain(nom: String?, x: Int, y: Int) : Personnage(nom!!, x, y, 2) {
    override fun parler(): String? {
        return "groumpf"
    }
}

interface Guerrier {
    fun attaque(p: Personnage?)
    val force: Int
}

interface Magicien {
    fun lancerSort(p: Personnage?)
    val magie: Int
}

interface Voleur {
    fun voler(p: Personnage?)
    val dexterite: Int
}

open class NainGuerrier(nom: String?, x: Int, y: Int, override val force: Int) : Nain(nom, x, y), Guerrier {

    override fun attaque(p: Personnage?) {
        p!!.pointsVie = p.pointsVie * (100 - force) / 100
    }
}

class NainGuerrierVoleur(nom: String?, x: Int, y: Int, force: Int, override val dexterite: Int) : NainGuerrier(nom, x, y, force), Voleur {
    override fun voler(p: Personnage?) {
        if (p!!.sous >= dexterite) {
            p.sous = p.sous - dexterite
            sous = sous + dexterite
        } else {
            sous = sous + p.sous
            p.sous = 0
        }
    }
}

fun main() {
    // Create few persons
    val aragorn = Humain("Aragorn", 0, 0)
    val legolas = Elfe("Legolas", 0, 0)
    val gimli = NainGuerrier("Gimli", 0, 0, 10)
    val gudal = NainGuerrierVoleur("Gudal", 0, 0, 10, 10)

    // Move them
    aragorn.seDeplacer(1, 1, 10)
    legolas.seDeplacer(1, 1, 10)
    gimli.seDeplacer(1, 1, 10)
    gudal.seDeplacer(1, 1, 10)

    // Act
    gimli.attaque(aragorn)
    gudal.attaque(legolas)
    aragorn.sous = 100
    gudal.voler(aragorn)

    // Print their state
    println(aragorn)
    println(legolas)
    println(gimli)
    println(gudal)
}




