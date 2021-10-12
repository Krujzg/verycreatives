package com.krujz.verycreatives.screens.common.contracts

class MovieDetailsContract {

    interface View: BaseContract.View {

    }

    interface Presenter: BaseContract.Presenter<View> {
       fun loadSelectedMovie(id: Int)
    }
}