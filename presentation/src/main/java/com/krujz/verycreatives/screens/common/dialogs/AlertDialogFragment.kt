package com.krujz.verycreatives.screens.common.dialogs

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.krujz.verycreatives.R
import com.krujz.verycreatives.screens.common.ISelectorOnButtonClick
import com.krujz.verycreatives.screens.main.MainActivity


class AlertDialogFragment : BaseDialog() {

    private lateinit var alertdialog_show_popular_button_selector : AppCompatButton
    private lateinit var alertdialog_show_top_rated_button_selector: AppCompatButton

    var listener: ISelectorOnButtonClick ? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as ISelectorOnButtonClick
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBackGround()
        return requireActivity().layoutInflater.inflate(R.layout.custom_select_between_options_alertdialogfragment, container, false)
    }

    private fun sendSelectedDataToTheFragment(movieTag: String){
        listener!!.onSelectorButtonClick(movieTag)
        dismiss()
    }

    override fun onStart() {
        super.onStart()
        setFindViewByIds()
        setUpPopularButtonClickListener()
        setUpTopRatedButtonClickListener()
    }

    private fun setFindViewByIds(){
        alertdialog_show_popular_button_selector = dialog!!.window?.findViewById(R.id.alertdialog_show_popular_button_selector)!!
        alertdialog_show_top_rated_button_selector = dialog!!.window?.findViewById(R.id.alertdialog_show_top_rated_button_selector)!!
    }

    private fun setUpPopularButtonClickListener(){
        alertdialog_show_popular_button_selector.setOnClickListener{
            sendSelectedDataToTheFragment(POPULAR_TAG)
        }
    }

    private fun setUpTopRatedButtonClickListener(){
        alertdialog_show_top_rated_button_selector.setOnClickListener{
            sendSelectedDataToTheFragment(TOP_RATED_TAG)
        }
    }

    private fun setBackGround(){
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.rounded_corner);
    }

    companion object {
        fun newInstance(): AlertDialogFragment {
            return AlertDialogFragment()
        }
        const val POPULAR_TAG = "popular"
        const val TOP_RATED_TAG = "top rated"
    }
}