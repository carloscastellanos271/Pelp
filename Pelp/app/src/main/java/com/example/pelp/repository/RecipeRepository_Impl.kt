package com.example.pelp.repository

import com.example.pelp.domain.model.Recipe
import com.example.pelp.network.RecipeService
import com.example.pelp.network.model.RecipeDtoMapper

class RecipeRepository_Impl(
    private val recipeService: RecipeService,
    private val mapper: RecipeDtoMapper
): RecipeRepository {

    override suspend fun search(
        token: String,
        page: Int,
        query: String): List<Recipe> {
       val result = recipeService.search(token, page, query).recipes
        return mapper.toDomainList(result)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(recipeService.get(token, id))
    }

}