package com.diegocunha

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.diegocunha.coreui.theme.PetsTheme
import com.diegocunha.discoverypet.ui.home.HomeScreen
import com.diegocunha.navigation.route.FindPetRoute

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            LaunchedEffect(Unit) {
                navController.addOnDestinationChangedListener { _, destination, _ ->
                    Log.i("MainActivity", "Destination: ${destination.route}")
                }
            }

            PetsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    NavHost(
                        navController = navController,
                        startDestination = FindPetRoute.Home.route
                    ) {
                        composable(FindPetRoute.Home.route) {
                            HomeScreen()
                        }
                    }
                }
            }
        }
    }
}