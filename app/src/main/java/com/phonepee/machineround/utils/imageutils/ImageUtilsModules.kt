package com.phonepee.machineround.utils.imageutils

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class ImageUtilsModules {

    companion object {
        private var mInstance = ImageUtilsModules()
        fun newInstance() = mInstance
    }

    fun downloadImage(pUrl: String, pView: View) {
        when (pView) {
            is ImageView -> {
                setImageToView(
                    pUrl = pUrl,
                    pView = pView
                )
            }
        }
    }

    private fun setImageToView(pUrl: String, pView: ImageView) {
        Glide.with(pView.context)
            .load(pUrl)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(pView)
    }
}