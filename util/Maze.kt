//
//import java.io.File
//import java.util.*
//
//typealias Maze = List<CharArray>
//
///**
// * Makes the maze half as wide (i. e. "+---+" becomes "+-+"), so that
// * each cell in the maze is the same size horizontally as vertically.
// * (Versus the expanded version, which looks better visually.)
// * Also, converts each line of the maze from a String to a
// * char[], because we'll want mutability when drawing the solution later.
// */
//fun decimateHorizontally(lines: List<String>): Maze {
//    val width = (lines[0].length + 1) / 2
//    val c = List(lines.size) { CharArray(width) }
//    for (i in 0 until lines.size) {
//        for (j in 0 until width) c[i][j] = lines[i][j * 2]
//    }
//    return c
//}
//
///**
// * Given the maze, the x and y coordinates (which must be odd),
// * and the direction we came from, return true if the maze is
// * solvable, and draw the solution if so.
// */
//fun solveMazeRecursively(maze: Maze, x: Int, y: Int, d: Int): Boolean {
//    var ok = false
//    var i = 0
//    while (i < 4 && !ok) {
//        if (i != d) {
//            // 0 = up, 1 = right, 2 = down, 3 = left
//            when(i) {
//                0 -> if (maze[y - 1][x] == ' ') ok = solveMazeRecursively (maze, x, y - 2, 2)
//                1 -> if (maze[y][x + 1] == ' ') ok = solveMazeRecursively (maze, x + 2, y, 3)
//                2 -> if (maze[y + 1][x] == ' ') ok = solveMazeRecursively (maze, x, y + 2, 0)
//                3 -> if (maze[y][x - 1] == ' ') ok = solveMazeRecursively (maze, x - 2, y, 1)
//                else -> {}
//            }
//        }
//        i++
//    }
//
//    // check for end condition
//    if (x == 1 && y == 1) ok = true
//
//    // once we have found a solution, draw it as we unwind the recursion
//    if (ok) {
//        maze[y][x] = '*'
//        when (d) {
//            0 -> maze[y - 1][x] = '*'
//            1 -> maze[y][x + 1] = '*'
//            2 -> maze[y + 1][x] = '*'
//            3 -> maze[y][x - 1] = '*'
//            else -> {}
//        }
//    }
//    return ok
//}
//
///**
// * Solve the maze and draw the solution. For simplicity,
// * assumes the starting point is the lower right, and the
// * ending point is the upper left.
// */
//fun solveMaze(maze: Maze) =
//    solveMazeRecursively(maze, maze[0].size - 2, maze.size - 2, -1)
//
///**
// * Opposite of decimateHorizontally(). Adds extra characters to make
// * the maze "look right", and converts each line from char[] to
// * String at the same time.
// */
//fun expandHorizontally(maze: Maze): Array<String> {
//    val tmp = CharArray(3)
//    val lines = Array<String>(maze.size) { "" }
//    for (i in 0 until maze.size) {
//        val sb = StringBuilder(maze[i].size * 2)
//        for (j in 0 until maze[i].size) {
//            if (j % 2 == 0)
//                sb.append(maze[i][j])
//            else {
//                for (k in 0..2) tmp[k] = maze[i][j]
//                if (tmp[1] == '*') {
//                    tmp[0] = ' '
//                    tmp[2] = ' '
//                }
//                sb.append(tmp)
//            }
//        }
//        lines[i] = sb.toString()
//    }
//    return lines
//}
//
//class MazeGenerator(val x: Int, val y: Int) {
//    private val maze = Array(x) { IntArray(y) }
//
//    fun generate(cx: Int, cy: Int) {
//        Direction.values().shuffle().forEach {
//            val nx = cx + it.dx
//            val ny = cy + it.dy
//            if (between(nx, x) && between(ny, y) && maze[nx][ny] == 0) {
//                maze[cx][cy] = maze[cx][cy] or it.bit
//                maze[nx][ny] = maze[nx][ny] or it.opposite!!.bit
//                generate(nx, ny)
//            }
//        }
//    }
//
//    fun getMazeString(): String {
//        val sb = StringBuilder()
//        for (i in 0..y - 1) {
//            // draw the north edge
//            for (j in 0..x - 1)
//                sb.append(if (maze[j][i] and 1 == 0) "+---" else "+   ")
//            sb.append("+\n")
//
//            // draw the west edge
//            for (j in 0..x - 1)
//                sb.append(if (maze[j][i] and 8 == 0) "|   " else "    ")
//            sb.append("|\n")
//        }
//
//        // draw the bottom line
//        for (j in 0..x - 1) sb.append("+---")
//        sb.append("+")
//        return sb.toString()
//    }
//
//    inline private fun <reified T> Array<T>.shuffle(): Array<T> {
//        val list = toMutableList()
//        Collections.shuffle(list)
//        return list.toTypedArray()
//    }
//
//    private enum class Direction(val bit: Int, val dx: Int, val dy: Int) {
//        N(1, 0, -1), S(2, 0, 1), E(4, 1, 0),W(8, -1, 0);
//
//        var opposite: Direction? = null
//
//        companion object {
//            init {
//                N.opposite = S
//                S.opposite = N
//                E.opposite = W
//                W.opposite = E
//            }
//        }
//    }
//
//    private fun between(v: Int, upper: Int) = v >= 0 && v < upper
//}
//
//
///**
// * Accepts a maze as generated by:
// * http://rosettacode.org/wiki/Maze_generation#Kotlin
// * in a file whose name is specified as a command-line argument.
// */
//fun main(args: Array<String>) {
//    val x = if (args.size >= 1) args[0].toInt() else 8
//    val y = if (args.size == 2) args[1].toInt() else 8
//    val mazeStr = with(MazeGenerator(x, y)) {
//        generate(0, 0)
//        getMazeString()
//    }
//
//    println(mazeStr)
//
//    val lines = mazeStr.lines()
//    val maze = decimateHorizontally(lines)
//    solveMaze(maze)
//    val solvedLines = expandHorizontally(maze)
//    println(solvedLines.joinToString("\n"))
//}