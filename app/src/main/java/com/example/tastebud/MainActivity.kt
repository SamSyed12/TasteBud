package com.example.tastebud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.tastebud.login.presentation.LoginScreen
import com.example.tastebud.ui.theme.TasteBudTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TasteBudTheme {
                 LoginScreen()
            }
        }
    }
}

