package com.dlom.calculator.calc

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CalcViewModel : ViewModel() {
    private val _res = MutableStateFlow<Float?>(null)
    val res: StateFlow<Float?> = _res

}