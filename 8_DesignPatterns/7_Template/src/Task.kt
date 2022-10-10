abstract class Trick() {
    abstract fun prepareEnvironment()
    abstract fun start()
    abstract fun end()

    fun perform() {
        prepareEnvironment()
        start()
        end()
    }
}

class TrickLVM() : Trick() {
    override fun prepareEnvironment() {
        println("Creates several fake websites that make him look like an extremely famous and noble person named Lorenzo Von Matterhorn")
    }

    override fun start() {
        println("Tricks a girl and tells her he is Lorenzo Von Matterhorn")
    }

    override fun end() {
        println("The girl checks the websites and realizes that he is the famous Lorenzo Von Matterhorn")
    }
}

class TrickSD() : Trick() {
    override fun prepareEnvironment() {
        println("Waits in the bar with a diving suit")
    }

    override fun start() {
        println("Let a girl asks him to tells what is the Scuba Diver Trick")
    }

    override fun end() {
        println("Impress the girl with his Scuba Diver Trick")
    }
}

class TrickSNASA() : Trick() {
    override fun prepareEnvironment() {
        println("Wear a SUIT and a NASA badge")
    }

    override fun start() {
        println("Tells a girl that he is working for the S-NASA (Secret NASA)")
    }

    override fun end() {
        println("Claims to have been to the identically-named \"SMoon\"")
    }
}

class BarneyStinson(var trick: Trick) {
    fun performTrick() {
        trick.perform()
    }

    fun changeTrick(newTrick: Trick) {
        println("-- Barney changes his trick to ${newTrick.javaClass.simpleName}")
        trick = newTrick
    }
}

fun main(args: Array<String>) {
    // Main de test
    val barney = BarneyStinson(TrickLVM())
    barney.performTrick()
    barney.changeTrick(TrickSD())
    barney.performTrick()
    barney.changeTrick(TrickSNASA())
    barney.performTrick()
}



