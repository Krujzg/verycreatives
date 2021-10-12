package com.krujz.verycreatives.dependencyinjection.activity.modules

import com.krujz.verycreatives.screens.common.contracts.HomeContract
import com.krujz.verycreatives.screens.common.contracts.MovieDetailsContract
import com.krujz.verycreatives.screens.main.fragments.home.HomeFragmentPresenter
import com.krujz.verycreatives.screens.main.fragments.moviedetails.MovieDetailsPresenter
import dagger.Module
import dagger.Provides

@Module
object FragmentModule {

    @Provides
    fun homeFragmentPresenter(): HomeContract.Presenter{
        return HomeFragmentPresenter()
    }

    @Provides
    fun movieDetailsFragmentPresenter(): MovieDetailsContract.Presenter{
        return MovieDetailsPresenter()
    }
}