import java.awt.*
import java.awt.event.*
import java.net.URI
import javax.swing.*

/**
 * Conway's game of life is a cellular automaton devised by the
 * mathematician John Conway.
 */
class GameOfLife(computeFunction: (List<Cell>, Int, Int) -> List<Cell>) : JFrame(), ActionListener {
    private val DEFAULT_WINDOW_SIZE = Dimension(800, 600)
    private val MINIMUM_WINDOW_SIZE = Dimension(400, 400)
    private val BLOCK_SIZE = 10

    private val mb_menu: JMenuBar
    private val m_file: JMenu
    private val m_game: JMenu
    private val m_help: JMenu
    private val mi_file_options: JMenuItem
    private val mi_file_exit: JMenuItem
    private val mi_game_autofill: JMenuItem
    private val mi_game_play: JMenuItem
    private val mi_game_stop: JMenuItem
    private val mi_game_reset: JMenuItem
    private val mi_help_about: JMenuItem
    private val mi_help_source: JMenuItem
    private var i_movesPerSecond = 3
    private val gb_gameBoard: GameBoard
    private var game: Thread? = null

    init {
        // Setup menu
        mb_menu = JMenuBar()
        jMenuBar = mb_menu
        m_file = JMenu("File")
        mb_menu.add(m_file)
        m_game = JMenu("Game")
        mb_menu.add(m_game)
        m_help = JMenu("Help")
        mb_menu.add(m_help)
        mi_file_options = JMenuItem("Options")
        mi_file_options.addActionListener(this)
        mi_file_exit = JMenuItem("Exit")
        mi_file_exit.addActionListener(this)
        m_file.add(mi_file_options)
        m_file.add(JSeparator())
        m_file.add(mi_file_exit)
        mi_game_autofill = JMenuItem("Autofill")
        mi_game_autofill.addActionListener(this)
        mi_game_play = JMenuItem("Play")
        mi_game_play.addActionListener(this)
        mi_game_stop = JMenuItem("Stop")
        mi_game_stop.isEnabled = false
        mi_game_stop.addActionListener(this)
        mi_game_reset = JMenuItem("Reset")
        mi_game_reset.addActionListener(this)
        m_game.add(mi_game_autofill)
        m_game.add(JSeparator())
        m_game.add(mi_game_play)
        m_game.add(mi_game_stop)
        m_game.add(mi_game_reset)
        mi_help_about = JMenuItem("About")
        mi_help_about.addActionListener(this)
        mi_help_source = JMenuItem("Source")
        mi_help_source.addActionListener(this)
        m_help.add(mi_help_about)
        m_help.add(mi_help_source)
        // Setup game board
        gb_gameBoard = GameBoard(computeFunction)
        add(gb_gameBoard)
    }

    fun setGameBeingPlayed(isBeingPlayed: Boolean) {
        if (isBeingPlayed) {
            mi_game_play.isEnabled = false
            mi_game_stop.isEnabled = true
            game = Thread(gb_gameBoard)
            game!!.start()
        } else {
            mi_game_play.isEnabled = true
            mi_game_stop.isEnabled = false
            game!!.interrupt()
        }
    }

