package com.krujz.verycreatives.screens.common.contracts

interface MainContract {

    interface View: BaseContract.View {
        fun showHomeFragment()
        fun showMovieDetailFragment()
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun onDrawerOptionAboutClick()
    }
}