package com.dlom.calculator.about

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class AboutFragment() : Fragment() {
    constructor(name: String) : this() {
        arguments = bundleOf(NAME_KEY to name)
    }

    private val name by lazy { requireArguments().getString(NAME_KEY    ) }
    private companion object {
        private const val NAME_KEY = "name"
    }
}