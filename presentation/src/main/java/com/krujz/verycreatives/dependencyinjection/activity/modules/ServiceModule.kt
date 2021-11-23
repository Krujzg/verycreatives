package com.krujz.verycreatives.dependencyinjection.activity.modules

import android.app.Application
import com.krujz.application.services.IFavoriteMoviesService
import com.krujz.infrastructure.ondevicedb.FavoritesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object ServiceModule {

    @Provides
    @ActivityScoped
    fun favoriteService(application: Application) : IFavoriteMoviesService{
        return FavoritesService(application)
    }
}