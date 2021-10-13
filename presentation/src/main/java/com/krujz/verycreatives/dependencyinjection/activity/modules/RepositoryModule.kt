package com.krujz.verycreatives.dependencyinjection.activity.modules

import com.krujz.application.repository_interfaces.IMovieRepository
import com.krujz.application.usecase_interfaces.IFetchMovieUseCase
import com.krujz.infrastructure.repositories.MovieRepository
import dagger.Module
import dagger.Provides

@Module
object RepositoryModule {
    @Provides
    fun movieRepository(fetchMovieUseCase: IFetchMovieUseCase) : IMovieRepository{
        return MovieRepository(fetchMovieUseCase)
    }
}