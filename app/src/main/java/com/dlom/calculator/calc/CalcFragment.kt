package com.dlom.calculator.calc

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dlom.calculator.R
import com.dlom.calculator.databinding.FragmentCalcBinding
import java.security.PrivateKey

class CalcFragment : Fragment() {
    private var binding : FragmentCalcBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCalcBinding.inflate(inflater, container, false)
        .also { binding = it }
        .root

    private fun share() {
        Log.d(TAG, "Share")
        startActivity(
            Intent(Intent.ACTION_SEND)
                .setType("text/plain")
                .putExtra(
                    Intent.EXTRA_TEXT,
                    getString(R.string.share_text, binding?.res?.text)
                )
        )
    }
    private fun calc() {
        Log.d(TAG, "Calc!")
        val a = "${binding?.aText?.text}".toFloatOrNull() ?: Float.NaN
        val b = "${binding?.bText?.text}".toFloatOrNull() ?: Float.NaN
        binding?.res?.text = when (binding?.ops?.checkedRadioButtonId) {
            R.id.add -> a + b
            R.id.sub -> a - b
            R.id.mul -> a * b
            R.id.div -> a / b
            else -> Float.NaN
        }.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.calc?.setOnClickListener { calc() }
        binding?.share?.setOnClickListener { share() }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

     private companion object {
         private val TAG = CalcFragment::class.simpleName
     }
}