package com.krujz.verycreatives.mappers

import com.krujz.application.entities.MovieEntity
import com.krujz.application.mappers.ICollectionItemsMapper
import com.krujz.application.mappers.ISingleItemMapper
import com.krujz.domain.models.MovieModel

class MovieMapper : ISingleItemMapper<MovieEntity, MovieModel>, ICollectionItemsMapper<MovieEntity, MovieModel> {
    override fun mapToDomain(entity: MovieEntity): MovieModel {
        return MovieModel(
            id = entity.id,
            isAdult = entity.isAdult,
            backDropPath = entity.backDropPath,
            budget = entity.budget,
            originalLanguage = entity.originalLanguage,
            originalTitle = entity.originalTitle,
            overview = entity.overview,
            popularity = entity.popularity,
            posterPath = entity.posterPath,
            releaseDate = entity.releaseDate,
            revenue = entity.revenue,
            runtime = entity.runtime,
            title = entity.title,
            isThereAVideo = entity.isThereAVideo,
            voteAverage = entity.voteAverage,
            voteCount = entity.voteCount
        )
    }

    override fun mapToEntity(domainModel: MovieModel): MovieEntity {
        return MovieEntity(
            id = domainModel.id,
            isAdult = domainModel.isAdult,
            backDropPath = domainModel.backDropPath,
            budget = domainModel.budget,
            originalLanguage = domainModel.originalLanguage,
            originalTitle = domainModel.originalTitle,
            overview = domainModel.overview,
            popularity = domainModel.popularity,
            posterPath = domainModel.posterPath,
            releaseDate = domainModel.releaseDate,
            revenue = domainModel.revenue,
            runtime = domainModel.runtime,
            title = domainModel.title,
            isThereAVideo = domainModel.isThereAVideo,
            voteAverage = domainModel.voteAverage,
            voteCount = domainModel.voteCount,

        )
    }

    override fun mapToCollectionEntity(collectionOfDomains: Collection<MovieModel>): Collection<MovieEntity> {
        return collectionOfDomains.map { mapToEntity(it) }
    }

    override fun mapToCollectionDomain(collectionOfEntities: Collection<MovieEntity>): Collection<MovieModel> {
        return collectionOfEntities.map { mapToDomain(it) }
    }
}