package com.krujz.infrastructure.usecases

import com.google.gson.Gson
import com.krujz.application.Result.*
import com.krujz.application.usecase_interfaces.IBaseFetchUseCase
import com.krujz.domain.models.ErrorBody
import okhttp3.ResponseBody
import kotlin.coroutines.cancellation.CancellationException
import com.krujz.application.Result

abstract class BaseFetchUseCase : IBaseFetchUseCase {

    override fun checkIfErrorMessageIsNotNullOrNotEmpty(errorMessage: String?): Boolean{
        return !errorMessage.isNullOrEmpty()
    }

    override fun getConvertedErrorBody(errorBody: ResponseBody?): ErrorBody {
        return Gson().fromJson(errorBody!!.charStream(), ErrorBody::class.java)
    }

    override fun whenErrorOccursSetTheErrorMessage(errorBody: ErrorBody): Result {
        return when(checkIfErrorMessageIsNotNullOrNotEmpty(errorBody.errorMessage)){
            true  -> Failure(errorBody.errorMessage!!)
            false -> Failure("Sikertelen letöltés")
        }
    }

    override fun catchError(t: Throwable) : Result {
        return when (t){
            is CancellationException -> throw t
            else -> Failure(t.message!!)
        }
    }
}