    override fun actionPerformed(ae: ActionEvent) {
        if (ae.source == mi_file_exit) {
            // Exit the game
            System.exit(0)
        } else if (ae.source == mi_file_options) {
            // Put up an options panel to change the number of moves per second
            val f_options = JFrame()
            f_options.title = "Options"
            f_options.setSize(300, 60)
            f_options.setLocation(
                (Toolkit.getDefaultToolkit().screenSize.width - f_options.width) / 2,
                (Toolkit.getDefaultToolkit().screenSize.height - f_options.height) / 2
            )
            f_options.isResizable = false
            val p_options = JPanel()
            p_options.isOpaque = false
            f_options.add(p_options)
            p_options.add(JLabel("Number of moves per second:"))
            val secondOptions = arrayOf<Int?>(1, 2, 3, 4, 5, 10, 15, 20)
            val cb_seconds: JComboBox<*> = JComboBox<Any?>(secondOptions)
            p_options.add(cb_seconds)
            cb_seconds.selectedItem = i_movesPerSecond
            cb_seconds.addActionListener {
                i_movesPerSecond = cb_seconds.selectedItem as Int
                f_options.dispose()
            }
            f_options.isVisible = true
        } else if (ae.source == mi_game_autofill) {
            val f_autoFill = JFrame()
            f_autoFill.title = "Autofill"
            f_autoFill.setSize(360, 60)
            f_autoFill.setLocation(
                (Toolkit.getDefaultToolkit().screenSize.width - f_autoFill.width) / 2,
                (Toolkit.getDefaultToolkit().screenSize.height - f_autoFill.height) / 2
            )
            f_autoFill.isResizable = false
            val p_autoFill = JPanel()
            p_autoFill.isOpaque = false
            f_autoFill.add(p_autoFill)
            p_autoFill.add(JLabel("What percentage should be filled? "))
            val percentageOptions = arrayOf<Any?>("Select", 5, 10, 15, 20, 25, 30, 40, 50, 60, 70, 80, 90, 95)
            val cb_percent: JComboBox<*> = JComboBox(percentageOptions)
            p_autoFill.add(cb_percent)
            cb_percent.addActionListener {
                if (cb_percent.selectedIndex > 0) {
                    gb_gameBoard.resetBoard()
                    gb_gameBoard.randomlyFillBoard(cb_percent.selectedItem as Int)
                    f_autoFill.dispose()
                }
            }
            f_autoFill.isVisible = true
        } else if (ae.source == mi_game_reset) {
            gb_gameBoard.resetBoard()
            gb_gameBoard.repaint()
        } else if (ae.source == mi_game_play) {
            setGameBeingPlayed(true)
        } else if (ae.source == mi_game_stop) {
            setGameBeingPlayed(false)
        } else if (ae.source == mi_help_source) {
            val desktop = if (Desktop.isDesktopSupported()) Desktop.getDesktop() else null
            try {
                desktop!!.browse(URI("https://github.com/Burke9077/Conway-s-Game-of-Life"))
            } catch (ex: Exception) {
                JOptionPane.showMessageDialog(null, "Source is available on GitHub at:\nhttps://github.com/Burke9077/Conway-s-Game-of-Life", "Source", JOptionPane.INFORMATION_MESSAGE)
            }
        } else if (ae.source == mi_help_about) {
            JOptionPane.showMessageDialog(
                null,
                "Conway's game of life was a cellular animation devised by the mathematician John Conway.\nThis Java, swing based implementation was created by Matthew Burke.\n\nhttp://burke9077.com\nBurke9077@gmail.com\n@burke9077\n\nCreative Commons Attribution 4.0 International"
            )
        }
    }

