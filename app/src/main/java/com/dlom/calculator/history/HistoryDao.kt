package com.dlom.calculator.history

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Insert
    suspend fun add(vararg entity: HistoryEntity)

    @Query("SELECT * from historyentity")
    fun getAll(): Flow<List<HistoryEntity>>
}