package com.test.zoo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.test.zoo.database.PlantTuple
import com.test.zoo.databinding.PlantItemListViewBinding
import com.test.zoo.interfaces.IItemClickListener

/**
 * List all plant by zoo section name.
 */
class PlantRecyclerViewAdapter(private val listener: IItemClickListener): PagedListAdapter<PlantTuple, PlantRecyclerViewAdapter.ViewHolder>(
    DIFF_CALLBACK
){

    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<PlantTuple>() {

            override fun areItemsTheSame(oldItem: PlantTuple, newItem: PlantTuple): Boolean {
                return oldItem.uid == newItem.uid
            }

            override fun areContentsTheSame(oldItem: PlantTuple, newItem: PlantTuple): Boolean {
               return oldItem == newItem
            }
        }
    }

    inner class ViewHolder(private val binding: PlantItemListViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PlantTuple) {
            binding.apply {
                infoItem = item
                clickListener = listener
                executePendingBindings()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PlantItemListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.apply {
            val item = getItem(position) as PlantTuple
            holder.bind(item)
        }

    }
}