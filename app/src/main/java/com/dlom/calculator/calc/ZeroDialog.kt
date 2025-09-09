package com.dlom.calculator.calc

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.dlom.calculator.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ZeroDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?) =
        MaterialAlertDialogBuilder(requireContext())
            .setMessage(R.string.zero_div)
            .create()
}