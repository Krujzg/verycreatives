package com.krujz.application

import com.krujz.application.entities.MovieEntity

sealed class Result {
    class Success(val wasSuccessFull: Boolean) : Result()
    class Failure(val errorMessage: String) : Result()
}

abstract class MovieDetailsResult : Result() {
    data class SingleItemSuccess(val movie : MovieEntity) : MovieDetailsResult()
    data class CollectionSuccess(val movies: Collection<MovieEntity>) : MovieDetailsResult()
}