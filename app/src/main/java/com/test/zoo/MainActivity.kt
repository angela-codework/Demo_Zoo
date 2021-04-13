package com.test.zoo


import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.LayoutParams.*
import com.test.zoo.adapter.DataBindingAdapter
import com.test.zoo.interfaces.ICollapseCtrl
import com.test.zoo.interfaces.IFabClickListener
import com.test.zoo.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.app_bar_main.view.*

/**
 * Main activity with drawer layout navigate multiple fragment
 */
class MainActivity : AppCompatActivity(), ICollapseCtrl,
    IFabClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    private var webLink: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater, null, false)
        binding.apply {
            setContentView(binding.root)
            setSupportActionBar(appBarLayout.toolbarLayout.toolbar)

            //fab click listner
            appBarLayout.clickListener = this@MainActivity

            //drawer layout with nav controller
            navController = findNavController(R.id.nav_host_fragment)
            appBarConfiguration = AppBarConfiguration(setOf(
                R.id.HomeFragment, R.id.ZooInDoorFragment, R.id.ZooOutDoorFragment), drawerLayout)
            setupActionBarWithNavController(navController, appBarConfiguration)
            navView.setupWithNavController(navController)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    //collapse toolbar
    override fun extendToolbar() {
        binding.appBarLayout.appBar.setExpanded(true, true)
        updateToolbar(false)
    }

    //update toolbar image by res id
    override fun updateToolbarImgByRes(resId: Int) {
        DataBindingAdapter.loadImageSrc(binding.appBarLayout.header, resId)
    }

    //update toolbar image by url
    override fun updateToolbarImgByUrl(url: String?) {
        DataBindingAdapter.loadImage(binding.appBarLayout.header, url)
    }

    //if url is null, hide fab button
    override fun updateFabLink(url: String?) {
        binding.appBarLayout.fab.apply {
            val param = layoutParams as CoordinatorLayout.LayoutParams
            if(url == null) {//hide
                param.width = 0
                param.height = 0
                hide()
            } else {//show
                param.width = CoordinatorLayout.LayoutParams.WRAP_CONTENT
                param.height = CoordinatorLayout.LayoutParams.WRAP_CONTENT
                show()
            }
        }
        webLink = url
    }

    //update toolbar title
    override fun updateTitle(name: String?) {
        binding.appBarLayout.toolbarLayout.title = name
    }

    //extend toolbar to ful screen size(for homepage)
    override fun extendFullToolbar() {
        binding.appBarLayout.header.setImageResource(0)
        binding.appBarLayout.appBar.setExpanded(true, true)
        updateToolbar(true)
    }

    //fab click listener
    override fun onFabClick() {
        webLink?.apply {
            Intent(Intent.ACTION_VIEW)
                .setData(Uri.parse(webLink))
                .apply { startActivity(this) }
        }
    }

    //update toolbar scroll behavior, height, and image
    private fun updateToolbar(isFullExpand: Boolean) {
        val param = binding.appBarLayout.toolbarLayout.layoutParams as AppBarLayout.LayoutParams
        param.apply {
            when(isFullExpand) {
                true -> {
                    binding.appBarLayout.toolbarContentLayout.homeImgLayout.visibility = View.VISIBLE
                    height = Resources.getSystem().displayMetrics.heightPixels
                    scrollFlags = SCROLL_FLAG_NO_SCROLL
                }
                else -> {
                    binding.appBarLayout.toolbarContentLayout.homeImgLayout.visibility = View.GONE
                    height = resources.getDimension(R.dimen.toolbar_height).toInt()
                    scrollFlags = SCROLL_FLAG_SCROLL or SCROLL_FLAG_EXIT_UNTIL_COLLAPSED
                }
            }
        }
    }


}