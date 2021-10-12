package com.krujz.verycreatives.screens.main.fragments.home

import com.krujz.application.MovieDetailsResult.CollectionSuccess
import com.krujz.application.Result.Failure
import com.krujz.application.entities.MovieEntity
import com.krujz.application.mappers.ICollectionItemsMapper
import com.krujz.application.usecase_interfaces.IFetchMovieUseCase
import com.krujz.domain.models.MovieModel
import com.krujz.verycreatives.BuildConfig
import com.krujz.verycreatives.screens.common.contracts.HomeContract
import com.krujz.verycreatives.screens.common.presenter.BasePresenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragmentPresenter : BasePresenter(), HomeContract.Presenter {

    @Inject
    lateinit var useCase: IFetchMovieUseCase

    @Inject
    private lateinit var mapper : ICollectionItemsMapper<MovieEntity, MovieModel>

    private lateinit var view: HomeContract.View

    override fun openMovieDetails() {
    }

    override suspend fun getPopularMovies(page: Int): Collection<MovieModel>{
        val collection = loadAllPopularMovies(page)
        return mapper.mapToCollectionDomain(collection)
    }

     suspend fun loadAllPopularMovies(page: Int): Collection<MovieEntity> {
        var collectionOfPopularMovies : Collection<MovieEntity> = arrayListOf()
            try {
                val result = useCase.fetchCollectionOfPopularMovies(BuildConfig.apiKey, page)
                when(result){
                    is CollectionSuccess -> collectionOfPopularMovies = result.movies
                    is Failure -> setErrorMessage(result.errorMessage)
                }
            }
            catch (e: Exception){

            }
        return collectionOfPopularMovies
    }

    override suspend fun getTopRatedMovies(page: Int): Collection<MovieModel>{
        val collection = loadAllTopRatedMovies(page)
        return mapper.mapToCollectionDomain(collection)
    }

    suspend fun loadAllTopRatedMovies(page: Int) : Collection<MovieEntity> {
        var collectionOfTopRatedMovies : Collection<MovieEntity> = arrayListOf()
        coroutineScope.launch {
            try {
                val result = useCase.fetchCollectionOfPopularMovies(BuildConfig.apiKey, page)
                when(result){
                    is CollectionSuccess -> collectionOfTopRatedMovies = result.movies
                    is Failure -> setErrorMessage(result.errorMessage)
                }
            }
            catch (e: Exception){

            }
        }.join()
        return collectionOfTopRatedMovies
    }

    override fun attach(view: HomeContract.View) {
        this.view = view
    }
}