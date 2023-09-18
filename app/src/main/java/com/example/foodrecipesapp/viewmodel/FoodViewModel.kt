package com.example.foodrecipesapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Query
import com.example.domain.repository.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor(private val repository: FoodRepository):ViewModel() {

        private val _food = MutableStateFlow(FoodState())
        val food : StateFlow<FoodState> = _food


    fun search(query: String){
        viewModelScope.launch {
            try {
                val searchHomeResult = repository.search(query)
                _food.value = FoodState(home1 = searchHomeResult)
            } catch (e:Exception){

            }
        }
    }

    fun loafInfoStep(){
        val step = repository.getSteps()
        _food.value = _food.value.copy(infoStep = step)
    }

    fun loadDetails(){
        val detailsFood = repository.getDetailsIngredient()
        _food.value = _food.value.copy(detailsFood = detailsFood)
    }

    fun loadHome1(){
        val home1 = repository.getHome1()
        _food.value = _food.value.copy(home1 = home1)
    }

    fun loadHome2(){
        val home2 = repository.getHome2()
        _food.value = _food.value.copy(home2 = home2)
    }

}