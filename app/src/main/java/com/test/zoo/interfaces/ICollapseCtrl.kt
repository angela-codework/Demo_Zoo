package com.test.zoo.interfaces

/**
 * An interface manage collapse toolbar behavior.
 */
interface ICollapseCtrl {
    fun extendToolbar()
    fun updateToolbarImgByRes(resId: Int)
    fun updateToolbarImgByUrl(url: String?)
    fun updateFabLink(url: String?)
    fun updateTitle(name: String?)
    fun extendFullToolbar()
}