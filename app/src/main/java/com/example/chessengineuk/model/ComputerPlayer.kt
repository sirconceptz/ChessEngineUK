package com.example.chessengineuk.model

class ComputerPlayer(whiteSide: Boolean) : Player() {
    init {
        this.whiteSide = whiteSide
        humanPlayer = false
    }
}