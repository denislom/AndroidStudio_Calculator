package com.dlom.calculator.history

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HistoryEntity (
    val value: Float,

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
)
