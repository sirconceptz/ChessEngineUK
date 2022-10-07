package com.example.chessengineuk.dao.db.history_game

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HistoryGame::class], version = 1)
abstract class HistoryGameDb : RoomDatabase()  {
    abstract fun gameDao(): HistoryGameDao
}