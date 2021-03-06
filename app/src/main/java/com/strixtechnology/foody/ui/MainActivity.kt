package com.strixtechnology.foody.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.strixtechnology.foody.R
import com.strixtechnology.foody.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.reflect.Array

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setTheme(R.style.Theme_Foody)
        setContentView(binding.root)

        navController = findNavController(R.id.navHostFragment)
        val appBarConfiguration: AppBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.recipesFragment,
                    R.id.favoriteRecipesFragment,
                    R.id.foodJokeFragment
                )
        )
        binding.bottomNavigation.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}