package com.example.foodrecipesapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodrecipesapp.R
import com.example.foodrecipesapp.databinding.ActivityMainBinding
import com.example.foodrecipesapp.fragment.homescreenfragment.HomeScreenFragment
import com.example.foodrecipesapp.utils.SharedPreferences
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var binding:ActivityMainBinding
    private lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPref = SharedPreferences(this)

        if(!sharedPref.isShow()) {
            val intent = Intent(this, SplashActivity2::class.java)
            startActivity(intent)
            sharedPref.setShow(true)
        } else{
            supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, HomeScreenFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}