    private inner class GameBoard(computeFunction: (List<Cell>, Int, Int) -> List<Cell>) : JPanel(), ComponentListener, MouseListener, MouseMotionListener, Runnable {
        private var d_gameBoardSize: Dimension? = null
        private val point = ArrayList<Point>(0)

        init {
            // Add resizing listener
            addComponentListener(this)
            addMouseListener(this)
            addMouseMotionListener(this)
        }

        private fun updateArraySize() {
            val removeList = ArrayList<Point>(0)
            for (current in point) {
                if (current.x > d_gameBoardSize!!.width - 1 || (current.y > d_gameBoardSize!!.height - 1)) {
                    removeList.add(current)
                }
            }
            point.removeAll(removeList)
            repaint()
        }

        fun addPoint(x: Int, y: Int) {
            if (!point.contains(Point(x, y))) {
                point.add(Point(x, y))
            }
            repaint()
        }

        fun addPoint(me: MouseEvent) {
            val x = me.point.x / BLOCK_SIZE - 1
            val y = me.point.y / BLOCK_SIZE - 1
            if (x >= 0 && x < d_gameBoardSize!!.width && y >= 0 && y < d_gameBoardSize!!.height) {
                addPoint(x, y)
            }
        }

        fun removePoint(x: Int, y: Int) {
            point.remove(Point(x, y))
        }

        fun resetBoard() {
            point.clear()
        }

        fun randomlyFillBoard(percent: Int) {
            for (i in 0 until d_gameBoardSize!!.width) {
                for (j in 0 until d_gameBoardSize!!.height) {
                    if (Math.random() * 100 < percent) {
                        addPoint(i, j)
                    }
                }
            }
        }

        public override fun paintComponent(g: Graphics) {
            super.paintComponent(g)
            try {
                for (newPoint in point) {
                    // Draw new point
                    g.color = Color.blue
                    g.fillRect(
                        BLOCK_SIZE + BLOCK_SIZE * newPoint.x,
                        BLOCK_SIZE + BLOCK_SIZE * newPoint.y, BLOCK_SIZE, BLOCK_SIZE
                    )
                }
            } catch (cme: ConcurrentModificationException) {
            }
            // Setup grid
            g.color = Color.BLACK
            for (i in 0..d_gameBoardSize!!.width) {
                g.drawLine(
                    i * BLOCK_SIZE + BLOCK_SIZE, BLOCK_SIZE, i * BLOCK_SIZE + BLOCK_SIZE,
                    BLOCK_SIZE + BLOCK_SIZE * d_gameBoardSize!!.height
                )
            }
            for (i in 0..d_gameBoardSize!!.height) {
                g.drawLine(
                    BLOCK_SIZE,
                    i * BLOCK_SIZE + BLOCK_SIZE, BLOCK_SIZE * (d_gameBoardSize!!.width + 1), i * BLOCK_SIZE + BLOCK_SIZE
                )
            }
        }

        override fun componentResized(e: ComponentEvent) {
            // Setup the game board size with proper boundries
            d_gameBoardSize = Dimension(width / BLOCK_SIZE - 2, height / BLOCK_SIZE - 2)
            updateArraySize()
        }

        override fun componentMoved(e: ComponentEvent) {}
        override fun componentShown(e: ComponentEvent) {}
        override fun componentHidden(e: ComponentEvent) {}
        override fun mouseClicked(e: MouseEvent) {}
        override fun mousePressed(e: MouseEvent) {}
        override fun mouseReleased(e: MouseEvent) {
            // Mouse was released (user clicked)
            addPoint(e)
        }

        override fun mouseEntered(e: MouseEvent) {}
        override fun mouseExited(e: MouseEvent) {}
        override fun mouseDragged(e: MouseEvent) {
            // Mouse is being dragged, user wants multiple selections
            addPoint(e)
        }

        override fun mouseMoved(e: MouseEvent) {}
        override fun run() {
            try
            {
                val survivingCells = computeFunction(point.map { Cell(it.x, it.y) }, this.width, this.height).map { Point(it.x, it.y) }
                resetBoard()
                point.addAll(survivingCells)
                repaint()
            } catch (e: java.lang.Exception) {
                println("Erreur pendant le calcul de la génération suivante : " + e.message)
                e.printStackTrace()
            }

            try {
                Thread.sleep((1000 / i_movesPerSecond).toLong())
                run()
            } catch (ex: InterruptedException) {
            }
        }
    }

    fun startGame() {
        // Setup the swing specifics
        this.defaultCloseOperation = EXIT_ON_CLOSE
        this.title = "Conway's Game of Life"
        this.size = DEFAULT_WINDOW_SIZE
        this.minimumSize = MINIMUM_WINDOW_SIZE
        this.setLocation(
            (Toolkit.getDefaultToolkit().screenSize.width - this.width) / 2,
            (Toolkit.getDefaultToolkit().screenSize.height - this.height) / 2
        )
        this.isVisible = true
    }

    fun getBoardWidth(): Int {
        return gb_gameBoard.width
    }

    fun getBoardHeight() : Int{
        return gb_gameBoard.height
    }

}