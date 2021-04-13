package com.test.zoo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.test.zoo.interfaces.IItemClickListener
import com.test.zoo.adapter.PlantRecyclerViewAdapter
import com.test.zoo.database.ZooInfo
import com.test.zoo.databinding.FragmentSecondBinding
import com.test.zoo.model.ZooModelFactory
import com.test.zoo.model.ZooViewModel
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.test.zoo.R

/**
 * A fragment extends from FragmentBase and apply RecyclerView.
 */
abstract class RVFragmentBase : FragmentBase(), IItemClickListener {

    //setup recyclerview
    abstract fun setRecyclerView()
    //show empty view if recyclerview is empty
    abstract fun verifyEmptyView(itemCount: Int)
    //register recyclerview adapter
    abstract fun registerAdapterListener()
    //unregister recyclerview adapter
    abstract fun unregisterAdapterListener()

    //recyclerview content observer
    val dataObserver = object: RecyclerView.AdapterDataObserver() {
        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            verifyEmptyView(itemCount)
            super.onItemRangeInserted(positionStart, itemCount)
        }
    }

    //fragment transit animation listener
    private val animListener = object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation) {}

        override fun onAnimationRepeat(animation: Animation) {}

        override fun onAnimationEnd(animation: Animation) {
            setRecyclerView()
        }
    }

    override fun onResume() {
        super.onResume()
        registerAdapterListener()
    }

    override fun onPause() {
        super.onPause()
        unregisterAdapterListener()
    }

    //show recycler view after fragment transit animation is end
    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation? {
        if(nextAnim == 0)  {
            setRecyclerView()
        } else {
            val anim = AnimationUtils.loadAnimation(activity, nextAnim)
            anim.setAnimationListener(animListener)
            return anim
        }
        return super.onCreateAnimation(transit, enter, nextAnim)

    }

}