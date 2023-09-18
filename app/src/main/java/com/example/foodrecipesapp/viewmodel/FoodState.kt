package com.example.foodrecipesapp.viewmodel

import com.example.domain.model.DetailsIngredientModel
import com.example.domain.model.HomeModel1
import com.example.domain.model.HomeModel2
import com.example.domain.model.InfoStepsModel

data class FoodState (

    val home1:List<HomeModel1> = emptyList(),
    val home2:List<HomeModel2> = emptyList(),
    val detailsFood:List<DetailsIngredientModel> = emptyList(),
    val infoStep:List<InfoStepsModel> = emptyList()
        )