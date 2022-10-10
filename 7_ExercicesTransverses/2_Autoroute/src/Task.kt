abstract class Toll(val name: String, val KP: Double)
class InToll(name: String, KP: Double) : Toll(name, KP)
class OutToll(name: String, KP: Double) : Toll(name, KP)
class EcotaxToll(name: String, KP: Double, val price: Double) : Toll(name, KP)

abstract class Vehicle(val matriculation: String)
class Motorcycle(matriculation: String) : Vehicle(matriculation)
class Car(matriculation: String, val passengerCount : Int) : Vehicle(matriculation)
class Truck(matriculation: String, val loadWeightTons : Double) : Vehicle(matriculation)

class Highway(val name: String) {
    val tolls: MutableList<Toll> = mutableListOf()

    fun addToll(toll: Toll) {
        tolls.add(toll)
        tolls.sortBy { it.KP }
    }

    fun addTravel(vehicle: Vehicle, inKP: Double, outKP: Double) {
        // Check input
        if(inKP > outKP) throw IllegalArgumentException("inKP must be lower than outKP")
        val previousToll = tolls.filter { it.KP < inKP }.maxByOrNull { it.KP }
        val nextToll = tolls.filter { it.KP > outKP }.minByOrNull { it.KP }
        if (!(previousToll === null || previousToll is OutToll) || !(nextToll === null || nextToll is InToll))
            throw IllegalArgumentException("inKP and outKP must be outside an inToll and an outToll")


        print("Le véhicule ${vehicle.matriculation} est entré sur l'autoroute $name au PK $inKP, ")
        var inKp = 0.0
        tolls.filter { it.KP in inKP..outKP }.forEach {
            if(it is InToll) {
                print("il a pris un ticket au péage ${it.name}, ")
                inKp = it.KP
            } else if(it is OutToll) {
                val distance = it.KP - inKp
                val price = when(vehicle) {
                    is Motorcycle -> distance * 0.1
                    is Car -> distance * 0.2 + vehicle.passengerCount * 10
                    is Truck -> distance * 0.3 + vehicle.loadWeightTons * 5
                    else -> throw IllegalArgumentException("Vehicle type not supported")
                }
                print("il a payé $price euros lors du passage au péage ${it.name}, ")
            }
            else if(it is EcotaxToll && vehicle is Truck){
                // Ecotax
                print("il a payé ${it.price} euros lors du passage au péage ${it.name}, ")
            }
        }
        println("et il est sorti au PK $outKP.")

    }

}

fun main() {
    val highwayA6 = Highway("A6")
    highwayA6.addToll(InToll("Paris", 0.0))
    highwayA6.addToll(EcotaxToll("Ecotaxe 1", 100.0, 50.0))
    highwayA6.addToll(EcotaxToll("Ecotaxe 2", 400.0, 50.0))
    highwayA6.addToll(OutToll("Lyon nord", 600.0))
    highwayA6.addToll(InToll("Lyon sud", 650.0))
    highwayA6.addToll(EcotaxToll("Ecotaxe 3", 800.0, 50.0))
    highwayA6.addToll(OutToll("Marseille", 1000.0))

    highwayA6.addTravel(Motorcycle("AB-123-CD"), 0.0, 600.0)
    highwayA6.addTravel(Car("DD-234-GD", 2), 0.0, 620.0)
    highwayA6.addTravel(Truck("GF-231-AB", 2.0), 0.0, 1200.0)
    highwayA6.addTravel(Car("EE-234-GD", 5), 630.0, 1200.0)


}
