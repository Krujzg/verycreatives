package com.krujz.application.services

import com.krujz.domain.models.MovieModel

interface IFavoriteMoviesService {
    suspend fun getAllFavoriteMoviesFromOnDeviceDataBase(): Array<MovieModel>
    suspend fun getSelectedMovieFavoriteStatus(movieId: Int): Boolean
    suspend fun addNewMovieToTheOnDeviceDb(movieModel: MovieModel)
    suspend fun deleteSelectedMovieFromTheOnDeviceDb(movieModel: MovieModel)
    suspend fun getSelectedMovie(movieId : Int): MovieModel?
}