package io.jonpruessmeier.tictactoe.model


class Gameboard {
    private val board: Array<Array<String>> = arrayOf(
        arrayOf(" ", " ", " "),
        arrayOf(" ", " ", " "),
        arrayOf(" ", " ", " ")
    )

    fun updateBoard(i: Int, j: Int, value: String): Unit{
        board[i][j] = value;

    }

    fun getBoard(): Array<Array<String>>{
        return board;
    }

    /**
     * TODO
     */
    fun checkForWin(): Boolean{
        return true;
    }

}