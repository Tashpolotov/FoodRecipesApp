package com.example.foodrecipesapp.utils

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPreferences @Inject constructor(@ApplicationContext context: Context) {

        private val sharedPreferences : SharedPreferences = context.getSharedPreferences(
                "sharedPref",
                Context.MODE_PRIVATE
        )

        fun isShow():Boolean{
                return sharedPreferences.getBoolean("show", false)
        }

        fun setShow(isShow:Boolean) {
                sharedPreferences.edit().putBoolean("show", isShow).apply()
        }


}