package com.krujz.verycreatives.screens.common.imageloader

import android.widget.ImageView
import android.widget.ProgressBar

interface IImageLoader {
    fun loadImageUrlIntoImageView(imageUrl: String, target: ImageView)
    fun loadImageUrlIntoImageViewWithProgressBar(imageUrl: String, target: ImageView,progressbar: ProgressBar)
    fun loadImageDrawableIntoImageView(imageDrawable: Int, target: ImageView)
}