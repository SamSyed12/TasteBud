package com.example.tastebud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tastebud.login.presentation.LoginScreen
import com.example.tastebud.login.presentation.LoginViewModel
import com.example.tastebud.navigation.Screen.*
import com.example.tastebud.ui.theme.TasteBudTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            TasteBudTheme {
                 val topBottomBarClickListeners = object : TopBottomBarClickListeners {
                     override fun onHomeClicked() {
                         navController.navigate(Home.route) { launchSingleTop = true }
                     }

                     override fun onFavoritesClicked() {
                         navController.navigate(MyPage.route) { launchSingleTop = true }
                     }

                     override fun onTipFeedClicked() {
                         navController.navigate(Tips.route) { launchSingleTop = true }
                     }

                     override fun onBackButtonClicked() {
                         navController.popBackStack()
                     }

                 }
                 AppScaffold(
                     title = "",
                     showNavigationIcon = false,
                     topBottomBarClickListeners = topBottomBarClickListeners
                 ) {
                     NavHost(
                         navController = navController,
                         startDestination = Login.route
                     ) {
                         composable(Login.route) {
                             val loginViewModel by viewModels<LoginViewModel>()
                             LoginScreen(
                                 viewModel = loginViewModel,
                                 navigateToHome = { navController.navigate(Home.route) }
                             )
                         }
                         composable(Home.route) {
                             Surface(
                                 modifier = Modifier
                                     .fillMaxSize(),
                                 color = Color.Blue
                             ) {

                             }
                         }
                     }
                 }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppScaffold(
    title: String = "",
    showNavigationIcon: Boolean = false,
    topBottomBarClickListeners: TopBottomBarClickListeners = object : TopBottomBarClickListeners {
        override fun onHomeClicked() {}
        override fun onFavoritesClicked() {}
        override fun onTipFeedClicked() {}
        override fun onBackButtonClicked() {}
    },
    content: @Composable () -> Unit = {},
) {
    val backButton: @Composable () -> Unit = {
        IconButton(onClick = { topBottomBarClickListeners.onBackButtonClicked() }) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back Button"
            )
        }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth(),
                title = { Text(text = title)},
                navigationIcon = if (showNavigationIcon) backButton else null
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth(),
            ) {
                IconButton(onClick = { topBottomBarClickListeners.onHomeClicked() }) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Home Icon"
                    )
                }
            }
        }
    ) { contentPadding ->
        Surface(Modifier.padding(contentPadding)) {
            content()
        }
    }
}

// interface for interacting with top and bottom bar icons
interface TopBottomBarClickListeners {
    fun onHomeClicked()
    fun onFavoritesClicked()
    fun onTipFeedClicked()
    fun onBackButtonClicked()
}
