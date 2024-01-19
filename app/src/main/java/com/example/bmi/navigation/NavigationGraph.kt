package com.example.bmi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bmi.BmiViewModel
import com.example.bmi.SplashScreen
import com.example.bmi.screens.HomeScreen
import com.example.bmi.screens.ResultScreen

@Composable
fun NavigationGraph(bmiViewModel: BmiViewModel) {
    val navController = rememberNavController()

    NavHost(navController =navController , startDestination = splashScreen){
        composable(homeScreen){ HomeScreen(viewModel = bmiViewModel)}
        composable(splashScreen){ SplashScreen(navController = navController) }
    }
}

const val homeScreen: String="HomeScreen"
const val splashScreen: String="SplashScreen"