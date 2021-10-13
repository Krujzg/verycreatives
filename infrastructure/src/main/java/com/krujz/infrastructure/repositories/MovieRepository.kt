package com.krujz.infrastructure.repositories

import com.krujz.application.MovieDetailsResult.CollectionSuccess
import com.krujz.application.MovieDetailsResult.SingleItemSuccess
import com.krujz.application.Result.Failure
import com.krujz.application.entities.MovieEntity
import com.krujz.application.repository_interfaces.IMovieRepository
import com.krujz.application.usecase_interfaces.IFetchMovieUseCase
import kotlinx.coroutines.launch

class MovieRepository(private val fetchMovieUseCase: IFetchMovieUseCase) : IMovieRepository, BaseRepository() {

    private val topRatedMovies : ArrayList<MovieEntity> = arrayListOf()
    private val popularMovies : ArrayList<MovieEntity> = arrayListOf()
    private var selectedMovie : MovieEntity? = null

    override suspend fun getCollectionOfPopularMovies(
        apiKey: String,
        page: Int
    ): Collection<MovieEntity> {
        return when(popularMovies.isEmpty()){
            true -> startFetchingCollectionOfPopularMovies(apiKey, page)
            false -> popularMovies
        }
    }

    private suspend fun startFetchingCollectionOfPopularMovies(apiKey: String,
                                                       page: Int) : Collection<MovieEntity>{
        coroutineScope.launch {
            try {
                val result = fetchMovieUseCase.fetchCollectionOfPopularMovies(apiKey, page)
                when (result) {
                    is CollectionSuccess -> popularMovies.addAll(result.movies)
                    is Failure -> {
                        popularMovies.clear()
                        setErrorMessage(result.errorMessage)
                    }
                }
            }
            catch (e: Exception) {  }
        }.join()
        return popularMovies
    }

    override suspend fun getCollectionOfTopRatedMovies(
        apiKey: String,
        page: Int
    ): Collection<MovieEntity> {
        return when(topRatedMovies.isEmpty()){
            true -> startFetchingCollectionOfTopRatedMovies(apiKey, page)
            false -> topRatedMovies
        }
    }

    private suspend fun startFetchingCollectionOfTopRatedMovies(apiKey: String,
                                                               page: Int) : Collection<MovieEntity>{
        coroutineScope.launch {
            try {
                val result = fetchMovieUseCase.fetchCollectionOfTopRatedMovies(apiKey, page)
                when (result) {
                    is CollectionSuccess -> topRatedMovies.addAll(result.movies)
                    is Failure -> {
                        topRatedMovies.clear()
                        setErrorMessage(result.errorMessage)
                    }
                }
            }
            catch (e: Exception) {  }
        }.join()
        return topRatedMovies
    }

    override suspend fun getSelectedMovieById(apiKey: String, movieId: Int): MovieEntity? {
        return when(selectedMovie == null){
            true -> startFetchingSelectedMovieById(apiKey, movieId)
            false -> selectedMovie
        }
    }

    private suspend fun startFetchingSelectedMovieById(apiKey: String, movieId: Int) : MovieEntity?{
        coroutineScope.launch {
            try {
                val result = fetchMovieUseCase.fetchSelectedMovieById(apiKey, movieId)
                when (result) {
                    is SingleItemSuccess -> selectedMovie = result.movie
                    is Failure -> {
                        selectedMovie = null
                        setErrorMessage(result.errorMessage)
                    }
                }
            }
            catch (e: Exception) {  }
        }.join()
        return selectedMovie
    }
}