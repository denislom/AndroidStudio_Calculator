package com.dlom.calculator.history

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room

class HistoryViewModel(app: Application) : AndroidViewModel(app) {
    val db = Room.databaseBuilder(
        app,
        HistoryDatabase::class.java,
        "history"
    ).build().historyDao
}