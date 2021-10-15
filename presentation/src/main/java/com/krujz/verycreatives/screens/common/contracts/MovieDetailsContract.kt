package com.krujz.verycreatives.screens.common.contracts

import com.krujz.domain.models.MovieModel

interface MovieDetailsContract {

    interface View: BaseContract.View {

    }

    interface Presenter: BaseContract.Presenter<View> {
        suspend fun getSelectedMovie(movieId: Int): MovieModel?
        suspend fun getSelectedMovieFavoriteStatus(movieId: Int): Boolean
        suspend fun deleteSelectedFavoriteMovie()
        suspend fun addFavoriteMovie()
    }
}