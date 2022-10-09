import java.awt.Dimension
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.util.*
import javax.swing.*
import javax.swing.Timer
const val DISK_CAPACITY = 6
const val NUMBER_OF_RODS = 3

class TowersOfHanoi : JFrame() {
    //Instance Variables
    private var panel: JPanel? = null
    private var nextButton: JButton? = null
    private var animateButton: JButton? = null
    private var diskNumberLabel: JLabel? = null
    private var diskNumberSelection: JComboBox<Int>? = null
    private var mainComponent: MainComponent? = null
    private var rods: Rods
    private var timer: Timer? = null
    private var movesToSolve: LinkedList<Int>? = null

    /**
     * Constructor of the main frame.
     */
    init {
        rods = Rods(INITIAL_NUMBER_OF_DISKS, INITIAL_ROD)
        createComponents()
        title = TITLE
        setSize(FRAME_WIDTH, FRAME_HEIGHT)
        defaultCloseOperation = EXIT_ON_CLOSE
        isResizable = false
        isVisible = true
    }

    /**
     * Creates the smaller GUI elements and adds them to the frame.
     */
    private fun createComponents() {
        timer = Timer(DELAY, AnimationListener())
        nextButton = JButton("Next")
        animateButton = JButton("Animate")
        nextButton!!.addActionListener(NextButtonListener())
        animateButton!!.addActionListener(AnimateButtonListener())
        panel = JPanel()
        mainComponent = MainComponent(rods)
        mainComponent!!.setPreferredSize(Dimension(RODS_WIDTH, RODS_HEIGHT))
        panel!!.add(mainComponent)
        diskNumberLabel = JLabel(DISK_NUMBER_LABEL)
        diskNumberSelection = JComboBox(arrayOf(1, 2, 3, 4, 5, 6))
        diskNumberSelection!!.selectedItem = 4
        diskNumberSelection!!.addActionListener(DiskNumberChoiceListener())
        rods.solveTowersOfHanoi(rods.rodArray.get(INITIAL_ROD).disksOnTop.size, INITIAL_ROD, 1, 2)
        rods.initializeRods(diskNumberSelection!!.selectedItem as Int, INITIAL_ROD)
        panel!!.add(diskNumberLabel)
        panel!!.add(diskNumberSelection)
        panel!!.add(nextButton)
        panel!!.add(animateButton)
        add(panel)
    }

    /**
     * Inner class for the ActionListener used by the next button.
     */
    private inner class NextButtonListener : ActionListener {
        /**
         * Performs a move to solve the Towers of Hanoi Problem.
         * @param event The action event.
         */
        override fun actionPerformed(event: ActionEvent) {
            timer!!.stop()
            movesToSolve = rods.movesToSolve
            if (!movesToSolve!!.isEmpty()) {
                rods.moveDisk(movesToSolve!!.removeFirst(), movesToSolve!!.removeFirst())
                (mainComponent as MainComponent?)!!.update()
            }
        }
    }

    /**
     * Inner class for the ActionListener used by the animate button.
     */
    private inner class AnimateButtonListener : ActionListener {
        /**
         * Triggers the animation process.
         * @param event The action event.
         */
        override fun actionPerformed(event: ActionEvent) {
            timer!!.start()
        }
    }

    /**
     * Inner class for the ActionListener used by the timer.
     */
    private inner class AnimationListener : ActionListener {
        /**
         * Animates the disk in a way to solve the Towers of Hanoi problem.
         * @param event The action event.
         */
        override fun actionPerformed(event: ActionEvent) {
            movesToSolve = rods.movesToSolve
            if (!movesToSolve!!.isEmpty()) {
                rods.moveDisk(movesToSolve!!.removeFirst(), movesToSolve!!.removeFirst())
                (mainComponent as MainComponent?)!!.update()
            } else {
                timer!!.stop()
            }
        }
    }

    /**
     * Inner class for the ActionListener used by the combo box.
     */
    private inner class DiskNumberChoiceListener : ActionListener {
        /**
         * Changes the disk number according to the selected number on the combo box.
         * @param event The action event.
         */
        override fun actionPerformed(event: ActionEvent) {
            timer!!.stop()
            timer = Timer(DELAY, AnimationListener())
            rods = Rods(diskNumberSelection!!.selectedItem as Int, INITIAL_ROD)
            (mainComponent as MainComponent?)!!.updateRods(rods)
            rods.solveTowersOfHanoi(rods.rodArray.get(INITIAL_ROD).disksOnTop.size, INITIAL_ROD, 1, 2)
            rods.initializeRods(diskNumberSelection!!.selectedItem as Int, INITIAL_ROD)
        }
    }

    companion object {
        //Constants
        private const val FRAME_WIDTH = 600
        private const val FRAME_HEIGHT = 500
        private const val RODS_WIDTH = 550
        private const val RODS_HEIGHT = 400
        private const val INITIAL_NUMBER_OF_DISKS = 4
        private const val INITIAL_ROD = 0
        private const val TITLE = "Towers of Hanoi"
        private const val DISK_NUMBER_LABEL = "Select the number of disks:"
        private const val DELAY = 1000
    }
}