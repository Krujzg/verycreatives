package com.krujz.verycreatives.dependencyinjection.activity.modules

import androidx.fragment.app.FragmentManager
import com.krujz.application.entities.MovieEntity
import com.krujz.application.mappers.ICollectionItemsMapper
import com.krujz.application.mappers.IMovieDataModelMapper
import com.krujz.application.mappers.ISingleItemMapper
import com.krujz.application.repository_interfaces.IMovieRepository
import com.krujz.application.services.IFavoriteMoviesService
import com.krujz.domain.models.MovieItemData
import com.krujz.domain.models.MovieModel
import com.krujz.verycreatives.screens.common.contracts.FavoritesContract
import com.krujz.verycreatives.screens.common.contracts.HomeContract
import com.krujz.verycreatives.screens.common.contracts.MovieDetailsContract
import com.krujz.verycreatives.screens.common.dialogs.DialogNavigator
import com.krujz.verycreatives.screens.common.dialogs.interfaces.IDialogNavigator
import com.krujz.verycreatives.screens.main.fragments.favorites.FavoritesFragmentPresenter
import com.krujz.verycreatives.screens.main.fragments.home.HomeFragmentPresenter
import com.krujz.verycreatives.screens.main.fragments.moviedetails.MovieDetailsPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object FragmentModule {

    @Provides
    fun dialogNavigator(fragmentManager: FragmentManager) : IDialogNavigator = DialogNavigator(fragmentManager)

    @Provides
    fun homeFragmentPresenter(repository: IMovieRepository,
                              entityToDomainMapper: ICollectionItemsMapper<MovieEntity, MovieModel>,
                              domainToMapperItem: IMovieDataModelMapper<MovieModel, MovieItemData>): HomeContract.Presenter{
        return HomeFragmentPresenter(repository, entityToDomainMapper, domainToMapperItem)
    }

    @Provides
    fun favoriteMoviesFragmentPresenter(service: IFavoriteMoviesService): FavoritesContract.Presenter{
        return FavoritesFragmentPresenter(service)
    }

    @Provides
    fun movieDetailsFragmentPresenter(service: IFavoriteMoviesService,
                                      repository:IMovieRepository,
                                      entityToDomainMapper: ISingleItemMapper<MovieEntity, MovieModel>
    ): MovieDetailsContract.Presenter{
        return MovieDetailsPresenter(service, repository, entityToDomainMapper)
    }
}