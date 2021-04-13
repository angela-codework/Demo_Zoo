package com.test.zoo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.test.zoo.R
import com.test.zoo.adapter.ZooRecyclerViewAdapter
import com.test.zoo.databinding.FragmentFirstBinding
import com.test.zoo.model.ZooModelFactory
import com.test.zoo.model.ZooViewModel


/**
 * An abstract fragment extends from RVFragmentBase and is the base of indoor/outdoor fragment.
 */
abstract class CategoryRVFragmentBase : RVFragmentBase() {

    override val fabLink: String?
        get() = null

    lateinit var binding: FragmentFirstBinding
    private val viewModel: ZooViewModel by viewModels { ZooModelFactory(requireActivity().application, title) }
    private val viewAdapter by lazy { ZooRecyclerViewAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        updateBindingData()

        return binding.root
    }

    override fun verifyEmptyView(itemCount: Int) {}

    //bind data
    private fun updateBindingData() {
        //bind data to ensure recyclerview above navigation bar
        binding.navBarPadding = navigationBarHeight
    }

    override fun setRecyclerView() {
        //set recyclerview adapter
        binding.rvMain.adapter = viewAdapter
        //observe and submit query result to paged-list adapter
        viewModel.zooInfoList.observe(requireActivity(), Observer(viewAdapter::submitList))
    }

    override fun onItemClick(item: Any) {
        //send data to next fragment
        val bundle = bundleOf("item" to item)
        //navigate to next fragment
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
    }

    override fun registerAdapterListener() {
        viewAdapter.registerAdapterDataObserver(dataObserver)
    }

    override fun unregisterAdapterListener() {
        viewAdapter.unregisterAdapterDataObserver(dataObserver)
    }

}