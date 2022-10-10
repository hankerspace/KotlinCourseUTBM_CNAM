interface State {
    fun next(): State
    fun print()
}

class RedState : State {
    override fun next() = GreenState()
    override fun print() = println("red light")
}

class GreenState : State {
    override fun next() = OrangeState()
    override fun print() = println("green light")
}

class OrangeState : State {
    override fun next() = RedState()
    override fun print() = println("orange light")
}


class TrafficLight {
    private var state: State = RedState()

    fun next() {
        state = state.next()
    }

    fun print() {
        state.print()
    }
}

fun main(args: Array<String>) {
    // Exemple d'utilsation
    val trafficLight = TrafficLight()
    for (i in 1..10) {
        trafficLight.print()
        Thread.sleep(1000)
        trafficLight.next()
    }
}