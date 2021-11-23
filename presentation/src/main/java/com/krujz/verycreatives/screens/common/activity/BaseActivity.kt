package com.krujz.verycreatives.screens.common.activity

import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.krujz.verycreatives.BaseApplication
import com.krujz.verycreatives.R
import com.krujz.verycreatives.dependencyinjection.activity.modules.*

open class BaseActivity : AppCompatActivity() {

    protected var doesBackToExitPressedTwice: Boolean = false

    protected fun showMessageBox(text: String) { Toast.makeText(this, text, Toast.LENGTH_SHORT).show() }

    override fun onBackPressed() {
        when(doesBackToExitPressedTwice) {
            true  ->  finishAffinity()
            false ->  delaySecondBackButtonPress()
        }
    }

    protected fun delaySecondBackButtonPress(){
        delayTimeBetweenTwoBackButtonPress()
        showMessageBox(getString(R.string.press_again_to_quit))
    }

    private fun delayTimeBetweenTwoBackButtonPress() {
        this.doesBackToExitPressedTwice = true
        Handler().postDelayed({ doesBackToExitPressedTwice = false }, 2000)
    }
}