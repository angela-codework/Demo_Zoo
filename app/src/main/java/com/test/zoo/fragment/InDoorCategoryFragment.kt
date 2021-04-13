package com.test.zoo.fragment

import androidx.fragment.app.Fragment
import com.test.zoo.R

/**
 * A fragment extends from CategoryFragment to show zoo indoor sections.
 */
class InDoorCategoryFragment : CategoryFragmentBase() {
    //toolbar title
    override val img: Int
        get() = R.drawable.indoor
    //toolbar image
    override val title: String
        get() = requireContext().getString(R.string.menu_indoor)

}