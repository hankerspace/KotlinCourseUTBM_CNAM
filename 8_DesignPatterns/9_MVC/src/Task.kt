class CalculatorModel {
    private var result = 0

    fun add(n1: Int, n2: Int) {
        result = n1 + n2
    }

    fun subtract(n1: Int, n2: Int) {
        result = n1 - n2
    }

    fun multiply(n1: Int, n2: Int) {
        result = n1 * n2
    }

    fun divide(n1: Int, n2: Int) {
        result = n1 / n2
    }

    fun getResult(): Int {
        return result
    }
}

class CalculatorView {
    fun printResult(result: Int) {
        println("Result: $result")
    }
}

class CalculatorController {
    private val model = CalculatorModel()
    private val view = CalculatorView()

    fun add(n1: Int, n2: Int) {
        model.add(n1, n2)
        view.printResult(model.getResult())
    }

    fun subtract(n1: Int, n2: Int) {
        model.subtract(n1, n2)
        view.printResult(model.getResult())
    }

    fun multiply(n1: Int, n2: Int) {
        model.multiply(n1, n2)
        view.printResult(model.getResult())
    }

    fun divide(n1: Int, n2: Int) {
        model.divide(n1, n2)
        view.printResult(model.getResult())
    }
}

fun main(args: Array<String>) {
    val controller = CalculatorController()
    controller.add(10, 5)
    controller.subtract(10, 5)
    controller.multiply(10, 5)
    controller.divide(10, 5)
}
