import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.Graphics
import java.awt.event.ActionEvent
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import java.util.*
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.SwingUtilities
import javax.swing.Timer

enum class State {
    INITIALIZED, READY, PLAYING, PAUSE, GAMEOVER, DESTROYED
}

interface StateTransition {
    /**
     * Perform one-time initialization tasks, such as constructing game objects,
     * opening files, setting up the timers, audio and images, and setting up
     * the key/mouse event handlers.
     */
    fun initGame() {}

    /**
     * Perform per-game initialization tasks for a new game, such as
     * resetting the score and all the game properties, clear the board, etc.
     */
    fun newGame() {}

    /**
     * Start the game, e.g., start the timers
     */
    fun startGame() {}

    /**
     * Stop the game (game over), stop the timers and update game statistics
     * such as high score.
     */
    fun stopGame() {}
    /**
     * Run one step of the game, either due to user action (via key/mouse) or timer task.
     * Hard to define here as it may have different parameters and return type.
     */
    // default Xxx stepGame(Aaa) { }
    /**
     * Pause the game, e.g., pause the timers
     */
    fun pauseGame() {}

    /**
     * Resume the paused game, e.g., resume the timers
     */
    fun resumeGame() {}

    /**
     * Perform housekeeping tasks such as closing the files before exiting.
     */
    fun destroyGame() {}
}

enum class Move {
    UP, DOWN, LEFT, RIGHT
}

class SnakeSegment(var headX: Int, var headY: Int, var length: Int, var direction: Move) {
    /** Size of each body cell in pixels  */
    private val CELL_SIZE = GameMain.CELL_SIZE

    /**
     * Grow by adding one cell in front of the head of this segment.
     */
    fun grow() {
        length++
        when (direction) {
            Move.LEFT -> headX--
            Move.RIGHT -> headX++
            Move.UP -> headY--
            Move.DOWN -> headY++
        }
    }

    /**
     * Shrink by removing one cell from the tail of this segment.
     */
    fun shrink() {
        length--
        // no change in headX and headY needed
    }// UP or DOWN

    // Helper method to get the tail x.
    private val tailX: Int
        get() = if (direction === Move.LEFT) {
            headX + length - 1
        } else if (direction === Move.RIGHT) {
            headX - length + 1
        } else {   // UP or DOWN
            headX
        }// LEFT or RIGHT

    // Helper method to get the tail y.
    private val tailY: Int
        get() {
            return if (direction === Move.DOWN) {
                headY - length + 1
            } else if (direction === Move.UP) {
                headY + length - 1
            } else {  // LEFT or RIGHT
                headY
            }
        }

    /**
     * Returns true if the snake segment contains the given cell.
     * Used for collision detection.
     */
    fun contains(x: Int, y: Int): Boolean {
        return when (direction) {
            Move.LEFT -> y == headY && (x >= headX) && x <= tailX
            Move.RIGHT -> y == headY && x <= headX && x >= tailX
            Move.UP -> x == headX && (y >= headY) && y <= tailY
            Move.DOWN -> (x == headX) && y <= headY && y >= tailY
        }
    }

    /**
     * Paint itself via the Graphics object.
     * Since SnakeSegments are encapsulated in Snake, snakeSegment.paint(Graphics)
     * shall be called in snake.paint(Graphics).
     */
    fun paint(g: Graphics) {
        var x = headX
        var y = headY
        when (direction) {
            Move.LEFT -> {
                var i = 0
                while (i < length) {
                    g.fill3DRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE - 1, CELL_SIZE - 1, true)
                    // width/height minus-1 for better looking adjacent raised rectangles
                    x++
                    i++
                }
            }

            Move.RIGHT -> {
                var i = 0
                while (i < length) {
                    g.fill3DRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE - 1, CELL_SIZE - 1, true)
                    x--
                    i++
                }
            }

            Move.UP -> {
                var i = 0
                while (i < length) {
                    g.fill3DRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE - 1, CELL_SIZE - 1, true)
                    y++
                    i++
                }
            }

            Move.DOWN -> {
                var i = 0
                while (i < length) {
                    g.fill3DRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE - 1, CELL_SIZE - 1, true)
                    y--
                    i++
                }
            }
        }
    }

}

/**
 * A Snake is made up of one or more SnakeSegments.
 * This class implements GameState interface but only overrides the
 * newGame(). See game state diagram.
 *
 * When the snake moves forward:
 * - The head segment grows by one cell.
 * - If no food is eaten, the tail segment shrink by one cell; otherwise
 * no change.
 * - No change for the intermediate segments.
 */
