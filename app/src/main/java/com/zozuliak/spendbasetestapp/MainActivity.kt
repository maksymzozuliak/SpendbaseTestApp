package com.zozuliak.spendbasetestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.zozuliak.spendbasetestapp.ui.card_screen.CardScreen
import com.zozuliak.spendbasetestapp.ui.global_elements.NavBar
import com.zozuliak.spendbasetestapp.ui.main_screen.MainScreen
import com.zozuliak.spendbasetestapp.ui.theme.SpendbaseTestAppTheme
import com.zozuliak.spendbasetestapp.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpendbaseTestAppTheme {

                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            NavBar()
                        }
                    ) {
                        NavHost(
                            modifier = Modifier.padding(it),
                            navController = navController,
                            startDestination = Screen.MainScreen.route
                        ) {
                            composable(
                                route = Screen.MainScreen.route
                            ) {
                                MainScreen(
                                    navController = navController
                                )
                            }
                            composable(
                                route = Screen.CardScreen.route +
                                        "?card={card}",
                                arguments = listOf(
                                    navArgument(
                                        name = "card"
                                    ) {
                                        type = NavType.StringType
                                        defaultValue = "noCard"
                                    },
                                )
                            ) {
                                CardScreen(
                                    navController = navController
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}