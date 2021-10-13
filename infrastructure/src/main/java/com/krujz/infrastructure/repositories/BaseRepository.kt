package com.krujz.infrastructure.repositories

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

abstract class BaseRepository {
    protected val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private lateinit var errorMessage: String
    fun getErrorMessage() : String{ return errorMessage }

    protected fun setErrorMessage(errorMessage: String){
        this.errorMessage = errorMessage
    }
}