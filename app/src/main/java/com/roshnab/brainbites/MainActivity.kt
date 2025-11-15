package com.roshnab.brainbites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.roshnab.brainbites.navigation.AppNavigation
import com.roshnab.brainbites.screens.SavedFactsScreen
import com.roshnab.brainbites.ui.theme.BrainBitesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BrainBitesTheme {
                //DemoScreen()
                AppNavigation()
            }
        }
    }
}

//@Composable
//fun Navigation(){
//    val navController = rememberNavController()
//
//    NavHost(
//        navController = navController,
//        startDestination = "home"
//    ){
//        composable("home"){
//            Home(navController = navController, viewModel = viewModel())
//        }
//
//        composable("categories") {
//            Categories(navController = navController)
//        }
//
//        composable("comingsoon") { ComingSoon() }
//
//        composable("facts/{category}") { backStackEntry ->
//            val category = backStackEntry.arguments?.getString("category") ?: "Tech"
//            FactScreen(
//                navController = navController,
//                category = category
//            )
//        }
//    }
//}