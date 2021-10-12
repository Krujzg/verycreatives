package com.krujz.application.entities

import com.google.gson.annotations.SerializedName

data class LanguageEntity (
    @SerializedName("english_name") val englishName : String,
    @SerializedName("iso_639_1") val lang: String,
    @SerializedName("name") val name: String,
)