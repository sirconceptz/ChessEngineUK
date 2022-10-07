package com.example.chessengineuk.model

class King(white: Boolean) : Piece(white) {
    var castlingDone = false

    override fun canMove(board: Board?, start: Spot?, end: Spot?): Boolean {
        TODO("Not yet implemented")
    }

    fun isCastlingMove(start: Spot?, end: Spot?): Boolean {
        // check if the starting and
        // ending position are correct
        return true;
    }
}