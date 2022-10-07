package com.example.chessengineuk.model

class Knight(white: Boolean) : Piece(white) {
    var castlingDone = false

    override fun canMove(board: Board?, start: Spot?, end: Spot?): Boolean {
        TODO("Not yet implemented")
    }
}