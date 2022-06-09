package com.codingwithmitch.recipeapp.repository

import com.example.pelp.domain.model.Pelp
import com.example.pelp.network.YelpService
import com.example.pelp.network.model.PelpDtoMapper

class PelpRepository_Impl(
    private val pelpService: YelpService,
    private val mapper: PelpDtoMapper
): PelpRepository {

    override suspend fun search(
        authHeader: String,
        searchTerm: String,
        location: String
    ): List<Pelp> {
        val result = pelpService.search(authHeader, searchTerm, location).restaurants
        return mapper.toDomainList(result)
    }
}