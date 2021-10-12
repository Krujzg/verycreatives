package com.krujz.application.usecase_interfaces

import com.krujz.domain.models.ErrorBody
import okhttp3.ResponseBody
import com.krujz.application.Result

interface IBaseFetchUseCase {
    fun checkIfErrorMessageIsNotNullOrNotEmpty(errorMessage: String?): Boolean

    fun getConvertedErrorBody(errorBody: ResponseBody?): ErrorBody

    fun whenErrorOccursSetTheErrorMessage(errorBody: ErrorBody): Result

    fun catchError(t: Throwable) : Result
}