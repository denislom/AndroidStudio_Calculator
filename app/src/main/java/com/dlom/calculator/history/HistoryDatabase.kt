package com.dlom.calculator.history

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HistoryEntity::class], version = 1)
abstract class HistoryDatabase : RoomDatabase() {
    abstract val historyDao: HistoryDao
}
