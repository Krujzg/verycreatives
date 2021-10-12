package com.krujz.application.mappers

interface ISingleItemMapper<Entity,Domain> {
    fun mapToDomain(entity: Entity) : Domain
    fun mapToEntity(domainModel: Domain): Entity
}