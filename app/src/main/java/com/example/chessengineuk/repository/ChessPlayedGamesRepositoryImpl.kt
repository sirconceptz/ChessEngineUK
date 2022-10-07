package com.example.chessengineuk.repository

import com.example.chessengineuk.dao.db.history_game.HistoryGame
import com.example.chessengineuk.model.Player

/**
 * Class to store data about played games. User can return to older games and check his moves. Not implemented.
 */

class ChessPlayedGamesRepositoryImpl : ChessPlayedGamesRepository {
    override fun storeHistoryGame(historyGame: HistoryGame) {
        TODO("Not yet implemented")
    }

    override fun getAllGamesHistory() : List<HistoryGame> {
        TODO("Not yet implemented")
    }

    override fun getTopPlayersRank(): List<Player> {
        TODO("Not yet implemented")
    }
}