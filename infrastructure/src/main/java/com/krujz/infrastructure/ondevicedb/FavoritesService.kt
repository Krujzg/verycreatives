package com.krujz.infrastructure.ondevicedb

import android.app.Application
import com.krujz.application.services.IFavoriteMoviesService
import com.krujz.domain.models.MovieModel

class FavoritesService(application: Application) : IFavoriteMoviesService {
    private val movieDao : MovieDao = MovieOnDeviceDatabase
        .getDatabase(application)
        .movieDao()

    private lateinit var arrayOfFavoriteMovies: Array<MovieModel>

    override suspend fun getAllFavoriteMoviesFromOnDeviceDataBase(): Array<MovieModel> {
        arrayOfFavoriteMovies = movieDao.getAllMovies()
        return arrayOfFavoriteMovies
    }

    override suspend fun getSelectedMovieFavoriteStatus(movieId : Int): Boolean {
        return movieDao.getSelectedMovieFavoriteStatus(movieId) != null
    }

    override suspend fun getSelectedMovie(movieId : Int): MovieModel? {
        return movieDao.getSelectedMovieFavoriteStatus(movieId)
    }

    override suspend fun addNewMovieToTheOnDeviceDb(movieModel: MovieModel){
        movieDao.addNewMovie(movieModel)
    }

    override suspend fun deleteSelectedMovieFromTheOnDeviceDb(movieModel: MovieModel) {
        movieDao.deleteMovie(movieModel)
    }
}