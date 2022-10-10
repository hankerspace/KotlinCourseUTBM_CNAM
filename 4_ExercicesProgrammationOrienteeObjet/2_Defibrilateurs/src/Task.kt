/**
 * Exercice 1
 */

enum class DefibrillatorModel(val model: String) {
    RED_PA_1("RED PA-1"),
    SAMARITAN_PAD("SAMARITAN PAD"),
    FRED_EASYLIFE("FRED EASYLIFE")
}

data class Location(val longitude: Double, val latitude: Double)
data class Defibrillator(val id: Int, val location: Location, val model: DefibrillatorModel)

/**
 * Exercice 2
 */
fun generateDefibrilators(count: Int): List<Defibrillator> {
    val defibrilators = mutableListOf<Defibrillator>()
    for (i in 1..count) {
        val longitude = 48.0 + Math.random()
        val latitude = 6.0 + Math.random()
        val location = Location(longitude, latitude)
        val model = DefibrillatorModel.values().random()
        defibrilators.add(Defibrillator(i, location, model))
    }
    return defibrilators
}

/**
 * Exercice 3
 */
fun Location.distanceTo(other: Location): Double {
    // Distance with Pythagore
    val x = this.longitude - other.longitude
    val y = this.latitude - other.latitude

    return Math.sqrt(x * x + y * y)
}

fun List<Defibrillator>.findClosestDefibrillator(location: Location): Defibrillator {
    return this.minBy { it.location.distanceTo(location) }
}

/**
 * Exercice 4
 */
fun List<Defibrillator>.findClosestDefibrillators(location: Location): List<Defibrillator> {
    val list = mutableListOf<Defibrillator>()
    list.add(this.filter { it.model == DefibrillatorModel.RED_PA_1 }.findClosestDefibrillator(location))
    list.add(this.filter { it.model == DefibrillatorModel.SAMARITAN_PAD }.findClosestDefibrillator(location))
    list.add(this.filter { it.model == DefibrillatorModel.FRED_EASYLIFE }.findClosestDefibrillator(location))
    return list.sortedBy { it.location.distanceTo(location) }
}

/**
 * Exercice 5
 */
fun Location.distanceToInMeters(other: Location): Int {
    // Haversine formula
    val earthRadius = 6371.0
    val dLat = Math.toRadians(other.latitude - this.latitude)
    val dLon = Math.toRadians(other.longitude - this.longitude)
    val a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
            Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(other.latitude)) *
            Math.sin(dLon / 2) * Math.sin(dLon / 2)
    val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))
    return (earthRadius * c * 1000).toInt()
}

/**
 * Exercice 6
 */
fun Defibrillator.timeToReachInSeconds(location: Location): Double {
    val distance = this.location.distanceToInMeters(location)
    val speed = 5.0 * 1000.0 / 60.0 / 60.0 // 5 km/h
    return distance / speed
}


fun main() {
    val defibrillators = generateDefibrilators(10000)

    val userPosition = Location(48.5, 6.6)
    val defibrillator = defibrillators.findClosestDefibrillator(userPosition)
    println("Le défibrilateur le plus proche est le : $defibrillator")
    println("Il se situe à ${defibrillator.location.distanceToInMeters(userPosition)} mètres de vous")
    println("Il vous faudra approximativement ${defibrillator.timeToReachInSeconds(userPosition) / 60.0} minutes pour le rejoindre")
}

