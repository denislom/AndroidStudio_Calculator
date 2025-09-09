package com.dlom.calculator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import com.dlom.calculator.calc.CalcFragment
import com.dlom.calculator.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {
//    private val aText by lazy {findViewById<TextInputEditText>(R.id.a_text)}
//    private val bText by lazy {findViewById<TextInputEditText>(R.id.b_text)}
//    private val ops by lazy {findViewById<RadioGroup>(R.id.ops)}
//    private val res by lazy {findViewById<MaterialTextView>(R.id.res)}

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root ) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars() + WindowInsetsCompat.Type.ime()
            )
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        findViewById<FloatingActionButton>(R.id.calc).setOnClickListener { calc() }
//        binding.calc.setOnClickListener { calc() }
//        binding.share.setOnClickListener { share() }
//        if (savedInstanceState == null) {
//            supportFragmentManager.commit {
//                add(R.id.container, CalcFragment())
//            }
//        }
        Log.d(TAG, "Intent: ${intent.dataString}")
    }

//    private fun share() {
//        Log.d(TAG, "Share")
//        startActivity(
//            Intent(Intent.ACTION_SEND)
//                .setType("text/plain")
//                .putExtra(
//                    Intent.EXTRA_TEXT,
//                    getString(R.string.share_text, binding.res.text)
//                )
//        )
//    }
//    private fun calc() {
//        Log.d(TAG, "Calc!")
//        val a = "${binding.aText.text}".toFloatOrNull() ?: Float.NaN
//        val b = "${binding.bText.text}".toFloatOrNull() ?: Float.NaN
//        binding.res.text = when(binding.ops.checkedRadioButtonId) {
//            R.id.add -> a + b
//            R.id.sub -> a - b
//            R.id.mul -> a * b
//            R.id.div -> a / b
//            else -> Float.NaN
//        }.toString()
//    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putCharSequence(RES_KEY, binding.res.text)
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        binding.res.text = savedInstanceState.getCharSequence(RES_KEY)
//    }

    override fun onResume() {
        super.onResume()
        if (BuildConfig.DEBUG) {
            Toast.makeText(this, "Resume", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "Resume")
        }
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "Pause")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show()
    }

    private companion object {
        private val TAG = MainActivity::class.simpleName
        private const val RES_KEY = "res"
    }
}