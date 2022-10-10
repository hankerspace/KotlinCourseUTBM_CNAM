open class Flora
class Cactus : Flora()
class Bouleau : Flora()
class Sapin : Flora()
class Pin : Flora()
class Rose : Flora()
class Tulipe : Flora()
class Chene : Flora()

open class Terrain
class Sand : Terrain()
class Grass : Terrain()
class Rock : Terrain()
class Humus : Terrain()

open class Fauna
class Scorpion : Fauna()
class Chameau : Fauna()
class Cerf : Fauna()
class Sanglier : Fauna()
class Ours : Fauna()
class Loup : Fauna()
class Lapin : Fauna()
class Oiseau : Fauna()

interface EnvironmentFactory {
    fun createFlora(): List<Flora>
    fun createTerrain(): Terrain
    fun createFauna(): List<Fauna>
}

class DesertFactory : EnvironmentFactory {
    override fun createFlora(): List<Flora> = listOf(Cactus())
    override fun createTerrain(): Terrain = Sand()
    override fun createFauna(): List<Fauna> = listOf(Scorpion(), Chameau())
}

class ForestFactory : EnvironmentFactory {
    override fun createFlora(): List<Flora> = listOf(Bouleau(), Chene())
    override fun createTerrain(): Terrain = Humus()
    override fun createFauna(): List<Fauna> = listOf(Cerf(), Sanglier())
}

class MountainFactory : EnvironmentFactory {
    override fun createFlora(): List<Flora> = listOf(Pin(), Sapin())
    override fun createTerrain(): Terrain = Rock()
    override fun createFauna(): List<Fauna> = listOf(Ours(), Loup())
}

class PlainFactory : EnvironmentFactory {
    override fun createFlora(): List<Flora> = listOf(Rose(), Tulipe())
    override fun createTerrain(): Terrain = Grass()
    override fun createFauna(): List<Fauna> = listOf(Oiseau(), Lapin())
}

enum class EnvironmentType {
    DESERT, FOREST, MOUNTAIN, PLAIN
}

class EnvironmentFactoryProducer {
    companion object {
        fun getFactory(type: EnvironmentType): EnvironmentFactory = when (type) {
            EnvironmentType.DESERT -> DesertFactory()
            EnvironmentType.FOREST -> ForestFactory()
            EnvironmentType.MOUNTAIN -> MountainFactory()
            EnvironmentType.PLAIN -> PlainFactory()
        }
    }
}

fun main(args: Array<String>) {
    val desertFactory = EnvironmentFactoryProducer.getFactory(EnvironmentType.DESERT)
    val forestFactory = EnvironmentFactoryProducer.getFactory(EnvironmentType.FOREST)
    val mountainFactory = EnvironmentFactoryProducer.getFactory(EnvironmentType.MOUNTAIN)
    val plainFactory = EnvironmentFactoryProducer.getFactory(EnvironmentType.PLAIN)

    println(desertFactory.createFlora())
    println(desertFactory.createTerrain())
    println(desertFactory.createFauna())

    println(forestFactory.createFlora())
    println(forestFactory.createTerrain())
    println(forestFactory.createFauna())

    println(mountainFactory.createFlora())
    println(mountainFactory.createTerrain())
    println(mountainFactory.createFauna())

    println(plainFactory.createFlora())
    println(plainFactory.createTerrain())
    println(plainFactory.createFauna())
}