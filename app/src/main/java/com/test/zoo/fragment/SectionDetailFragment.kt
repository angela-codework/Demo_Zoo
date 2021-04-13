package com.test.zoo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.test.zoo.adapter.PlantRecyclerViewAdapter
import com.test.zoo.database.ZooInfo
import com.test.zoo.databinding.FragmentSecondBinding
import com.test.zoo.model.ZooModelFactory
import com.test.zoo.model.ZooViewModel
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.test.zoo.R

/**
 * A fragment extends from FragmentBase and show zoo section detail.
 */
class SectionDetailFragment : RVFragmentBase() {

    //toolbar title
    override val title: String
        get() = data.name!!
    //toolbar image
    override val img: Any?
        get() = data.pic
    //fab button link
    override val fabLink: String?
        get() = data.url

    lateinit var binding: FragmentSecondBinding
    private val viewModel: ZooViewModel by viewModels { ZooModelFactory(requireActivity().application, title) }
    private val viewAdapter by lazy { PlantRecyclerViewAdapter(this) }
    private val data: ZooInfo by lazy { arguments?.get("item") as ZooInfo}

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        updateBindingData()
        return binding.root
    }

    override fun setRecyclerView() {
        //set recyclerview adapter
        binding.rvMain.adapter = viewAdapter
        //observe and submit query result to paged-list adapter
        viewModel.plantList.observe(requireActivity(), Observer(viewAdapter::submitList))
        //check if recyclerview is empty then show empty view
    }

    override fun verifyEmptyView(itemCount: Int) {
        binding.isEmpty = itemCount == 0
    }

    override fun registerAdapterListener() {
        viewAdapter.registerAdapterDataObserver(dataObserver)
    }

    override fun unregisterAdapterListener() {
        viewAdapter.unregisterAdapterDataObserver(dataObserver)
    }

    //bind data
    private fun updateBindingData() {
        //bind list item content
        binding.titleLayout.zooInfo = data
        //bind data to ensure recyclerview above navigation bar
        binding.navBarPadding = navigationBarHeight
    }

    //recyclerview item click callback
    override fun onItemClick(item: Any) {
        //send data to next fragment
        val bundle = bundleOf("item" to item)
        //navigate to next fragment
        findNavController().navigate(R.id.action_SecondFragment_to_ThirdFragment, bundle)
    }

}