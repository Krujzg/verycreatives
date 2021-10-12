package com.krujz.verycreatives.screens.common.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.krujz.verycreatives.R

class LoadingAlertDialogFragment constructor(private val title: String, private val message: String) : BaseDialog() {

    private lateinit var titleTextView: TextView
    private lateinit var messageTextView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBackGround()
        return inflater.inflate(R.layout.custom_loading_alertdialogfragment, container, false)
    }

    override fun onStart() {
        super.onStart()
        setFindViewById()
        setTitle()
        setMessage()
    }

    private fun setBackGround(){
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.rounded_loading_background);
    }

    private fun setTitle(){
        titleTextView.text = title
    }

    private fun setMessage(){
        messageTextView.text = message
    }

    private fun setFindViewById(){
        titleTextView = dialog!!.window?.findViewById(R.id.loading_alertdialog_title)!!
        messageTextView = dialog!!.window?.findViewById(R.id.loading_alertdialog_message)!!
    }

    override fun onResume() {
        super.onResume()
        setSize()
    }

    private fun setSize(){
        val width = resources.getDimensionPixelSize(R.dimen.loading_dialog_width)
        val height = resources.getDimensionPixelSize(R.dimen.loading_dialog_height)
        dialog!!.window!!.setLayout(width, height)
    }

    companion object {
        fun newInstance(title: String, message: String): LoadingAlertDialogFragment {
            return LoadingAlertDialogFragment(title, message)
        }
    }
}