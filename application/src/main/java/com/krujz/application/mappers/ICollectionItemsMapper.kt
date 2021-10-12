package com.krujz.application.mappers

interface ICollectionItemsMapper<Entity, Domain> {
    fun mapToCollectionEntity(collectionOfDomains: Collection<Domain>): Collection<Entity>
    fun mapToCollectionDomain(collectionOfEntities: Collection<Entity>): Collection<Domain>
}