package com.dlom.calculator.history

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.dlom.calculator.R
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlin.getValue

class HistoryFragment : Fragment(R.layout.fragment_history) {
    private val historyViewModel: HistoryViewModel by viewModels( {requireActivity()} )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recycler = view as RecyclerView
        recycler.setHasFixedSize(true)
        val adapter = HistoryAdapter()
        recycler.adapter = adapter
        historyViewModel.db.getAll().onEach {
            adapter.submitList(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }
}