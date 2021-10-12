package com.krujz.application.entities.responseschemas

import com.google.gson.annotations.SerializedName
import com.krujz.application.entities.MovieEntity

data class MovieCollectionResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: Collection<MovieEntity>
)
