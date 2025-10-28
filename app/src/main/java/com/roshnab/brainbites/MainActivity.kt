package com.roshnab.brainbites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.roshnab.brainbites.screens.Categories
import com.roshnab.brainbites.screens.ComingSoon
import com.roshnab.brainbites.screens.FactScreen
import com.roshnab.brainbites.screens.Home
import com.roshnab.brainbites.ui.theme.BrainBitesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BrainBitesTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable("home"){
            Home(navController = navController, viewModel = viewModel())
        }

        composable("categories") {
            Categories(navController = navController)
        }

        composable("comingsoon") { ComingSoon() }

        composable("facts/{category}") { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category") ?: "Tech"
            FactScreen(
                navController = navController,
                viewModel = viewModel(),
                category = category
            )
        }
    }
}