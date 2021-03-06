package com.krujz.verycreatives.mappers

import com.krujz.application.mappers.IMovieDataModelMapper
import com.krujz.domain.models.MovieItemData
import com.krujz.domain.models.MovieModel

class MovieMovieDataMapper : IMovieDataModelMapper<MovieModel, MovieItemData> {

    override fun mapToDomain(domain: MovieModel): MovieItemData {
       return MovieItemData(
           id = domain.id,
           title = domain.title,
           posterPath = domain.posterPath,
           voteAverage = domain.voteAverage
       )
    }

    override fun mapToCollectionOfGridDataWrapper(collectionOfDomain: Collection<MovieModel>): Collection<MovieItemData> {
       return collectionOfDomain.map { mapToDomain(it) }
    }
}