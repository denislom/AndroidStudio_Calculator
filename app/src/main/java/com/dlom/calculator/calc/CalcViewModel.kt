package com.dlom.calculator.calc

import android.app.Application
import android.util.Log
import androidx.annotation.IdRes
import androidx.core.content.edit
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.preference.PreferenceManager
import com.dlom.calculator.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.concurrent.thread
import kotlin.time.Duration.Companion.seconds

class CalcViewModel(app: Application) : AndroidViewModel(app) {
    private val _res = MutableStateFlow<Float?>(null)
    val res: StateFlow<Float?> = _res

    private val prefs = PreferenceManager.getDefaultSharedPreferences(getApplication())

    val ans: Float get() = prefs.getFloat(ANS_KEY, Float.NaN)

    fun calc(a: Float, b: Float, @IdRes op: Int) {
        Log.d(TAG, "Calc!")

        thread {
//            Thread.sleep(2.seconds.inWholeMilliseconds)
            _res.value = when (op) {
                R.id.add -> a + b
                R.id.sub -> a - b
                R.id.mul -> a * b
                R.id.div -> a / b
                else -> Float.NaN
            }.also {
                prefs.edit {
                    putFloat(ANS_KEY, it)
                }
            }
        }
    }

    private companion object {
        private val TAG = CalcViewModel::class.simpleName
        private const val ANS_KEY = "ans"
    }
}