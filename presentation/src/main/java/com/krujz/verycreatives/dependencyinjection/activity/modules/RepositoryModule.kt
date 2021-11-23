package com.krujz.verycreatives.dependencyinjection.activity.modules

import com.krujz.application.repository_interfaces.IMovieRepository
import com.krujz.application.usecase_interfaces.IFetchMovieUseCase
import com.krujz.infrastructure.repositories.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object RepositoryModule {
    @Provides
    @ActivityScoped
    fun movieRepository(fetchMovieUseCase: IFetchMovieUseCase) : IMovieRepository{
        return MovieRepository(fetchMovieUseCase)
    }
}