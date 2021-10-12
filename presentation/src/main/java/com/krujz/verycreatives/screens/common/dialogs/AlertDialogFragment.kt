package com.krujz.verycreatives.screens.common.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.krujz.verycreatives.R


class AlertDialogFragment constructor(private val title: String, private val message: String) : BaseDialog() {

    private lateinit var titleTextView: TextView
    private lateinit var messageTextView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBackGround()
        return inflater.inflate(R.layout.custom_alertdialogfragment, container, false)
    }

    override fun onStart() {
        super.onStart()
        setFindViewById()
        setTitle()
        setMessage()
    }

    private fun setBackGround(){
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.rounded_corner);
    }

    private fun setFindViewById(){
        titleTextView = dialog!!.window?.findViewById(R.id.alertdialog_title)!!
        messageTextView = dialog!!.window?.findViewById(R.id.alertdialog_message)!!
    }

    private fun setTitle(){
        titleTextView.text = title
    }

    private fun setMessage(){
        messageTextView.text = message
    }

    override fun onResume() {
        super.onResume()
        setSize()
    }

    private fun setSize(){
        val width = resources.getDimensionPixelSize(R.dimen.loading_dialog_width)
        val height = resources.getDimensionPixelSize(R.dimen.alert_dialog_heigth)
        dialog!!.window!!.setLayout(width, height)
    }

    companion object {
        fun newInstance(title: String, message: String): AlertDialogFragment {
            return AlertDialogFragment(title, message)
        }
    }
}