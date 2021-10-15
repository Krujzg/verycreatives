package com.krujz.verycreatives.screens.common.contracts

import com.krujz.domain.models.MovieItemData

interface HomeContract {

    interface View: BaseContract.View {

    }

    interface Presenter: BaseContract.Presenter<View> {
        fun openMovieDetails()
        suspend fun getPopularMovies(page: Int) : Collection<MovieItemData>
        suspend fun getTopRatedMovies(page: Int): Collection<MovieItemData>
    }
}