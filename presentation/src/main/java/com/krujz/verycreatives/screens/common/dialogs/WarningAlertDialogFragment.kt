package com.krujz.verycreatives.screens.common.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.krujz.verycreatives.R

class WarningAlertDialogFragment constructor(private val title: String, private val message: String) : BaseDialog() {

    private lateinit var titleTextView: TextView
    private lateinit var messageTextView: TextView
    private lateinit var dismissButton: AppCompatButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBackGround()
        return inflater.inflate(R.layout.custom_warning_alertdialogfragment, container, false)
    }

    override fun onStart() {
        super.onStart()
        setFindViewById()
        setTitle()
        setMessage()
        setOnDismissButtonClickListener()
    }

    private fun setBackGround(){
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.rounded_warning_background);
    }

    private fun setFindViewById(){
        titleTextView = dialog!!.window?.findViewById(R.id.alertdialog_title_warning)!!
        messageTextView = dialog!!.window?.findViewById(R.id.alertdialog_message_warning)!!
        dismissButton = dialog!!.window?.findViewById(R.id.dismiss_button_warning)!!
    }

    private fun setTitle(){
        titleTextView.text = title
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
        fun newInstance(title: String, message: String): WarningAlertDialogFragment {
            return WarningAlertDialogFragment(title, message)
        }
    }
}