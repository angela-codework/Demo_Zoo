package com.test.zoo.adapter

import android.webkit.URLUtil
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.test.zoo.R
import java.net.URL

/**
 * A data binding adapter.
 */
object DataBindingAdapter {

    private const val IMG_URL = "imgUrl"
    private const val MEMO_TXT = "memoTxt"
    private const val IMG_SRC = "imgSrc"

    //load image by url
    @JvmStatic
    @BindingAdapter(IMG_URL)
    fun loadImage(view: ImageView, url: String?) {

        val target: Any = when(URLUtil.isValidUrl(url)) {
            true -> url!!.replaceFirst("http", "https")
            else -> R.drawable.img_not_available
        }

        val width = view.context.resources.getDimension(R.dimen.img_width). toInt()
        val height = view.context.resources.getDimension(R.dimen.img_height). toInt()

        Glide.with(view.context)
            .load(target)
            .placeholder(R.drawable.img_placeholder)
            .error(R.drawable.img_not_available)
            .override(width, height)
            .fitCenter()
            .into(view)
    }

    //load img by res id
    @JvmStatic
    @BindingAdapter(IMG_SRC)
    fun loadImageSrc(view: ImageView, resId: Int) {
        val width = view.context.resources.getDimension(R.dimen.img_width). toInt()
        val height = view.context.resources.getDimension(R.dimen.img_height). toInt()

        Glide.with(view.context)
            .load(resId)
            .placeholder(R.drawable.img_placeholder)
            .error(R.drawable.img_not_available)
            .override(width, height)
            .fitCenter()
            .into(view)
    }

    @JvmStatic
    @BindingAdapter(MEMO_TXT)
    fun loadMemo(view: TextView, str: String?) {

        view.text = if(str.isNullOrEmpty())
            view.context.getString(R.string.title_no_memo)
        else str
    }

}