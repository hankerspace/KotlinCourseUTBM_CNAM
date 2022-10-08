interface Waterable {
    fun addWater(waterQuantity: Double)
}

interface Printable {
    fun retrieveZoneName() : String
    fun retrieveWaterLevel() : Double
}

abstract class Area(private val name: String) : Waterable, Printable {
    var waterLevel: Double = 0.0

    override fun retrieveZoneName(): String {
        return name
    }

    override fun retrieveWaterLevel(): Double {
        return waterLevel
    }
}

class GrassArea(name: String) : Area(name) {
    override fun addWater(waterQuantity: Double) {
        waterLevel += waterQuantity * 0.5
    }
}

class BuiltArea(name: String) : Area(name) {
    override fun addWater(waterQuantity: Double) {
        waterLevel += waterQuantity
    }
}

class WetArea(name: String, var capacity: Double) : Area(name) {
    override fun addWater(waterQuantity: Double) {
        // First : fill the capacity
        if (waterQuantity < capacity) {
            capacity -= waterQuantity
        } else {
            waterLevel += waterQuantity - capacity
            capacity = 0.0
        }
    }
}

fun getGrassArea(name: String) : Any {
    // Returns your grass area with the given name
    return GrassArea(name)
}

fun getBuiltArea(name: String) : Any {
    // Returns your built area with the given name
    return BuiltArea(name)
}

fun getWetArea(name: String, capacity: Double) : Any {
    // Returns your wet area with the given name and capacity
    return WetArea(name, capacity)
}
