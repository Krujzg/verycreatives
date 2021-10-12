package com.krujz.verycreatives.screens.common.dialogs

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.krujz.verycreatives.screens.common.dialogs.interfaces.IDialogNavigator
import com.krujz.verycreatives.screens.common.imageloader.IImageLoader

class DialogNavigator(private val fragmentManager: FragmentManager): IDialogNavigator {

    override fun showErrorDialog(title: String, message: String) {
        when (checkIfDialogIsAlive(ERROR_ALERT_DIALOG_TAG)){
            false -> {
                fragmentManager.beginTransaction()
                        .add(ErrorAlertDialogFragment.newInstance(title, message), ERROR_ALERT_DIALOG_TAG)
                        .commitAllowingStateLoss()
            }
        }
    }

    override fun showSuccessDialog(message: String) {
        when (checkIfDialogIsAlive(SUCCESS_ALERT_DIALOG_TAG)){
            false -> {
                fragmentManager.beginTransaction()
                        .add(SuccessAlertDialogFragment.newInstance(message), SUCCESS_ALERT_DIALOG_TAG)
                        .commitAllowingStateLoss()
            }
        }
    }

    override fun showWarningDialog(title: String, message: String) {
        when (checkIfDialogIsAlive(WARNING_ALERT_DIALOG_TAG)){
            false -> {
                fragmentManager.beginTransaction()
                        .add(WarningAlertDialogFragment.newInstance(title, message), WARNING_ALERT_DIALOG_TAG)
                        .commitAllowingStateLoss()
            }
        }
    }

    override fun showNormalAlertDialog(title: String, message: String) {
        when (checkIfDialogIsAlive(SHOE_SIDE_ALERT_DIALOG_TAG)){
            false -> {
                fragmentManager.beginTransaction()
                        .add(AlertDialogFragment.newInstance(title, message), SHOE_SIDE_ALERT_DIALOG_TAG)
                        .commitAllowingStateLoss()
            }
        }
    }

    override fun dismissShoeSideAlertDialog(){
        val dialogFragment = fragmentManager.findFragmentByTag(SHOE_SIDE_ALERT_DIALOG_TAG)
        if (dialogFragment != null){
            val df = dialogFragment as DialogFragment
            df.dismiss()
        }
    }

    override fun showEnlargedImageViewAlertDialog(imageUrl: String, imageLoader: IImageLoader){
        when (checkIfDialogIsAlive(ENLARGE_IMAGEVIEW_ALERT_DIALOG_TAG)){
            false -> {
                fragmentManager.beginTransaction()
                        .add(
                            EnlargedImageViewAlertDialogFragment.newInstance(
                                imageUrl,
                                imageLoader
                            ), ENLARGE_IMAGEVIEW_ALERT_DIALOG_TAG
                        )
                        .commitAllowingStateLoss()
            }
        }
    }

    override fun showLoadingDialog(title: String, message: String) {
        when (checkIfDialogIsAlive(LOADING_ALERT_DIALOG_TAG)){
            false -> {
                fragmentManager.beginTransaction()
                        .add(LoadingAlertDialogFragment.newInstance(title, message), LOADING_ALERT_DIALOG_TAG)
                        .commitAllowingStateLoss()
            }
        }
    }

    override fun dismissLoadingAlertDialog(){
        val dialogFragment = fragmentManager.findFragmentByTag(LOADING_ALERT_DIALOG_TAG)
        if (dialogFragment != null){
            val df = dialogFragment as DialogFragment
            df.dismiss()
        }
    }

    private fun checkIfDialogIsAlive(tag: String): Boolean{
        val dialogFragment = fragmentManager.findFragmentByTag(tag)
        return dialogFragment != null
    }

    companion object{
        const val ERROR_ALERT_DIALOG_TAG = "ErrorAlertDialog"
        const val SUCCESS_ALERT_DIALOG_TAG = "SuccessAlertDialog"
        const val WARNING_ALERT_DIALOG_TAG = "WarningAlertDialog"
        const val SHOE_SIDE_ALERT_DIALOG_TAG = "ShoeSideAlertDialog"
        const val READER_POWER_SEEKBAR_ALERT_DIALOG_TAG = "ReaderPowerSeekBarAlertDialog"
        const val ENLARGE_IMAGEVIEW_ALERT_DIALOG_TAG = "Enlarge_ImageView_AlertDialog"
        const val LOADING_ALERT_DIALOG_TAG = "LoadingAlertDialog"
    }
}