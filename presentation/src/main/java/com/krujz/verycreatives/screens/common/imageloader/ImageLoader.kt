package com.krujz.verycreatives.screens.common.imageloader

import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.krujz.verycreatives.BuildConfig
import com.krujz.verycreatives.screens.common.glide.GlideImageLoader

class ImageLoader (private val activity: AppCompatActivity): IImageLoader {

    override fun loadImageUrlIntoImageView(imageUrl: String, target: ImageView) {
        val requestOptions = RequestOptions()
        Glide.with(activity).load(BuildConfig.image_base_url_without_slash + imageUrl)
            .apply(requestOptions).into(target)
    }

    override fun loadImageUrlIntoImageViewWithProgressBar(
        imageUrl: String,
        target: ImageView,
        progressbar: ProgressBar,
    ) {
        val requestOptions = RequestOptions()
        GlideImageLoader(target, progressbar).load(BuildConfig.image_base_url_without_slash + imageUrl, requestOptions)
    }

    override fun loadImageDrawableIntoImageView(imageDrawable: Int, target: ImageView) {
        Glide.with(activity).load(imageDrawable).into(target)
    }


    
}