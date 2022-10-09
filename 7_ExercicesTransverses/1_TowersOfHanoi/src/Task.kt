import java.util.*

data class Disk(val size: Int)

data class Rod(val numberOfDisks: Int = 0) {
    // Create a stack of disk with numberOfDisks disks
    val disksOnTop = Stack<Disk>().apply {
        for (i in 0 until numberOfDisks) {
            push(Disk(DISK_CAPACITY - i))
        }
    }
}

class Rods(numberOfDisks: Int, initialRod: Int) {
    var rodArray: Array<Rod>
        private set

    /**
     * Returns a data structure containing the certain moves to solve the Towers of Hanoi
     * problem.
     * @return A list containing the certain moves to solve the Towers of Hanoi problem.
     */
    val movesToSolve: LinkedList<Int> = LinkedList()

    /**
     * The constructor of the Rods class. Takes the disk number and the initial rod, the rod
     * where the disks will be at the beginning, as parameters.
     * @param numberOfDisks The number of disks on the platform.
     * @param initialRod The rod where the disks will be at the beginning.
     */
    init {
        val initial = Rod(numberOfDisks)
        // Create rod array with number of rods
        rodArray = Array(NUMBER_OF_RODS) { Rod() }
        for (i in 0 until NUMBER_OF_RODS) {
            if (i == initialRod) {
                rodArray[i] = initial
            }
        }
        rodArray[initialRod] = initial
    }

    /**
     * A method that is similar to the constructor, it initializes the platform but it
     * does not change other data structures.
     * @param numberOfDisks The number of disks on the platform.
     * @param initialRod The rod where the disks will be at the beginning.
     */
    fun initializeRods(numberOfDisks: Int, initialRod: Int) {
        val initial = Rod(numberOfDisks)
        rodArray = Array(NUMBER_OF_RODS) { Rod() }
        for (i in 0 until NUMBER_OF_RODS) {
            if (i == initialRod) {
                rodArray[i] = initial
            }
        }
        rodArray[initialRod] = initial
    }

    /**
     * Moves the disk on top of one rod to the top of another rod.
     * @param from The rod that the disk is taken.
     * @param destination The rod that the disk is given.
     */
    fun moveDisk(from: Int, destination: Int) {
        val fromStack = rodArray[from].disksOnTop
        if (!fromStack.isEmpty()) {
            println("Move disk from rod $from to rod $destination")
            rodArray[destination].disksOnTop.push(fromStack.pop())
        } else {
            println("Rod is empty, no disks to move...")
        }
    }

    /**
     * Moves the disks in a certain recursive pattern such that the Towers of Hanoi problem
     * is properly solved.
     * @param disksOnTop The number of disks on the starting rod.
     * @param from The rod, where the disks are at the beginning.
     * @param spare The rod that is neither from nor destination.
     * @param destination The rod, where the disks will be at the end.
     */
    fun solveTowersOfHanoi(disksOnTop: Int, from: Int, spare: Int, destination: Int) {
        if (disksOnTop >= 1) {
            solveTowersOfHanoi(disksOnTop - 1, from, destination, spare)
            moveDisk(from, destination)
            movesToSolve.addLast(from)
            movesToSolve.addLast(destination)
            solveTowersOfHanoi(disksOnTop - 1, spare, from, destination)
        }
    }

}

fun main(args: Array<String>) {
    val towersOfHanoi = TowersOfHanoi()
}