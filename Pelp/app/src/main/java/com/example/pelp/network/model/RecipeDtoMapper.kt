package com.example.pelp.network.model

import com.example.pelp.domain.model.Pelp
import com.example.pelp.domain.model.Recipe

import com.example.pelp.domain.util.EntityMapper

class RecipeDtoMapper : EntityMapper<RecipeDto, Recipe> {

    override fun mapToDomainModel(model: RecipeDto): Recipe {
        return Recipe(

            id = model.pk,
            title = model.title,
            featuredImage = model.featuredImage,
            rating = model.rating,
            publisher = model.publisher,
            sourceUrl = model.sourceUrl,
            description = model.description,
            cookingInstructions = model.cookingInstructions,
            ingredients = model.ingredients ?: listOf(),
            dateAdded = model.dateAdded,
            dateUpdated = model.dateUpdated,

            )
    }

    override fun mapFromDomainModel(domainModel: Recipe): RecipeDto {
        return RecipeDto(

            pk = domainModel.id,
            title = domainModel.title,
            featuredImage = domainModel.featuredImage,
            rating = domainModel.rating,
            publisher = domainModel.publisher,
            sourceUrl = domainModel.sourceUrl,
            description = domainModel.description,
            cookingInstructions = domainModel.cookingInstructions,
            ingredients = domainModel.ingredients ?: listOf(),
            dateAdded = domainModel.dateAdded,
            dateUpdated = domainModel.dateUpdated,

            )
    }

    fun toDomainList(initial: List<RecipeDto>): List<Recipe> {
        return initial.map {
            mapToDomainModel(it)
        }
    }

    fun fromDomainList(initial: List<Recipe>): List<RecipeDto> {
        return initial.map { mapFromDomainModel(it) }
    }

}

class PelpDtoMapper : EntityMapper<PelpDto, Pelp> {

    override fun mapToDomainModel(model: PelpDto): Pelp {
       return Pelp(
           name = model.name,
           rating = model.rating,
           price = model.price,
           numReviews = model.numReviews,
           imageUrl = model.imageUrl,

       )
    }

    override fun mapFromDomainModel(domainModel: Pelp): PelpDto {
        return PelpDto(
            name = domainModel.name,
            rating = domainModel.rating,
            price = domainModel.price,
            numReviews = domainModel.numReviews,
            imageUrl = domainModel.imageUrl
        )
    }

    fun toDomainList(initial: List<PelpDto>): List<Pelp> {
        return initial.map {
            mapToDomainModel(it)
        }
    }

    fun fromDomainList(initial: List<Pelp>): List<PelpDto> {
        return initial.map { mapFromDomainModel(it) }
    }


}