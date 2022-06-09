package com.codingwithmitch.recipeapp.repository

import com.example.pelp.domain.model.Pelp
import com.example.pelp.network.model.PelpDto

interface PelpRepository {

    suspend fun search(authHeader: String, searchTerm: String, location: String): List<Pelp>

}