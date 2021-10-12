package com.krujz.verycreatives.screens.common.dialogs.interfaces

import com.krujz.verycreatives.screens.common.imageloader.IImageLoader

interface IDialogNavigator {
    fun showErrorDialog(title: String, message: String)
    fun showSuccessDialog(message: String)
    fun showWarningDialog(title: String, message: String)
    fun showNormalAlertDialog(title: String, message: String)
    fun dismissShoeSideAlertDialog()
    fun showEnlargedImageViewAlertDialog(imageUrl: String, imageLoader: IImageLoader)
    fun showLoadingDialog(title: String, message: String)
    fun dismissLoadingAlertDialog()
}