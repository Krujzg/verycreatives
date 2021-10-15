package com.krujz.verycreatives.screens.common.contracts

import com.krujz.domain.models.MovieModel

interface FavoritesContract {

    interface View: BaseContract.View {

    }

    interface Presenter: BaseContract.Presenter<View> {
        suspend fun getFavoriteMovies() : Collection<MovieModel>
    }
}