class Snake : StateTransition {
    /** Initial Length of the snake  */
    private val INIT_LENGTH = 12

    /** Size of each body cell in pixels  */
    private val CELL_SIZE = GameMain.CELL_SIZE

    val COLOR_HEAD = Color.RED // color for the snake's head
    val COLOR_BODY = Color.PINK // color for the snake's body

    // == Define the snake properties (package-visible) ==
    // The snake segments that forms the snake
    var segments: MutableList<SnakeSegment> = ArrayList<SnakeSegment>()

    // The current moving direction of this snake
    var direction: Move? = null

    /**
     * Regenerate the snake for a new game.
     */
    override fun newGame() {
        segments.clear()
        // Create a snake at the center of the pit, facing up.
        val headX = GameMain.COLS / 2
        val headY = GameMain.ROWS / 2
        val length = INIT_LENGTH
        direction = Move.UP
        segments.add(SnakeSegment(headX, headY, length, direction!!))
    }

    /**
     * Change the direction of the snake, but no 180 degree turn allowed.
     */
    fun changeDirection(newDir: Move) {
        // No 180 degree tur
        if (newDir !== direction &&
            ((newDir === Move.UP && direction !== Move.DOWN) ||
                    (newDir === Move.DOWN && direction !== Move.UP) ||
                    (newDir === Move.LEFT && direction !== Move.RIGHT) ||
                    (newDir === Move.RIGHT && direction !== Move.LEFT))
        ) {
            val headSegment: SnakeSegment = segments[0] // get the head segment
            val x: Int = headSegment.headX
            val y: Int = headSegment.headY
            // Insert a new segment with zero length as the new head segment
            segments.add(0, SnakeSegment(x, y, 0, newDir))
            direction = newDir
        }
    }

    /**
     * Growing the head segment by one cell.
     */
    fun grow() {
        // Grow the head segment
        val headSegment: SnakeSegment = segments[0] // "head" segment
        headSegment.grow()
    }

    /**
     * Shrink the tail segment by one cell (not eaten food)
     */
    fun shrink() {
        val tailSegment: SnakeSegment = segments[segments.size - 1]
        tailSegment.shrink()
        if (tailSegment.length == 0) {
            segments.remove(tailSegment)
        }
    }

    /**
     * Get the X coordinate of the cell that contains the head of this snake segment.
     *
     * @return x of the snake head
     */
    val headX: Int
        get() = segments[0].headX

    /**
     * Get the Y coordinate of the cell that contains the head of this snake segment.
     *
     * @return y of the snake head
     */
    val headY: Int
        get() = segments[0].headY

    /**
     * Get the length of this snake by adding up all the segments.
     *
     * @return the length of this snake
     */
    val length: Int
        get() {
            var length = 0
            for (segment in segments) {
                length += segment.length
            }
            return length
        }

    /**
     * Check if this snake contains the given (x, y) cell. Used in collision
     * detection
     *
     * @return true if this snake contains the given (x, y)
     */
    fun contains(x: Int, y: Int): Boolean {
        for (i in segments.indices) {
            val segment: SnakeSegment = segments[i]
            if (segment.contains(x, y)) {
                return true
            }
        }
        return false
    }

    /**
     * Check if the snake eats itself.
     *
     * @return true if the snake eats itself
     */
    fun eatItself(): Boolean {
        val headX = headX
        val headY = headY
        // eat itself if the (headX, headY) hits its body segment (4th onwards)
        for (i in 3 until segments.size) {
            val segment: SnakeSegment = segments[i]
            if (segment.contains(headX, headY)) {
                return true
            }
        }
        return false
    }

    /**
     * Paint itself via the Graphics context.
     * The JPanel's repaint() in GameMain class callbacks paintComponent(Graphics)
     * This snake.paint(Graphics) shall be placed in paintComponent(Graphics).
     *
     * @param g - the drawing Graphics object
     */
    fun paint(g: Graphics) {
        g.color = COLOR_BODY
        for (i in segments.indices) {
            segments[i].paint(g) // draw all the segments
        }
        // Paint over the head again using a different head color and bigger
        val offset = 2
        if (segments.size > 0) {
            g.color = COLOR_HEAD
            g.fill3DRect(
                headX * CELL_SIZE - offset / 2, headY * CELL_SIZE - offset / 2,
                CELL_SIZE - 1 + offset, CELL_SIZE - 1 + offset, true
            )
        }
    }

}

