import java.awt.BasicStroke
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.util.*
import javax.swing.JComponent

class MainComponent(rods: Rods) : JComponent() {
    //Instance Variabless
    private var rods: Rods

    /**
     * The constructor, it takes a Rods object as an input.
     * @param rods A Rods object containing the necessary data for the GUI.
     */
    init {
        this.rods = rods
    }

    /**
     * Updates the graphics.
     */
    fun update() {
        removeAll()
        revalidate()
        repaint()
    }

    /**
     * Updates the graphics according to the new Rods object given as an input.
     * @param newRods The new Rods object given as an input.
     */
    fun updateRods(newRods: Rods) {
        rods = newRods
        removeAll()
        revalidate()
        repaint()
    }

    /**
     * The method that paints the component using a Graphics object.
     * @param g The graphics object.
     */
    public override fun paintComponent(g: Graphics) {
        paintRods(g)
        val rodArray: Array<Rod> = rods.rodArray
        for (i in rodArray.indices) {
            val disksOnTop: Stack<Disk> = rodArray[i].disksOnTop
            for (j in disksOnTop.indices) {
                paintDisk(disksOnTop[j], i, 1 + j, g)
            }
        }
        g.color = Color.GRAY
        g.drawString("start", X_START + SIDE_GAP - STRING_ADJUST / 2, Y_END + STRING_ADJUST)
        g.drawString("spare", X_START + SIDE_GAP + ROD_GAP - STRING_ADJUST / 2, Y_END + STRING_ADJUST)
        g.drawString("destination", X_END - SIDE_GAP - STRING_ADJUST, Y_END + STRING_ADJUST)
    }

    /**
     * The method that paints the rods and the platform using the Graphics object.
     * @param g The graphics object.
     */
    private fun paintRods(g: Graphics) {
        val g2D = g as Graphics2D
        g2D.stroke = BasicStroke(THICKNESS.toFloat())
        g.setColor(Color.DARK_GRAY)

        //Draw the platform
        g.drawLine(X_START, Y_END, X_END, Y_END)
        //Draw the rods
        g.drawLine(X_START + SIDE_GAP, Y_END - ROD_LENGTH, X_START + SIDE_GAP, Y_END)
        g.drawLine(X_START + SIDE_GAP + ROD_GAP, Y_END - ROD_LENGTH, X_START + SIDE_GAP + ROD_GAP, Y_END)
        g.drawLine(X_END - SIDE_GAP, Y_END - ROD_LENGTH, X_END - SIDE_GAP, Y_END)
    }

    /**
     * The method that paints a disk on the specified rod and the specified order.
     * @param toDraw The Disk object that will be drawn.
     * @param rodNumber The specific rod that the Disk will be painted on.
     * @param order The order of the Disk on the specified rod.
     * @param g The graphics object.
     */
    private fun paintDisk(toDraw: Disk, rodNumber: Int, order: Int, g: Graphics) {
        val diskSize: Int = toDraw.size
        val g2D = g as Graphics2D
        g2D.stroke = BasicStroke((THICKNESS - 1).toFloat())
        g.setColor(Color.BLACK)
        g.drawOval(
            X_START + SIDE_GAP + ROD_GAP * rodNumber - diskSize * DISK_THICKNESS / 2,
            Y_END - DISK_THICKNESS * order, diskSize * DISK_THICKNESS, DISK_THICKNESS
        )
        g.setColor(COLOR_ARRAY[COLOR_ARRAY.size - diskSize])
        g.fillOval(
            X_START + SIDE_GAP + ROD_GAP * rodNumber - diskSize * DISK_THICKNESS / 2,
            Y_END - DISK_THICKNESS * order, diskSize * DISK_THICKNESS, DISK_THICKNESS
        )
    }

    companion object {
        //Constants
        private val COLOR_ARRAY = arrayOf(Color.BLUE, Color.CYAN, Color.YELLOW, Color.GREEN, Color.ORANGE, Color.RED)
        private const val X_START = 50
        private const val X_END = 500
        private const val Y_END = 300
        private const val ROD_LENGTH = 200
        private const val ROD_GAP = 150
        private const val SIDE_GAP = 75
        private const val THICKNESS = 3
        private const val STRING_ADJUST = 30
        const val DISK_THICKNESS = 18
        
    }
}