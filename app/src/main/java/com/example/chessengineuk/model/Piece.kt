package com.example.chessengineuk.model

open class Piece(var white: Boolean) {
    var killed = false
        get() = field
        set(value) {
            field = value
        }
    open fun canMove(board: Board?, start: Spot?, end: Spot?): Boolean {
        return true //todo: to implement
    }
}