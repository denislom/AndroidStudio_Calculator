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
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.dlom.calculator.calc.CalcFragment
import com.dlom.calculator.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root ) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars() + WindowInsetsCompat.Type.ime()
            )
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val navController = binding.container.getFragment<NavHostFragment>().navController
        setupActionBarWithNavController(navController, AppBarConfiguration(navController.graph))

        Log.d(TAG, "Intent: ${intent.dataString}")
    }

    override fun onResume() {
        super.onResume()
        if (BuildConfig.DEBUG) {
            Toast.makeText(this, "Resume", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "Resume")
        }
    }

    override fun onSupportNavigateUp() =
        findNavController(R.id.container).navigateUp() || super.onSupportNavigateUp()


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