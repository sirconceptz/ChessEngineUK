package com.example.chessengineuk.model

class HumanPlayer(whiteSide: Boolean) : Player() {
    init {
        this.whiteSide = whiteSide
        humanPlayer = true
    }
}