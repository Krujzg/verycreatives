package com.krujz.domain.models

import com.google.gson.annotations.SerializedName

data class ErrorBody(
    @SerializedName("hydra:title") var errorTitle :String? = null,
    @SerializedName("hydra:description") var errorMessage :String? = null
)
