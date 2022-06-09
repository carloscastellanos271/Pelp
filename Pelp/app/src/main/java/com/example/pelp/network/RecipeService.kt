package com.example.pelp.network

import com.example.pelp.network.model.PelpDto
import com.example.pelp.network.model.RecipeDto
import com.example.pelp.network.responses.PelpSearchResponse
import com.example.pelp.network.responses.RecipeSearchResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RecipeService {
    @GET("search")
    suspend fun search(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): RecipeSearchResponse

    @GET("get")
    suspend fun get(
        @Header("Authorization") token: String,
        @Query("id") id: Int
    ): RecipeDto

}

interface YelpService {
    @GET("businesses/search")
     suspend fun search(
        @Header("Authorization") authHeader: String,
        @Query("term") searchTerm: String,
        @Query("location") location: String) : PelpSearchResponse
}