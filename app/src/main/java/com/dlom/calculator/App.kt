package com.dlom.calculator

import android.app.Application
import androidx.fragment.app.FragmentManager

class App : Application() {
    init {
        FragmentManager.enableDebugLogging(BuildConfig.DEBUG)
    }
}