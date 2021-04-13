package com.test.zoo.fragment

import com.test.zoo.R

/**
 * A fragment extends from CategoryFragment to show zoo outdoor sections.
 */
class OutDoorCategoryRVFragment : CategoryRVFragmentBase() {
    //toolbar title
    override val title: String
        get() = requireContext().getString(R.string.menu_outdoor)
    //toolbar image
    override val img: Int
        get() = R.drawable.outdoor
}