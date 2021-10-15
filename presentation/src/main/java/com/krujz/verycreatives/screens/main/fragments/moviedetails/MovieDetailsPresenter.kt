package com.krujz.verycreatives.screens.main.fragments.moviedetails

import com.krujz.application.entities.MovieEntity
import com.krujz.application.mappers.ISingleItemMapper
import com.krujz.application.repository_interfaces.IMovieRepository
import com.krujz.application.services.IFavoriteMoviesService
import com.krujz.domain.models.MovieModel
import com.krujz.verycreatives.BuildConfig
import com.krujz.verycreatives.screens.common.contracts.MovieDetailsContract

class MovieDetailsPresenter(private val service: IFavoriteMoviesService,
                            private val repository: IMovieRepository,
                            private val entityToDomainMapper: ISingleItemMapper<MovieEntity, MovieModel>
) : MovieDetailsContract.Presenter {

    private var currentMovie: MovieModel? = null
    private val apiKey = BuildConfig.apiKey
    private lateinit var view: MovieDetailsContract.View

    override suspend fun getSelectedMovie(movieId: Int) :MovieModel?{
        val currentMovieEntity = loadSelectedMovie(movieId)
        return when(checkIfCurrentMovieEntityIsNotNull(currentMovieEntity)){
            true -> {
                currentMovie = entityToDomainMapper.mapToDomain(currentMovieEntity!!)
                currentMovie
            }
            false -> null
        }
    }

    private suspend fun loadSelectedMovie(movieId: Int): MovieEntity? {
        return repository.getSelectedMovieById(apiKey, movieId)
    }

    private fun checkIfCurrentMovieEntityIsNotNull(currentMovieEntity: MovieEntity?) : Boolean{
        return currentMovieEntity != null
    }

    override suspend fun getSelectedMovieFavoriteStatus(movieId: Int): Boolean {
       return service.getSelectedMovieFavoriteStatus(movieId)
    }

    override suspend fun deleteSelectedFavoriteMovie() {
        when(checkIfCurrentMovieModelIsNotNull()){
            true -> {
                currentMovie!!.isFavorite = false
                service.deleteSelectedMovieFromTheOnDeviceDb(currentMovie!!)
            }
        }
    }

    private fun checkIfCurrentMovieModelIsNotNull() : Boolean{
        return currentMovie != null
    }

    override suspend fun addFavoriteMovie() {
        when(checkIfCurrentMovieModelIsNotNull()){
            true -> {
                currentMovie!!.isFavorite = true
                service.addNewMovieToTheOnDeviceDb(currentMovie!!)
            }
        }
    }

    override fun attach(view: MovieDetailsContract.View) {
        this.view = view
    }
}