package com.krujz.verycreatives.dependencyinjection.activity.modules

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.krujz.application.entities.MovieEntity
import com.krujz.application.mappers.ICollectionItemsMapper
import com.krujz.application.repository_interfaces.IMovieRepository
import com.krujz.domain.models.MovieModel
import com.krujz.verycreatives.dependencyinjection.activity.ActivityScope
import com.krujz.verycreatives.screens.common.contracts.HomeContract
import com.krujz.verycreatives.screens.common.contracts.MovieDetailsContract
import com.krujz.verycreatives.screens.common.dialogs.DialogNavigator
import com.krujz.verycreatives.screens.common.dialogs.interfaces.IDialogNavigator
import com.krujz.verycreatives.screens.common.imageloader.IImageLoader
import com.krujz.verycreatives.screens.common.imageloader.ImageLoader
import com.krujz.verycreatives.screens.main.fragments.home.HomeFragmentPresenter
import com.krujz.verycreatives.screens.main.fragments.moviedetails.MovieDetailsPresenter
import dagger.Module
import dagger.Provides

@Module
object FragmentModule {

    @Provides
    fun imageLoader(activity: AppCompatActivity) : IImageLoader = ImageLoader(activity)

    @Provides
    fun dialogNavigator(fragmentManager: FragmentManager) : IDialogNavigator = DialogNavigator(fragmentManager)

    @Provides
    fun homeFragmentPresenter(repository: IMovieRepository, mapper: ICollectionItemsMapper<MovieEntity, MovieModel>): HomeContract.Presenter{
        return HomeFragmentPresenter(repository, mapper)
    }

    @Provides
    fun movieDetailsFragmentPresenter(): MovieDetailsContract.Presenter{
        return MovieDetailsPresenter()
    }
}