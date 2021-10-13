package com.krujz.application.repository_interfaces

import com.krujz.application.entities.MovieEntity
import com.krujz.domain.models.MovieModel


interface IMovieRepository {
    suspend fun getCollectionOfPopularMovies(apiKey: String, page: Int): Collection<MovieEntity>
    suspend fun getCollectionOfTopRatedMovies(apiKey: String, page: Int): Collection<MovieEntity>
    suspend fun getSelectedMovieById(apiKey: String, movieId: Int): MovieEntity?
}