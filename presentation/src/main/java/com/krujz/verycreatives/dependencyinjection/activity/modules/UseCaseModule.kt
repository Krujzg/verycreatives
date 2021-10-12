package com.krujz.verycreatives.dependencyinjection.activity.modules

import com.krujz.application.MovieApi
import com.krujz.application.usecase_interfaces.IFetchMovieUseCase
import com.krujz.infrastructure.usecases.FetchMovieUseCase
import dagger.Module
import dagger.Provides

@Module
object UseCaseModule {

    @Provides
    fun movieUseCase(movieApi: MovieApi): IFetchMovieUseCase{
        return FetchMovieUseCase(movieApi)
    }
}