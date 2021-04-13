package com.test.zoo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.test.zoo.interfaces.ICollapseCtrl
import com.test.zoo.databinding.FragmentHomeBinding

/**
 * A homepage fragment as the default destination in the navigation.
 */
class HomeFragment : Fragment(){

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as ICollapseCtrl).apply {
            extendFullToolbar()
            updateFabLink(null)
            updateTitle(" ")
        }
    }

}