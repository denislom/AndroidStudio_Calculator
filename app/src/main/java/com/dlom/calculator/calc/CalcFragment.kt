package com.dlom.calculator.calc

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.dlom.calculator.R
import com.dlom.calculator.databinding.FragmentCalcBinding
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CalcFragment : Fragment(), MenuProvider {
    private var binding : FragmentCalcBinding? = null
    private val viewModel: CalcViewModel by viewModels()


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        requireActivity().addMenuProvider(this, viewLifecycleOwner)
        binding?.calc?.setOnClickListener {
            viewModel.calc(
                "${binding?.aText?.text}".toFloatOrNull() ?: Float.NaN,
                "${binding?.bText?.text}".toFloatOrNull() ?: Float.NaN,
                binding?.ops?.checkedRadioButtonId ?: -1
            )
        }
        viewModel.res
            .filterNotNull()
            .onEach {
                binding?.res?.text = "$it"
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
        binding?.share?.setOnClickListener { share() }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem) = when (menuItem.itemId) {
        R.id.about -> {
//            parentFragmentManager.commit {
//                replace(R.id.container, AboutFragment("Denis Lom"))
//                addToBackStack(null)
//            }
            findNavController().navigate(CalcFragmentDirections.actionCalcFragmentToAboutFragment("Denis Lom <3"))
            true
        }
        else -> false
    }

     private companion object {
         private val TAG = CalcFragment::class.simpleName
     }
}