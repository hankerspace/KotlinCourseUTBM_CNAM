import kotlin.system.exitProcess

enum class GameState {
    INTRO_SCREEN, GAME_SCREEN, HELP_SCREEN
}

class GameBoard(private var board: Array<Char> = Array(9, { ' '})) {

    fun printBoard() {
        println(" ${board[0]} | ${board[1]} | ${board[2]} ")
        println("---+---+---")
        println(" ${board[3]} | ${board[4]} | ${board[5]} ")
        println("---+---+---")
        println(" ${board[6]} | ${board[7]} | ${board[8]} ")
    }

    fun getPieceAtPosition(position: Int): Char {
        return board[position]
    }

    fun setPiece(currentPlayer: Char, position: Int) {
        board[position] = currentPlayer
    }

    fun isBoardFull(): Boolean {
        return board.all { it != ' ' }
    }

    fun checkWinConditions(currentPlayer: Char): Boolean {
        return (board[0] == currentPlayer && board[1] == currentPlayer && board[2] == currentPlayer) ||
                (board[3] == currentPlayer && board[4] == currentPlayer && board[5] == currentPlayer) ||
                (board[6] == currentPlayer && board[7] == currentPlayer && board[8] == currentPlayer) ||
                (board[0] == currentPlayer && board[3] == currentPlayer && board[6] == currentPlayer) ||
                (board[1] == currentPlayer && board[4] == currentPlayer && board[7] == currentPlayer) ||
                (board[2] == currentPlayer && board[5] == currentPlayer && board[8] == currentPlayer) ||
                (board[0] == currentPlayer && board[4] == currentPlayer && board[8] == currentPlayer) ||
                (board[2] == currentPlayer && board[4] == currentPlayer && board[6] == currentPlayer)
    }
}

class Game {
    private var gameBoard = GameBoard()
    private var gameState = GameState.INTRO_SCREEN
    private var currentPlayer = 'X'

    init {
        openIntroScreen()
    }

    private fun openIntroScreen() {
        gameState = GameState.INTRO_SCREEN
        println("Welcome to a game of Tic Tac Toe!")
        println("*	Enter 1 to start the game")
        println("*	Enter 2 to see the help page")
        println("*	Enter 0 to quit the game")
        print("Please enter your choice: ")
        handleInput(readLine()?.toIntOrNull())
    }

    private fun startGame() {
        gameState = GameState.GAME_SCREEN
        newTurn()

    }

    private fun newTurn() {
        println("You are playing as $currentPlayer")
        print("Please enter your first move [1-9] or 0 to quit: ")
        handleInput(readLine()?.toIntOrNull())
    }

    private fun handleInput(input: Int?) {
        if (input == null) {
            handleInvalidInput()
            return
        }
        when(gameState) {
            GameState.INTRO_SCREEN -> handleIntroScreenInput(input)
            GameState.GAME_SCREEN -> handleGameInput(input)
            GameState.HELP_SCREEN -> handleHelpScreenInput(input)
        }
    }

    private fun handleIntroScreenInput(input: Int) {
        when (input) {
            1 -> startGame()
            2 -> openHelpPage()
            0 -> exitGame()
            else -> handleInvalidInput()
        }
    }

    private fun handleGameInput(input: Int) {
        when (input) {
            in 1..9 -> updateGameBoard(input - 1)
            0 -> exitGame()
            else -> handleInvalidInput()
        }
    }


    private fun updateGameBoard(position: Int) {
        if (gameBoard.getPieceAtPosition(position) == ' ') {
            gameBoard.setPiece(currentPlayer, position)
            gameBoard.printBoard()
            if (gameBoard.checkWinConditions(currentPlayer)) {
                println("The winner is $currentPlayer!\n")
                exitGame()
            }
            else if(gameBoard.isBoardFull()) {
                println("It's a tie!\n")
                exitGame()
            }
            else {
                changePlayer()
                newTurn()
            }
        } else {
            handleInvalidInput()
        }
    }

    private fun changePlayer() {
        currentPlayer = when (currentPlayer) {
            'X' -> 'O'
            else -> 'X'
        }
    }

    private fun openHelpPage() {
        gameState = GameState.HELP_SCREEN
        println("Players will alternate turns placing your pieces in one of the 9 cells.")
        println("The cell position is listed as such:")
        println(" 1 | 2 | 3 ")
        println("---+---+---")
        println(" 4 | 5 | 6 ")
        println("---+---+---")
        println(" 7 | 8 | 9 ")
        print("Press 1 to go back to the Intro Screen or 0 to exit the game")
        handleInput(readLine()?.toIntOrNull())
    }

    private fun handleHelpScreenInput(input: Int) {
        when (input) {
            1 -> openIntroScreen()
            0 -> exitGame()
            else -> handleInvalidInput()
        }
    }


    private fun handleInvalidInput() {
        println("invalid Input")
        handleInput(readLine()?.toIntOrNull())
    }

    private fun exitGame() {
        println("Thanks for playing!")
        exitProcess(0)
    }

    fun draw() {
        gameBoard.printBoard()
    }
}

fun main(args: Array<String>) {
    val game = Game()
    game.draw()
}