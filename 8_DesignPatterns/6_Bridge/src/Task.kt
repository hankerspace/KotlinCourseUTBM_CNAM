interface Enchantement {
    fun appliquerEnchantement()
}

class EnchantementFeu : Enchantement {
    override fun appliquerEnchantement() {
        println("Enchantement feu")
    }
}

class EnchantementGlace : Enchantement {
    override fun appliquerEnchantement() {
        println("Enchantement glace")
    }
}

class EnchantementFoudre : Enchantement {
    override fun appliquerEnchantement() {
        println("Enchantement foudre")
    }
}

abstract class Arme() {
    abstract fun attaquer()
}

class Epee : Arme() {
    override fun attaquer() {
        println("Attaque epee")
    }
}

class Hache : Arme() {
    override fun attaquer() {
        println("Attaque hache")
    }
}

class ArmeEnchante(val arme: Arme, val enchantement: Enchantement) : Arme() {
    override fun attaquer() {
        arme.attaquer()
        enchantement.appliquerEnchantement()
    }
}

fun main(args: Array<String>) {
    // Exemple d'utilisation
    val epee = Epee()
    val hache = Hache()
    val epeeFeu = ArmeEnchante(epee, EnchantementFeu())
    val hacheGlace = ArmeEnchante(hache, EnchantementGlace())
    epee.attaquer()
    hache.attaquer()
    epeeFeu.attaquer()
    hacheGlace.attaquer()
}