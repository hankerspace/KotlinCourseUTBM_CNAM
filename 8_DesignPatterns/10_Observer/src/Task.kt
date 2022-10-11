interface GateObserver {
    fun onEnter(customerName: String)
    fun onExit(customerName: String)
}

class Gate() {
    private val observers = mutableListOf<GateObserver>()

    fun addObserver(observer: GateObserver) {
        observers.add(observer)
    }

    fun removeObserver(observer: GateObserver) {
        observers.remove(observer)
    }

    fun enter(customerName: String) {
        observers.forEach { it.onEnter(customerName) }
    }

    fun exit(customerName: String) {
        observers.forEach { it.onExit(customerName) }
    }
}

class GateDisplay : GateObserver {
    var customersCount = 0

    private fun displayCount() {
        println("Current count: $customersCount")
    }

    override fun onEnter(customerName: String) {
        customersCount++
        displayCount()
    }

    override fun onExit(customerName: String) {
        customersCount--
        displayCount()
    }
}

class GateCashier : GateObserver {
    override fun onEnter(customerName: String) {
        println("Hello $customerName")
    }

    override fun onExit(customerName: String) {
        println("Goodbye $customerName")
    }
}

class GateSecurity : GateObserver {
    override fun onEnter(customerName: String) {
        // On chance on two
        if (Math.random() < 0.5) {
            println("Checking if $customerName has no weapons")
        }
    }

    override fun onExit(customerName: String) {
        // Do nothing
    }
}

fun main(args: Array<String>) {
    val gate = Gate()
    val display = GateDisplay()
    val cashier = GateCashier()
    val security = GateSecurity()

    gate.addObserver(display)
    gate.addObserver(cashier)
    gate.addObserver(security)

    gate.enter("John")
    gate.enter("Jane")
    gate.enter("Jack")
    gate.exit("John")
    gate.enter("Jill")
    gate.exit("Jane")
    gate.exit("Jack")
    gate.exit("Jill")
}