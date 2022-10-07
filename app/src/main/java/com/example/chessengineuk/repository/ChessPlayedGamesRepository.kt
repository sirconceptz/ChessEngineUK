package com.example.chessengineuk.repository

import com.example.chessengineuk.dao.db.history_game.HistoryGame
import com.example.chessengineuk.model.Player

interface ChessPlayedGamesRepository {
    fun storeHistoryGame(historyGame: HistoryGame)

    fun getAllGamesHistory() : List<HistoryGame>

    fun getTopPlayersRank() : List<Player>
}