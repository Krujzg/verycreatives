package com.krujz.verycreatives.screens.main.fragments.favorites

import com.krujz.application.services.IFavoriteMoviesService
import com.krujz.domain.models.MovieModel
import com.krujz.verycreatives.screens.common.contracts.FavoritesContract
import com.krujz.verycreatives.screens.common.presenter.BasePresenter

class FavoritesFragmentPresenter constructor(private val service: IFavoriteMoviesService): BasePresenter(), FavoritesContract.Presenter {

    private lateinit var view: FavoritesContract.View

    override suspend fun getFavoriteMovies(): Collection<MovieModel> {
        return service.getAllFavoriteMoviesFromOnDeviceDataBase().asList()
    }

    override fun attach(view: FavoritesContract.View) {
        this.view = view
    }
}