class Food {
    // == Define named constants ==
    private val COLOR_FOOD = Color(76, 181, 245) // Blue #4CB5F5
    private val rand: Random = Random()

    // == Define properties (package access) ==
    /** current food location (x, y) in the pit (in cells)  */
    var x = 0
    var y = 0

    /** Food items eaten count  */
    var foodEaten = -1

    /**
     * Regenerate a food item. Randomly place inside the pit (slightly off the edge).
     */
    fun newFood() {
        x = rand.nextInt(GameMain.COLS - 4) + 2
        y = rand.nextInt(GameMain.ROWS - 4) + 2
        ++foodEaten // one more food eaten
    }

    /**
     * Paint itself via the Graphics context.
     * The repaint() in GameMain class callbacks paintComponent(Graphics)
     * This snake.paint(Graphics) shall be placed in paintComponent(Graphics).
     *
     * @param g - the drawing Graphics object
     */
    fun paint(g: Graphics) {
        g.color = COLOR_FOOD
        // Slightly bigger than the cell
        val offset = 4
        g.fill3DRect(
            x * GameMain.CELL_SIZE - offset / 2,
            y * GameMain.CELL_SIZE - offset / 2,
            GameMain.CELL_SIZE + offset, GameMain.CELL_SIZE + offset, true
        )
    }
}

/**
 * Main Game Logic and Display
 */
class GameMain : JPanel(), StateTransition {
    // == Define game objects ==
    private var snake: Snake = Snake()
    private var food: Food = Food()
    private var pit: GamePanel? = null

    /** Current state of the game  */
    private var currentState: State? = null

    /** Game step timer  */
    private var stepTimer: Timer? = null

    /**
     * Constructor to initialize the UI components and game objects
     */
    init {
        // Set up UI components
        initGUI()

        // Perform one-time initialization tasks
        initGame()

        // Reset all properties for a new game
        newGame()
    }

    /**
     * Helper method to create (init) UI components, called in constructor.
     */
    fun initGUI() {
        pit = GamePanel()
        pit!!.preferredSize = Dimension(PIT_WIDTH, PIT_HEIGHT)
        pit!!.isFocusable = true // to receive key-events
        pit!!.requestFocus()
        super.add(pit) // JPanel.add()
    }

    /**
     * Perform one-time initialization tasks. See game state diagram.
     * Initialize all the game objects, run only once in the constructor
     * of the main class.
     */
    override fun initGame() {

        // Set up a Swing's timer to repeatedly schedule a task
        //  on the event dispatching thread (KeyEvent also run on EDT).
        stepTimer = Timer(STEP_IN_MSEC) { e: ActionEvent? -> stepGame() }

        // Set up key event handler
        pit!!.addKeyListener(object : KeyAdapter() {
            override fun keyPressed(evt: KeyEvent) {
                val key = evt.keyCode
                if (currentState === State.READY) {
                    // Any keys to start the game
                    startGame()
                } else if (currentState === State.PLAYING) {
                    when (key) {
                        KeyEvent.VK_UP -> snake.changeDirection(Move.UP)
                        KeyEvent.VK_DOWN -> snake.changeDirection(Move.DOWN)
                        KeyEvent.VK_LEFT -> snake.changeDirection(Move.LEFT)
                        KeyEvent.VK_RIGHT -> snake.changeDirection(Move.RIGHT)
                    }
                } else if (currentState === State.GAMEOVER) {
                    // Any keys to re-start the game
                    newGame()
                    startGame()
                }
            }
        })
        currentState = State.INITIALIZED
    }

    /**
     * Perform per-game initialization tasks. See game state diagram.
     * Reset all game properties for a new game.
     */
    override fun newGame() {
        check(!(currentState !== State.GAMEOVER && currentState !== State.INITIALIZED)) { "Cannot run newGame() in state $currentState" }

        // Get a new snake
        snake.newGame()
        // Get a new food, which does not fall on the snake body
        do {
            food.newFood()
        } while (snake.contains(food.x, food.y))
        food.foodEaten = 0
        currentState = State.READY
        repaint()
    }

    /**
     * To start and re-start a new game.
     */
    override fun startGame() {
        check(!(currentState !== State.READY)) { "Cannot run startGame() in state $currentState" }
        // Start the step timer, which fires an event at constant rate.
        stepTimer!!.start()
        currentState = State.PLAYING
        repaint()
    }

