// Implémentez le reste du code pour que le main fonctionne

class Person(val name: String, var age: Int, var town: String) {
    fun moveTo(newTown: String) {
        town = newTown
    }
    fun incrementAge() {
        age++
    }

    override fun toString(): String {
        return "$name, $age years old, lives in $town"
    }
}


fun main() {
    Person("Alice", 20, "Paris").let {
       println(it)
        it.moveTo("London")
        it.incrementAge()
        println(it)
    }
}