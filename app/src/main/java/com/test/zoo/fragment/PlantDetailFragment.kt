package com.test.zoo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.zoo.database.PlantTuple
import com.test.zoo.databinding.FragmentThirdBinding
import com.test.zoo.fragment.FragmentBase

/**
 * A fragment extends from FragmentBase and show plant detail.
 */
class PlantDetailFragment : FragmentBase() {

    //toolbar title
    override val title: String
        get() = data.name!!
    //toolbar image
    override val img: Any?
        get() = data.pic1Url
    //fab button link
    override val fabLink: String?
        get() = null

    lateinit var binding: FragmentThirdBinding
    private val data: PlantTuple by lazy { arguments?.get("item") as PlantTuple}

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        updateBindingData()
        return binding.root
    }

    //bind data
    private fun updateBindingData() {
        //bind list item content
        binding.plantInfo = data
    }

}