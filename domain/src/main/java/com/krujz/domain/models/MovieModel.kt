package com.krujz.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="movie_db")
data class MovieModel(
    @PrimaryKey(autoGenerate = false)
    val id : Int,

    @ColumnInfo(name="isAdult")
    val isAdult: Boolean,

    @ColumnInfo(name="backDropPath")
    val backDropPath : String,

    @ColumnInfo(name="budget")
    val budget: Int,

    @ColumnInfo(name="originalLanguage")
    val originalLanguage : String,

    @ColumnInfo(name="originalTitle")
    val originalTitle: String,

    @ColumnInfo(name="overview")
    val overview: String,

    @ColumnInfo(name="popularity")
    val popularity: Double,

    @ColumnInfo(name="posterPath")
    val posterPath : String,

    @ColumnInfo(name="releaseDate")
    val releaseDate: String,

    @ColumnInfo(name="revenue")
    val revenue: Int,

    @ColumnInfo(name="runtime")
    val runtime : Int,

    @ColumnInfo(name="title")
    val title : String,

    @ColumnInfo(name="isThereAVideo")
    val isThereAVideo: Boolean,

    @ColumnInfo(name="voteAverage")
    val voteAverage:Double,

    @ColumnInfo(name="voteCount")
    val voteCount: Int,

    @ColumnInfo(name="isFavorite")
    var isFavorite: Boolean = false,

    @ColumnInfo(name="fromTopRated")
    var fromTopRated: Boolean = false,

    @ColumnInfo(name="fromPopular")
    var fromPopular: Boolean = false
)