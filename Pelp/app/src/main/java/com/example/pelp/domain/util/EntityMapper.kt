package com.example.pelp.domain.util

//mapping recipe to a network entity

interface EntityMapper <T, DomainModel> {

    fun mapToDomainModel(model: T): DomainModel

    fun mapFromDomainModel(domainModel: DomainModel) : T
}