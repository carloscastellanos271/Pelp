package com.example.pelp.di

import com.codingwithmitch.recipeapp.repository.PelpRepository
import com.codingwithmitch.recipeapp.repository.PelpRepository_Impl
import com.example.pelp.network.RecipeService
import com.example.pelp.network.YelpService
import com.example.pelp.network.model.PelpDtoMapper
import com.example.pelp.network.model.RecipeDtoMapper

import com.example.pelp.repository.RecipeRepository
import com.example.pelp.repository.RecipeRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeMapper: RecipeDtoMapper
    ): RecipeRepository {
        return RecipeRepository_Impl(
            recipeService = recipeService,
            mapper = recipeMapper)
    }

}

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule2 {

    @Singleton
    @Provides
    fun providePelpRepository(
        pelpService: YelpService,
        pelpMapper: PelpDtoMapper
    ): PelpRepository {
        return PelpRepository_Impl(
            pelpService = pelpService,
            mapper = pelpMapper)
    }

}