package com.krujz.application.mappers

interface IGridDataWrapperMapper<Domain,GridData> {
    fun mapToDomain(domain: Domain) : GridData
    fun mapToCollectionOfGridDataWrapper(collectionOfDomain: Collection<Domain>): Collection<GridData>
}