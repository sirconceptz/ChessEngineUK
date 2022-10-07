package com.example.chessengineuk.model

import com.example.chessengineuk.interfaces.SingleGame

/**
 * Class to play a games. We keeping data about players, game status, whose turn is now and game board.
 * We
 */

class Game() : SingleGame {
    var players: Array<Player> = emptyArray()
    val board = Board()
    var currentTurn: Player? = null
    var status: GameStatus = GameStatus.NEW
    var movesPlayed: MutableList<Move> = mutableListOf()

    override fun startGame() {
        board.resetBoard()
        setCurrentTurn()
        setGameStatus()
    }

    private fun setGameStatus() {
        if(currentTurn != null)
            status = GameStatus.ACTIVE
    }

    private fun setCurrentTurn() {
        val player1 = players.get(0)
        val player2 = players.get(1)

        if(player1.whiteSide)
            currentTurn = player1
        else
            currentTurn = player2
    }

    override fun makeMove(move: Move, player: Player) : Boolean {
        val sourcePiece = move.pieceMoved ?: return false

        if (player != currentTurn)
            return false

        if (sourcePiece.white != player.whiteSide)
            return false

        if (!sourcePiece.canMove(board, move.start, move.end)) {
            status = GameStatus.STALEMATE  // GAME OVER
            return false
        }

        val destPiece: Piece? = move.start?.piece

        if (destPiece != null) {
            destPiece.killed = true
            move.pieceKilled = destPiece
        }

        if (sourcePiece is King && sourcePiece.isCastlingMove(move.start, move.end)) {
            move.castlingMove = true
        }

        if(move.castlingMove && player.whiteSide)
            status = GameStatus.WHITE_WIN
        else if(move.castlingMove && player.whiteSide)
            status = GameStatus.BLACK_WIN

        movesPlayed.add(move)
        return true
    }

    override fun getGameStatus() : GameStatus {
        return status
    }

    override fun setGamePlayers(playerArray: Array<Player>) : Boolean {
        if(status == GameStatus.NEW) {
            players = playerArray
            return true
        }
        return false
    }
}