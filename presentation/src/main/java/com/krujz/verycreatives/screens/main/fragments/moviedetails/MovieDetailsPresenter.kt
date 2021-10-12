package com.krujz.verycreatives.screens.main.fragments.moviedetails

import com.krujz.application.usecase_interfaces.IFetchMovieUseCase
import com.krujz.verycreatives.screens.common.contracts.MovieDetailsContract
import javax.inject.Inject

class MovieDetailsPresenter : MovieDetailsContract.Presenter {

    @Inject
    lateinit var useCase: IFetchMovieUseCase

    override fun loadSelectedMovie(id: Int) {
        TODO("Not yet implemented")
    }

    override fun attach(view: MovieDetailsContract.View) {
        TODO("Not yet implemented")
    }
}