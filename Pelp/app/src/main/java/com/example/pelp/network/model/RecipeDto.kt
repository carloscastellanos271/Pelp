package com.example.pelp.network.model


import com.google.gson.annotations.SerializedName

// This goes into the EntityMapper interface as the Entity
// this models what stuff looks like coming from the network
data class RecipeDto(

    @SerializedName("pk")
    var pk: Int? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("publisher")
    var publisher: String? = null,

    @SerializedName("rating")
    var rating: Int? = null,

    @SerializedName("featured_image")
    var featuredImage: String? = null,

    @SerializedName("source_url")
    var sourceUrl: String? = null,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("cooking_instructions")
    var cookingInstructions: String? = null,

    @SerializedName("ingredients")
    var ingredients: List<String>? = null,

    @SerializedName("date_added")
    var dateAdded: String? = null,

    @SerializedName("date_updated")
    var dateUpdated: String? = null,

)

data class PelpDto(

    @SerializedName("name") val name: String? = null,
    @SerializedName("rating") val rating: Double? = null,
    @SerializedName("price") val price: String? = null,
    @SerializedName("review_count") val numReviews: Int? = null,
    @SerializedName("distance") val distanceInMeters: Double? = null,
    @SerializedName("image_url") val imageUrl: String? = null,


)