    /**
     * To stop the game, e.g., game over.
     */
    override fun stopGame() {
        check(!(currentState !== State.PLAYING)) { "Cannot run stopGame() in state $currentState" }
        stepTimer!!.stop()
        currentState = State.GAMEOVER
        repaint()
    }

    /**
     * Run one step of the game. Fire by the step timer at constant rate.
     */
    fun stepGame() {
        check(!(currentState !== State.PLAYING)) { "Cannot run stepGame() in state $currentState" }

        // Snake runs a step
        snake.grow() // grow the head segment by one cell

        // check if this snake eats the food item
        val headX: Int = snake.headX
        val headY: Int = snake.headY
        if (headX == food?.x && headY == food?.y) {
            // food eaten, regenerate one (which does not fall on the snake body)
            do {
                food.newFood()
            } while (snake.contains(food.x, food.y))
        } else {
            // not eaten, shrink the tail segment by one cell
            snake.shrink()
        }

        // Check if the snake moves out of the pit
        if (!pit!!.contains(headX, headY)) {
            stopGame() // gameover
            return
        }

        // Check if the snake eats itself
        if (snake.eatItself()) {
            stopGame() // gameover
            return
        }
        repaint()
    }

    /**
     * Custom drawing panel for the game pit, written as an inner class.
     *
     */
    private inner class GamePanel : JPanel() {
        /**
         * Override paintComponent() to do custom drawing.
         * Called back via repaint().
         *
         * @param g - The Graphics drawing object
         */
        public override fun paintComponent(g: Graphics) {
            super.paintComponent(g) // paint background
            background = COLOR_PIT // may use an image for background

            // Draw the game objects
            snake.paint(g)
            food.paint(g)

            // Print game data
            g.font = FONT_DATA
            g.color = COLOR_DATA
            g.drawString("Snake Head: (" + snake.headX + "," + snake.headY + ")", 10, 25)
            g.drawString("Snake Length: " + snake.length, 10, 45)
            g.drawString("Food: (" + food.x + "," + food.y + ")", 10, 65)
            g.drawString("Eaten: " + food.foodEaten, 10, 85)

            // READY state
            if (currentState === State.READY) {
                g.font = FONT_INSTRUCTION
                g.color = COLOR_INSTRUCTION
                g.drawString("Push any key to start the game ...", 100, PIT_HEIGHT / 4)
            }

            // GAMEOVER state
            if (currentState === State.GAMEOVER) {
                g.font = FONT_GAMEOVER
                g.color = COLOR_GAMEOVER
                g.drawString("GAME OVER!", 200, PIT_HEIGHT / 2)
                g.font = FONT_INSTRUCTION
                g.drawString("Push any key to start the game ...", 120, PIT_HEIGHT / 2 + 40)
            }
        }

        // Check if this pit contains the given (x, y), for collision detection
        override fun contains(x: Int, y: Int): Boolean {
            if (x < 0 || x >= ROWS) {
                return false
            }
            return !(y < 0 || y >= COLS)
        }
    }

    companion object {
        // == Define named constants for the game ==
        /** Number of rows of the game board (in cells)  */
        const val ROWS = 40

        /** Number of columns of the game board (in cells)  */
        const val COLS = 40

        /** Size of the body cell (in pixels)  */
        const val CELL_SIZE = 15

        /** Width (in pixels) of the game board  */
        const val PIT_WIDTH = COLS * CELL_SIZE

        /** Height (in pixels) of the game board  */
        const val PIT_HEIGHT = ROWS * CELL_SIZE
        val COLOR_PIT = Color.DARK_GRAY
        val COLOR_GAMEOVER = Color.RED
        val FONT_GAMEOVER = Font("Verdana", Font.BOLD, 30)
        val COLOR_INSTRUCTION = Color.RED
        val FONT_INSTRUCTION = Font("Dialog", Font.PLAIN, 26)
        val COLOR_DATA = Color.WHITE
        val FONT_DATA = Font(Font.MONOSPACED, Font.PLAIN, 16)

        /** Number of game steps per second  */
        const val STEPS_PER_SEC = 6

        /** Step in mini-seconds  */
        const val STEP_IN_MSEC = 1000 / STEPS_PER_SEC

    }
}

fun main(args: Array<String>) {
    // Use the event-dispatcher thread to build the UI for thread-safety.
    SwingUtilities.invokeLater {
        val main = GameMain()
        val frame = JFrame("Snake")
        frame.contentPane = main // main JPanel as content pane
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.pack()
        frame.setLocationRelativeTo(null) // center the application window
        frame.isVisible = true // show it
    }
}