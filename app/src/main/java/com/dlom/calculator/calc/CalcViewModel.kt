package com.dlom.calculator.calc

import android.util.Log
import androidx.annotation.IdRes
import androidx.lifecycle.ViewModel
import com.dlom.calculator.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.concurrent.thread
import kotlin.time.Duration.Companion.seconds

class CalcViewModel : ViewModel() {
    private val _res = MutableStateFlow<Float?>(null)
    val res: StateFlow<Float?> = _res

    fun calc(a: Float, b: Float, @IdRes op: Int) {
        Log.d(TAG, "Calc!")

        thread {
            Thread.sleep(2.seconds.inWholeMilliseconds)
            _res.value = when (op) {
                R.id.add -> a + b
                R.id.sub -> a - b
                R.id.mul -> a * b
                R.id.div -> a / b
                else -> Float.NaN
            }
        }
    }

    private companion object {
        private val TAG = CalcViewModel::class.simpleName
    }
}