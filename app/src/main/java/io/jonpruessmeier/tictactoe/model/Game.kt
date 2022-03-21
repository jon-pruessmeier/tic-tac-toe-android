package io.jonpruessmeier.tictactoe.model

import android.app.Application

class Game (one: String, two: String){
    private var gameboard: Gameboard = Gameboard();
    private var playerOne: String = one;
    private var playerTwo: String = two;
    private var round: Int = 0;

    fun updateGameboard(gameboard: Gameboard) {
        this.gameboard = gameboard;
    }

    fun getGameboard(): Gameboard{
        return this.gameboard;
    }

    fun updateRound(): Unit{
        this.round++;
    }

    fun getRound(): Int{
        return this.round
    }

    fun setPlayers(one: String, two: String){
        this.playerOne = one;
        this.playerTwo = two;
    }

    fun getPlayers(): Array<String>{
        return arrayOf(playerOne, playerTwo);
    }



}