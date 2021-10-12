package com.krujz.verycreatives.screens.common.presenter

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

open class BasePresenter {
    protected val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private lateinit var errorMessage: String
    fun getErrorMessage() : String{ return errorMessage }

    protected fun setErrorMessage(errorMessage: String){
        this.errorMessage = errorMessage
    }
}