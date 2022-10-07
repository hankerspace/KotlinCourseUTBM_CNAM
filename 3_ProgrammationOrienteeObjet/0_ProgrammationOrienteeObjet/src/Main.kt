class Car(var color: String) {

    fun displayColor() {
        println("The color of the car is $color")
    }

}

fun main() {
    val redCar = Car("red")
    redCar.displayColor()

    val blueCar = Car("blue")
    blueCar.displayColor()

    val greenCar = Car("green")
    greenCar.displayColor()
}
