package com.krujz.verycreatives.screens.common.contracts

interface MovieDetailsContract {

    interface View: BaseContract.View {

    }

    interface Presenter: BaseContract.Presenter<View> {
       fun loadSelectedMovie(id: Int)
    }
}