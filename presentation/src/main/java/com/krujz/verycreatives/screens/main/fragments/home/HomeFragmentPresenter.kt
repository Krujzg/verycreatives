package com.krujz.verycreatives.screens.main.fragments.home

import com.krujz.application.entities.MovieEntity
import com.krujz.application.mappers.ICollectionItemsMapper
import com.krujz.application.mappers.IGridDataWrapperMapper
import com.krujz.application.repository_interfaces.IMovieRepository
import com.krujz.domain.models.MovieItemData
import com.krujz.domain.models.MovieModel
import com.krujz.verycreatives.BuildConfig
import com.krujz.verycreatives.screens.common.contracts.HomeContract
import com.krujz.verycreatives.screens.common.presenter.BasePresenter

class HomeFragmentPresenter constructor(private val repository: IMovieRepository,
                                        private val entityToDomainMapper: ICollectionItemsMapper<MovieEntity, MovieModel>,
                                        private val domainToMapperItem: IGridDataWrapperMapper<MovieModel, MovieItemData>
                                        ) : BasePresenter(), HomeContract.Presenter {

    private val apiKey = BuildConfig.apiKey

    private lateinit var view: HomeContract.View

    override fun openMovieDetails() {
    }

    override suspend fun getTopRatedMovies(page: Int): Collection<MovieItemData>{
        val collection = loadAllTopRatedMovies(page)
        val mappedCollection = entityToDomainMapper.mapToCollectionDomain(collection)
        return convertCollectionOfPopularMovies(mappedCollection)
    }

    private suspend fun loadAllTopRatedMovies(page: Int) : Collection<MovieEntity> {
        return repository.getCollectionOfPopularMovies(apiKey, page)
    }

    override suspend fun getPopularMovies(page: Int): Collection<MovieItemData>{
        val collection = loadAllPopularMovies(page)
        val mappedCollection = entityToDomainMapper.mapToCollectionDomain(collection)
        return convertCollectionOfPopularMovies(mappedCollection)
    }

    private suspend fun loadAllPopularMovies(page: Int): Collection<MovieEntity> {
        return repository.getCollectionOfPopularMovies(apiKey, page)
    }

    private fun convertCollectionOfPopularMovies(mappedCollection: Collection<MovieModel>): Collection<MovieItemData> {
        return domainToMapperItem.mapToCollectionOfGridDataWrapper(mappedCollection)
    }

    override fun attach(view: HomeContract.View) {
        this.view = view
    }
}