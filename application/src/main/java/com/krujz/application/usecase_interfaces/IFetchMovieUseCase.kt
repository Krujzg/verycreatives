package com.krujz.application.usecase_interfaces

import com.krujz.application.Result

interface IFetchMovieUseCase {
    suspend fun fetchCollectionOfPopularMovies(apiKey: String, page: Int): Result
    suspend fun fetchCollectionOfTopRatedMovies(apiKey: String, page: Int): Result
    suspend fun fetchSelectedMovieById(apiKey: String, movieId: Int): Result
}