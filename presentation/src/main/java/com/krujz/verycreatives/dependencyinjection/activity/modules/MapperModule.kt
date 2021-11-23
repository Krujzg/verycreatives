package com.krujz.verycreatives.dependencyinjection.activity.modules

import com.krujz.application.entities.MovieEntity
import com.krujz.application.mappers.ICollectionItemsMapper
import com.krujz.application.mappers.IMovieDataModelMapper
import com.krujz.application.mappers.ISingleItemMapper
import com.krujz.domain.models.MovieItemData
import com.krujz.domain.models.MovieModel
import com.krujz.verycreatives.mappers.MovieMovieDataMapper
import com.krujz.verycreatives.mappers.MovieMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object MapperModule {

    @Provides
    fun singleItemMapper() : ISingleItemMapper<MovieEntity, MovieModel>{
        return MovieMapper()
    }

    @Provides
    fun collectionMapper() : ICollectionItemsMapper<MovieEntity, MovieModel>{
        return MovieMapper()
    }

    @Provides
    fun domainToGridWrapperMapper() : IMovieDataModelMapper<MovieModel, MovieItemData>{
        return MovieMovieDataMapper()
    }
}