package com.example.tastebud

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tastebud.navigation.Route
import com.example.tastebud.navigation.TasteBudNavHost
import com.example.tastebud.navigation.composable
import com.example.tastebud.onboarding.presentation.OnboardingScreen

import com.example.tastebud.ui.theme.TasteBudTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContent {
            TasteBudTheme(darkTheme = isSystemInDarkTheme()) {
                val navController = rememberNavController()
                TasteBudNavHost(
                    navController = navController,
                    startDestination = Route.Onboarding
                ) {
                    composable(route = Route.Onboarding) {

                    }
                    composable(route = Route.Login) {

                    }
                }
            }
        }
    }
}



