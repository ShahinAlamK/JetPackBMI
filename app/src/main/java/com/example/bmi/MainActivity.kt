package com.example.bmi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.bmi.navigation.NavigationGraph
import com.example.bmi.screens.HomeScreen
import com.example.bmi.ui.theme.BMITheme

class MainActivity : ComponentActivity() {
    private val bmiViewModel by viewModels<BmiViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            BMITheme {
                HomeScreen(viewModel = bmiViewModel)
            }
        }
    }
}
