package com.example.chessengineuk.model

abstract class Piece(var white: Boolean) {
    var killed = false
        get() = field
        set(value) {
            field = value
        }

    abstract fun canMove(board: Board?, start: Spot?, end: Spot?): Boolean
}