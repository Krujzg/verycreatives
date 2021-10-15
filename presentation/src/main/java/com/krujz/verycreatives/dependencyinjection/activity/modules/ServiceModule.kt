package com.krujz.verycreatives.dependencyinjection.activity.modules

import android.app.Application
import com.krujz.application.services.IFavoriteMoviesService
import com.krujz.infrastructure.ondevicedb.FavoritesService
import dagger.Module
import dagger.Provides

@Module
object ServiceModule {

    @Provides
    fun favoriteService(application: Application) : IFavoriteMoviesService{
        return FavoritesService(application)
    }
}