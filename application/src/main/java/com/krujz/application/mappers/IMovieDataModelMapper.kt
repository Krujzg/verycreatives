package com.krujz.application.mappers

interface IMovieDataModelMapper<Domain,GridData> {
    fun mapToDomain(domain: Domain) : GridData
    fun mapToCollectionOfGridDataWrapper(collectionOfDomain: Collection<Domain>): Collection<GridData>
}