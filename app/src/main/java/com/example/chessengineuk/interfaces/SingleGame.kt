package com.example.chessengineuk.interfaces

import com.example.chessengineuk.model.GameStatus
import com.example.chessengineuk.model.Move
import com.example.chessengineuk.model.Player

interface SingleGame {
    fun startGame()

    fun makeMove(move: Move, player: Player) : Boolean

    fun getGameStatus() : GameStatus

    fun setGamePlayers(playerArray: Array<Player>) : Boolean
}