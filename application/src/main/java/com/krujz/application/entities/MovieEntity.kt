package com.krujz.application.entities

import com.google.gson.annotations.SerializedName

data class MovieEntity(
    @SerializedName("id") val id : Int,
    @SerializedName("adult") val isAdult: Boolean,
    @SerializedName("backdrop_path") val backDropPath : String,
    @SerializedName("belongs_to_collection") var isBelongToCollection : Boolean? = null,
    @SerializedName("budget") val budget: Int,
    @SerializedName("homepage") val homePage: String,
    @SerializedName("imdb_id") val imdbId: String,
    @SerializedName("original_language") val originalLanguage : String,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("poster_path") val posterPath : String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("revenue") val revenue: Int,
    @SerializedName("runtime") val runtime : Int,
    @SerializedName("status") val status: String,
    @SerializedName("tagline") val tagLine: String,
    @SerializedName("title") val title : String,
    @SerializedName("video") val isThereAVideo: Boolean,
    @SerializedName("vote_average") val voteAverage:Boolean,
    @SerializedName("vote_count") val voteCount: Int,
)