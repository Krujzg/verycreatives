package com.krujz.verycreatives.screens.common.contracts

interface MainContract {

    interface View: BaseContract.View {
        fun showHomeFragment(movieTypeTag: String)
        fun showFavoritesFragment()
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun onDrawerOptionAboutClick()
    }
}