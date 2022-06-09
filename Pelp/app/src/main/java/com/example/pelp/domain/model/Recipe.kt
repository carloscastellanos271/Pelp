package com.example.pelp.domain.model

import com.google.gson.annotations.SerializedName


//This is the domain model, kinda like the core business model for the project
//This goes into the EntityMapper interface as an argument

data class Recipe(
    val id: Int? = null,
    val title: String? = null,
    val publisher: String? = null,
    val featuredImage: String? = null,
    val rating: Int? = 0,
    val sourceUrl: String? = null,
    val description: String? = null,
    val cookingInstructions: String? = null,
    val ingredients: List<String> = listOf(),
    val dateAdded: String? = null,
    val dateUpdated: String? = null,

)


// Yelp code


data class Pelp(
    val name: String? = null,
    val rating: Double? = null,
    val price:String? = null,
    val numReviews: Int? = null,
    val imageUrl: String? = null,

)