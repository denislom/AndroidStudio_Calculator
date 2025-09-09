package com.dlom.calculator.about

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.dlom.calculator.R
import com.google.android.material.textview.MaterialTextView

class AboutFragment() : Fragment(R.layout.fragment_about) {
    constructor(name: String) : this() {
        arguments = bundleOf(NAME_KEY to name)
    }

    private val name by lazy { requireArguments().getString(NAME_KEY    ) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (view as MaterialTextView).text = getString(R.string.made_by, name)
        super.onViewCreated(view, savedInstanceState)
    }
    private companion object {
        private const val NAME_KEY = "name"
    }
}