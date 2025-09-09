package com.dlom.calculator

import android.os.Bundle
import android.util.Log
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {
    private val aText by lazy {findViewById<TextInputEditText>(R.id.a_text)}
    private val bText by lazy {findViewById<TextInputEditText>(R.id.b_text)}
    private val ops by lazy {findViewById<RadioGroup>(R.id.ops)}
    private val res by lazy {findViewById<MaterialTextView>(R.id.res)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars() + WindowInsetsCompat.Type.ime()
            )
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<FloatingActionButton>(R.id.calc).setOnClickListener { calc() }
    }

    private fun calc() {
        Log.d(TAG, "Calc!")
        val a = "${aText.text}".toFloatOrNull() ?: Float.NaN
        val b = "${bText.text}".toFloatOrNull() ?: Float.NaN
        res.text = when(ops.checkedRadioButtonId) {
            R.id.add -> a + b
            R.id.sub -> a - b
            R.id.mul -> a * b
            R.id.div -> a / b
            else -> Float.NaN
        }.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putCharSequence(RES_KEY, res.text)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        res.text = savedInstanceState.getCharSequence(RES_KEY)
    }

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