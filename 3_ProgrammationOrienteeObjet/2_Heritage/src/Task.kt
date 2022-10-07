// Créez la classe Car qui possède un attribut brand et un attribut model, tous deux de type String
// La classe Car possède un constructeur qui prend en paramètre brand et model
// La classe Car possède une méthode start() qui affiche "The Renault Twingo is starting... Vroom!" en remplaçant Renault et Twingo par les valeurs de brand et model
open class Car(val brand: String, val model: String) {
    val carName: String
        get() = "$brand $model"

    open fun start() {
        println("The $carName is starting... Vroom!")
    }
}

// Créez la classe GasolineCar qui hérite de Car
// et qui a une propriété fuelLevel de type Int
// et une surcharge de la méthode start qui affiche un message différent
class GasolineCar(brand: String, model: String, val fuelLevel: Int) : Car(brand, model) {
    override fun start() {
        println("The $carName is starting... Vroom! (with a lot of smoke)")
    }
}

// Créez la classe ElectricCar qui hérite de Car
// et qui a une propriété batteryLevel de type Int
// et une surcharge de la méthode start qui affiche un message différent
open class ElectricCar(brand: String, model: String, val batteryLevel: Int) : Car(brand, model) {
    override fun start() {
        println("The $carName is starting... Vroom! (but silently)")
    }
}

// Créez la classe HybridCar qui hérite de ElectricCar
// et qui a une propriété fuelLevel de type Int et une propriété batteryLevel de type Int
// et une surcharge de la méthode start qui affiche un message différent
// fuelLevel est défini par défaut à 100 si on ne le précise pas
class HybridCar(brand: String, model: String, batteryLevel: Int, val fuelLevel: Int = 100) : ElectricCar(brand, model, batteryLevel) {
    override fun start() {
        println("The $carName is starting... Vroom! (but silently) (and with a little noise)")
    }
}

fun main(args: Array<String>) {
    // Jeux de test

    val car = Car("Renault", "Twingo")
    car.start()

    val gasolineCar = GasolineCar("Peugeot", "308", 100)
    gasolineCar.start()

    val electricCar = ElectricCar("Tesla", "Model 3", 100)
    electricCar.start()

    val hybridCar = HybridCar("Toyota", "Prius", 100)
    hybridCar.start()

    val hybridCar2 = HybridCar("Toyota", "Prius", 100, 50)
    hybridCar2.start()
}

fun testCar(): Any {
   return Car("Renault", "Twingo")
}

fun testGasolineCar(): Any {
   return GasolineCar("Peugeot", "308", 100)
}

fun testElectricCar(): Any {
   return ElectricCar("Tesla", "Model 3", 100)
}

fun testHybridCar(): Any {
   return HybridCar("Toyota", "Prius", 100)
}

fun testHybridCar2(): Any {
   return HybridCar("Toyota", "Prius", 100, 50)
}

fun testAllCars(): List<Car> {
    return listOf(
         Car("Renault", "Twingo"),
         GasolineCar("Peugeot", "308", 100),
         ElectricCar("Tesla", "Model 3", 100),
         HybridCar("Toyota", "Prius", 100),
         HybridCar("Toyota", "Prius", 100, 50)
    )
}