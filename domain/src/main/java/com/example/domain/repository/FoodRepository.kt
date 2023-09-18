package com.example.domain.repository

import com.example.domain.model.DetailsIngredientModel
import com.example.domain.model.HomeModel1
import com.example.domain.model.HomeModel2
import com.example.domain.model.InfoStepsModel

interface FoodRepository {

    fun getHome1():List<HomeModel1>

    fun getHome2():List<HomeModel2>

    fun getDetailsIngredient():List<DetailsIngredientModel>

    fun getSteps():List<InfoStepsModel>

    fun search(query:String):List<HomeModel1>
}