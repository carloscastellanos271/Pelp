package com.example.pelp.repository

import com.example.pelp.domain.model.Recipe

interface RecipeRepository {

    suspend fun search(token: String, page: Int, query: String): List<Recipe>

    suspend fun get(token: String, id: Int): Recipe

}

//interface PelpRepository {
//
//    suspend fun search(authHeader: String, term: String, location: String)
//
//}