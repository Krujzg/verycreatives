package com.krujz.verycreatives.dependencyinjection.activity.modules

import com.krujz.application.MovieApi
import com.krujz.application.usecase_interfaces.IFetchMovieUseCase
import com.krujz.infrastructure.usecases.FetchMovieUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object UseCaseModule {

    @Provides
    @ActivityScoped
    fun movieUseCase(movieApi: MovieApi): IFetchMovieUseCase{
        return FetchMovieUseCase(movieApi)
    }
}