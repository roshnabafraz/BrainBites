package com.roshnab.brainbites.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.roshnab.brainbites.screens.SplashScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen() {
                navController.navigate("main") {
                    popUpTo("splash") { inclusive = true }
                }
            }
        }

        composable("main") {
            MainScreen()
        }
    }
}