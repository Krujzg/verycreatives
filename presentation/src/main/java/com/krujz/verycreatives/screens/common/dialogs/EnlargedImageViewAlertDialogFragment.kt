package com.krujz.verycreatives.screens.common.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.krujz.verycreatives.screens.common.imageloader.IImageLoader
import com.krujz.verycreatives.R

class EnlargedImageViewAlertDialogFragment constructor(private val imageUrl:String, private val imageLoader: IImageLoader) : BaseDialog() {

    private lateinit var enlarged_imageview: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.custom_enlarged_image_alertdialogfragment, container, false)
    }

    override fun onStart() {
        super.onStart()
        setFindViewById()
        loadImageUrl()
    }

    private fun setFindViewById(){
        enlarged_imageview = dialog!!.window?.findViewById(R.id.enlarged_imageview)!!
    }

    private fun loadImageUrl(){
        imageLoader.loadImageUrlIntoImageView(imageUrl, enlarged_imageview)
    }

    override fun onResume() {
        super.onResume()
        setSize()
    }

    private fun setSize(){
        val width = resources.getDimensionPixelSize(R.dimen.imageview_size)
        val height = resources.getDimensionPixelSize(R.dimen.imageview_size)
        dialog!!.window!!.setLayout(width, height)
    }

    companion object {
        fun newInstance(imageUrl: String, imageLoader: IImageLoader): EnlargedImageViewAlertDialogFragment {
            return EnlargedImageViewAlertDialogFragment(imageUrl, imageLoader)
        }
    }
}