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


    fun checkForWin(): Boolean{
        return (checkRows() || checkColumns() || checkDiagonals());
    }


    //returns true if a row has 3
    private fun checkRows(): Boolean{
        var win = false;
        for (row in board){

            //if the row does not contain empty spaces:
            if (row[0] == "X" || row[0] == "O"){
                //if all Strings in the row are the same:
                if (row[0] == row[1] && row[1] == row[2]){
                    win = true;
                }
            }

        }
        return win;
    }

    private fun checkColumns(): Boolean{
        var win = false;
        for (i in board.indices){
            //if the column does not contain empty spaces:
            if (board[0][i] == "X" || board[0][i] == "O"){
                //if all the Strings in the column are the same:
                if (board[0][i] == board[1][i] && board[1][i] == board[2][i]){
                    win = true;
                }
            }
        }
        return win;
    }

    private fun checkDiagonals(): Boolean{
        var win = false;

        var firstDiagonal: Boolean = (board[0][0] == board[1][1] && board[1][1] == board[2][2]) &&
                (board[0][0] == "X" || board[0][0] == "O")
        var secondDiagonal: Boolean = (board[0][2] == board[1][1] && board[1][1] == board[2][0]) &&
                (board[2][0] == "X" || (board[2][0] == "O"))

        win = (firstDiagonal || secondDiagonal);
        return win;
    }

}