package com.krujz.verycreatives.screens.common.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.krujz.verycreatives.R

class SuccessAlertDialogFragment constructor(private val message: String) : BaseDialog() {

    private lateinit var messageTextView: TextView
    private lateinit var dismissButton: AppCompatButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBackGround()
        return inflater.inflate(R.layout.custom_success_alertdialogfragment, container, false)
    }

    override fun onStart() {
        super.onStart()
        setFindViewById()
        setMessage()
        setOnDismissButtonClickListener()
    }

    private fun setBackGround(){
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.rounded_success_background);
    }

    private fun setFindViewById(){
        messageTextView = dialog!!.window?.findViewById(R.id.alertdialog_message_success)!!
        dismissButton = dialog!!.window?.findViewById(R.id.dismiss_button_success)!!
    }

    private fun setMessage(){
        messageTextView.text = message
    }

    private fun setOnDismissButtonClickListener(){
        dismissButton.setOnClickListener {
            dialog!!.dismiss()
        }
    }

    companion object {
        fun newInstance(message: String): SuccessAlertDialogFragment {
            return SuccessAlertDialogFragment(message)
        }
    }
}