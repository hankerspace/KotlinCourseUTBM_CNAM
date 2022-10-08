// Créez ici les classes nécessaires à la résolution du programme.
// La classe cell est obligatoire. Si vous souhaitez la surcharger pour ajouter des attributs vous pouvez le faire
open class Cell (var x: Int, var y: Int) {
    override fun toString(): String {
        return "Cell(x=$x, y=$y)"
    }
}

class Board(
    private val cells: List<Cell>,
    private val boardWidth: Int,
    private val boardHeight: Int
    ) {

    /**
     * "For each cell in the grid, count the number of neighbours it has, and if it has 3 neighbours, or 2 neighbours and is alive, add it to the next generation."
     *
     * The first thing we do is create a mutable list of cells to hold the next generation. We then loop over every cell in the grid, and for each cell we count the number of neighbours it has. We then
     * check if the cell has 3 neighbours, or 2 neighbours and is alive, and if so, we add it to the next generation
     *
     * @return A list of cells that are alive in the next generation.
     */
    fun computeNextGeneration(): List<Cell> {
        val nextGeneration = mutableListOf<Cell>()
        for (x in 0..boardWidth) {
            for (y in 0..boardHeight) {
                val cell = Cell(x, y)
                val neighbours = countAliveNeighbours(cell)
                val livingCell = isCellAlive(cell)
                if (neighbours == 3 || (neighbours == 2 && livingCell)) {
                    nextGeneration.add(cell)
                }
            }
        }
        return nextGeneration
    }

    /**
     * For each cell in the grid, count the number of neighbours it has
     *
     * @param cell The cell we're checking the neighbours of.
     * @return The number of neighbours of a cell.
     */
    private fun countAliveNeighbours(cell: Cell): Int {
        var count = 0
        for (x in cell.x - 1..cell.x + 1) {
            for (y in cell.y - 1..cell.y + 1) {
                if (x != cell.x || y != cell.y) {
                    if (isCellAlive(Cell(x, y))) {
                        count++
                    }
                }
            }
        }
        return count
    }

    private fun isCellAlive(cell: Cell): Boolean {
        // Check if cell with same x and same y exists
        for(c in cells) {
            if (c.x == cell.x && c.y == cell.y) {
                return true
            }
        }
        return false
    }
}

val computeFunction = fun (cells : List<Cell>, boardWidth: Int, boardHeight: Int) : List<Cell> {
    // Cette fonction permet de calculer la génération suivante
    // à partir d'une liste de cellules
    // vous devez renvoyer les cellules qui doivent être vivantes dans la génération suivante
    return Board(cells, boardWidth, boardHeight).computeNextGeneration()
}

fun main(args: Array<String>) {
    // Test du programme
    val gameOfLife = GameOfLife(computeFunction)
    gameOfLife.startGame()
}
