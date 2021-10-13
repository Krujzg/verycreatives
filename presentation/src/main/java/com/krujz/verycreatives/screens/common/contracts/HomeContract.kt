package com.krujz.verycreatives.screens.common.contracts

import com.krujz.domain.models.GridMovieDataWrapper
import com.krujz.domain.models.MovieModel

interface HomeContract {

    interface View: BaseContract.View {

    }

    interface Presenter: BaseContract.Presenter<View> {
        fun openMovieDetails()
        suspend fun getPopularMovies(page: Int) : Collection<MovieModel>
        suspend fun getTopRatedMovies(page: Int): Collection<MovieModel>
        suspend fun getCollectionOfTopRatedGridMovieDataWrappers(page: Int): Collection<GridMovieDataWrapper>
        suspend fun getCollectionOfPopularGridMovieDataWrappers(page: Int): Collection<GridMovieDataWrapper>

    }
}