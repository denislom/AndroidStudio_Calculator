package com.dlom.calculator.history

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter : ListAdapter<HistoryEntity, HistoryAdapter.HistoryViewHolder>(DIFF) {
    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int) = getItem(position).id

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HistoryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    android.R.layout.simple_list_item_1,
                    parent,
                    false
                )
        ).also {
            Log.d(TAG, "Create VH")
        }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        Log.v(TAG, "Bind $position")
        (holder.itemView as TextView).text = "${getItem(position).value}"
    }
    inner class HistoryViewHolder(v: View) : RecyclerView.ViewHolder(v)

    private companion object {
        private val TAG = HistoryAdapter::class.simpleName
        private val DIFF = object : DiffUtil.ItemCallback<HistoryEntity>() {
            override fun areItemsTheSame(
                oldItem: HistoryEntity,
                newItem: HistoryEntity
            ) = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: HistoryEntity,
                newItem: HistoryEntity
            ) = oldItem == newItem
        }
    }
}