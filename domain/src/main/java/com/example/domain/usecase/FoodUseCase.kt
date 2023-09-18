package com.example.domain.usecase

import com.example.domain.repository.FoodRepository

class FoodUseCase(private val repository: FoodRepository) {

    operator fun invoke(){
        repository.getHome1()
        repository.getHome2()
        repository.getDetailsIngredient()
        repository.getSteps()
        repository.search(query = String())
    }
}