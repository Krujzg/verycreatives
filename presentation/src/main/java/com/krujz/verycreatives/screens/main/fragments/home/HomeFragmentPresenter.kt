package com.krujz.verycreatives.screens.main.fragments.home

import com.krujz.application.entities.MovieEntity
import com.krujz.application.mappers.ICollectionItemsMapper
import com.krujz.application.repository_interfaces.IMovieRepository
import com.krujz.domain.models.MovieModel
import com.krujz.verycreatives.BuildConfig
import com.krujz.verycreatives.screens.common.contracts.HomeContract
import com.krujz.verycreatives.screens.common.presenter.BasePresenter
import javax.inject.Inject

class HomeFragmentPresenter constructor(private val repository: IMovieRepository, private val mapper: ICollectionItemsMapper<MovieEntity, MovieModel>) : BasePresenter(), HomeContract.Presenter {



    private val apiKey = BuildConfig.apiKey

    private lateinit var view: HomeContract.View

    override fun openMovieDetails() {
    }

    override suspend fun getPopularMovies(page: Int): Collection<MovieModel>{
        val collection = loadAllPopularMovies(page)
        return mapper.mapToCollectionDomain(collection)
    }

     private suspend fun loadAllPopularMovies(page: Int): Collection<MovieEntity> {
        return repository.getCollectionOfPopularMovies(apiKey, page)
    }

    override suspend fun getTopRatedMovies(page: Int): Collection<MovieModel>{
        val collection = loadAllTopRatedMovies(page)
        return mapper.mapToCollectionDomain(collection)
    }

    private suspend fun loadAllTopRatedMovies(page: Int) : Collection<MovieEntity> {
       return repository.getCollectionOfPopularMovies(apiKey, page)
    }

    override fun attach(view: HomeContract.View) {
        this.view = view
    }
}