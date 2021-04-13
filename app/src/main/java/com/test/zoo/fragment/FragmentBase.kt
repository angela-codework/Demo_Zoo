package com.test.zoo.fragment

import androidx.fragment.app.Fragment
import com.test.zoo.interfaces.ICollapseCtrl

/**
 * An abstract fragment base handle collapse toolbar layout and navigation bar height.
 */
abstract class FragmentBase : Fragment() {

    abstract val title: String
    abstract val img: Any?
    abstract val fabLink: String?

    override fun onResume() {
        super.onResume()
        updateToolBar()
    }

    //update toolbar behavior
    private fun updateToolBar() {
        (requireActivity() as ICollapseCtrl).apply {
            if(img is Int)  updateToolbarImgByRes(img as Int)
            else updateToolbarImgByUrl(img as String?)

            extendToolbar()
            updateTitle(title)
            updateFabLink(fabLink)
        }
    }

    //get display navigation bar height
    val navigationBarHeight: Int
        get() {
            val resourceId =
                resources.getIdentifier("navigation_bar_height", "dimen", "android")
            if(resourceId > 0) {
                return resources.getDimensionPixelSize(resourceId)
            }
            return 0
        }

}