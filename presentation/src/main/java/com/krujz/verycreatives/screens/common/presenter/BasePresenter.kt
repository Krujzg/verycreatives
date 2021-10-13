package com.krujz.verycreatives.screens.common.presenter

open class BasePresenter {

    private lateinit var errorMessage: String
    fun getErrorMessage() : String{ return errorMessage }

    protected fun setErrorMessage(errorMessage: String){
        this.errorMessage = errorMessage
    }
}