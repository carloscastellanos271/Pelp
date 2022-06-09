package com.example.pelp.presentation.ui.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.pelp.presentation.components.RecipeCard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    val viewModel: RecipeListViewModel by viewModels()


    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {

            setContent {

                val recipes = viewModel.recipes.value

                val query = viewModel.query.value

                val location = viewModel.location.value

                Column {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth(),
                        color = Color.DarkGray,
                        elevation = 8.dp,
                    ) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Column() {
                                val keyboardController = LocalSoftwareKeyboardController.current
                                TextField(
                                    modifier = Modifier
                                        .fillMaxWidth(.9f)
                                        .padding(8.dp),
                                    value = query,
                                    onValueChange = {
                                        viewModel.onQueryChanged(it)
                                    },
                                    label = {
                                        Text(
                                            "Search",
                                            color = Color.Red,
                                            fontWeight = FontWeight.W500
                                        )
                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Text,
                                        imeAction = ImeAction.Next,
                                    ),
                                    leadingIcon = {
//                                    Icon(Icons.Filled.Search)
                                    },
                                    keyboardActions = KeyboardActions(
                                        onNext = {
                                            var action = ImeAction.Next
                                            if (action == ImeAction.Next) {
                                                viewModel.newSearch(query, location)
                                                keyboardController?.hide()
                                            }
                                        }
                                    ),
                                    textStyle = TextStyle(color = Color.White),


                                    )
                                TextField(
                                    modifier = Modifier
                                        .fillMaxWidth(.9f)
                                        .padding(8.dp),
                                    value = location,
                                    onValueChange = {
                                        viewModel.onLocationChanged(it)
                                    },
                                    label = {
                                        Text(
                                            "Location",
                                            color = Color.Red,
                                            fontWeight = FontWeight.W500
                                        )
                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Text,
                                        imeAction = ImeAction.Go,
                                    ),
                                    leadingIcon = {
//                                    Icon
                                    },
                                    keyboardActions = KeyboardActions(
                                        onGo = {
                                            var action = ImeAction.Go
                                            if (action == ImeAction.Go) {
                                                viewModel.newSearch(query, location)
                                                keyboardController?.hide()
                                            }
                                        }
                                    ),
                                    textStyle = TextStyle(color = Color.White),

                                    )
                            }
                        }

                    }

                    LazyColumn {
                        itemsIndexed(
                            items = recipes
                        ) { index, recipe ->
                            RecipeCard(recipe = recipe, onClick = {})
                        }
                    }
                }
            }
        }
    }
}