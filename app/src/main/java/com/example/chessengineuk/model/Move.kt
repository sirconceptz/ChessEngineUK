package com.example.chessengineuk.model

class Move {
    var player: Player? = null
        get() = field
        set(value) {
            field = value
        }
    var start: Spot? = null
        get() = field
    var end: Spot? = null
        get() = field
    var pieceMoved: Piece? = null
        get() = field
    var pieceKilled: Piece? = null
        get() = field
        set(value) {
            field = value
        }
    var castlingMove = false
        get() = field
        set(value) {
            field = value
        }
}