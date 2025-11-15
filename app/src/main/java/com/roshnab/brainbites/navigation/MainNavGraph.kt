package com.roshnab.brainbites.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.roshnab.brainbites.screens.CategoryScreen
import com.roshnab.brainbites.screens.components.CustomBottomBar
import com.roshnab.brainbites.screens.FactScreen
import com.roshnab.brainbites.screens.SavedFactsScreen
import com.roshnab.brainbites.ui.theme.Rubik

fun getTitle(route: String?): String {
    return when(route) {
        "home" -> "BrainBites"
        "saved" -> "Saved Facts"
        "categories" -> "Categories"
        "settings" -> "Settings"
        else -> "BrainBites"
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(text = getTitle(currentRoute),
                    fontSize = 28.sp,
                    style = TextStyle(
                        fontFamily = Rubik,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF000000)
                    ))
            })
        },

        bottomBar = {
            CustomBottomBar(navController, "home")
        }
    ){
            innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ){
            composable("home") { FactScreen(category = "All") }
            composable("saved") { SavedFactsScreen() }
            composable("categories") { CategoryScreen() }
        }
        //FactScreen("All", innerPadding)
    }

}