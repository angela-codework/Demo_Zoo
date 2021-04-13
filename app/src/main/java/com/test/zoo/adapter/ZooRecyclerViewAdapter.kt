package com.test.zoo.adapter

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.test.zoo.R
import com.test.zoo.database.ZooInfo
import com.test.zoo.databinding.ItemListViewBinding
import com.test.zoo.interfaces.IItemClickListener


/**
 * List all zoo section by indoor/outdoor.
 */
class ZooRecyclerViewAdapter(private val listener: IItemClickListener): PagedListAdapter<ZooInfo, ZooRecyclerViewAdapter.ViewHolder>(
    DIFF_CALLBACK
){

    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<ZooInfo>() {

            override fun areItemsTheSame(oldItem: ZooInfo, newItem: ZooInfo): Boolean {
                return oldItem.uid == newItem.uid
            }

            override fun areContentsTheSame(oldItem: ZooInfo, newItem: ZooInfo): Boolean {
               return oldItem == newItem
            }
        }
    }

    inner class ViewHolder(private val binding: ItemListViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ZooInfo) {
            binding.apply {
                infoItem = item
                clickListener = listener
                executePendingBindings()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position) as ZooInfo
        holder.bind(item)
        loadItemAnim(holder.itemView)
    }

    //set item show animation
    private fun loadItemAnim(view: View) {
        view.animation = AnimationUtils.loadAnimation(view.context, R.anim.list_anim)
    }
}