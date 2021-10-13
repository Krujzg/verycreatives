package com.krujz.application.entities

import com.google.gson.annotations.SerializedName

data class MovieEntity(
    @SerializedName("id") val id : Int,
    @SerializedName("adult") val isAdult: Boolean,
    @SerializedName("backdrop_path") val backDropPath : String,
    @SerializedName("budget") val budget: Int,
    @SerializedName("original_language") val originalLanguage : String,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("poster_path") val posterPath : String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("revenue") val revenue: Int,
    @SerializedName("runtime") val runtime : Int,
    @SerializedName("title") val title : String,
    @SerializedName("video") val isThereAVideo: Boolean,
    @SerializedName("vote_average") val voteAverage:Double,
    @SerializedName("vote_count") val voteCount: Int,
)