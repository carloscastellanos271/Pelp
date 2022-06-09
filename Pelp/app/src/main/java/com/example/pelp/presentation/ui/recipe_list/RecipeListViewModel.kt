package com.example.pelp.presentation.ui.recipe_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmitch.recipeapp.repository.PelpRepository
import com.example.pelp.domain.model.Pelp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel
@Inject
constructor(

    private val repository: PelpRepository,
    private @Named("authHeader") val token: String,
) : ViewModel() {

    val recipes: MutableState<List<Pelp>> = mutableStateOf(ArrayList())

    val query = mutableStateOf("burgers")

    val location = mutableStateOf("Tampa")



    init {
        newSearch("burgers", "Tampa")
    }

    fun newSearch(query: String, location: String) {
        viewModelScope.launch {
            val result = repository.search(
                authHeader = token,
                searchTerm = query,
                location = location,
            )
            recipes.value = result
        }
    }

    fun onQueryChanged(query: String) {
        this.query.value = query

    }

    fun onLocationChanged(location: String) {
        this.location.value = location
    }
}