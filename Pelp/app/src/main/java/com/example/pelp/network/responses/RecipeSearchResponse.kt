package com.example.pelp.network.responses


import com.example.pelp.network.model.PelpDto
import com.example.pelp.network.model.RecipeDto
import com.google.gson.annotations.SerializedName

data class RecipeSearchResponse (
    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var recipes: List<RecipeDto>,

    )

data class PelpSearchResponse(
    @SerializedName("total")
    var total: Int,

    @SerializedName("businesses")
    var restaurants: List<PelpDto> //List<PelpDto>
)