package com.example.chessengineuk.dao.db.history_game

import androidx.room.PrimaryKey
import com.example.chessengineuk.model.Board
import com.example.chessengineuk.model.GameStatus
import com.example.chessengineuk.model.Move
import com.example.chessengineuk.model.Player

class HistoryGame {
    @PrimaryKey(autoGenerate = true)
    var id = 0
    var players: Array<Player> = emptyArray()
    val board = Board()
    val currentTurn: Player? = null
    val status: GameStatus? = null
    var movesPlayed: MutableList<Move> = mutableListOf()
    lateinit var timestamp: String
}