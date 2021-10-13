package com.krujz.verycreatives.mappers

import com.krujz.application.mappers.IGridDataWrapperMapper
import com.krujz.domain.models.GridMovieDataWrapper
import com.krujz.domain.models.MovieModel

class GridMovieDataMapper : IGridDataWrapperMapper<MovieModel, GridMovieDataWrapper> {

    override fun mapToDomain(domain: MovieModel): GridMovieDataWrapper {
       return GridMovieDataWrapper(
           title = domain.title,
           posterPath = domain.posterPath,
           voteAverage = domain.voteAverage
       )
    }

    override fun mapToCollectionOfGridDataWrapper(collectionOfDomain: Collection<MovieModel>): Collection<GridMovieDataWrapper> {
       return collectionOfDomain.map { mapToDomain(it) }
    }
}