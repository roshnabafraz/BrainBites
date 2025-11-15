package com.roshnab.brainbites.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.navigation.NavHostController
import com.roshnab.brainbites.screens.components.CustomBottomBar
import com.roshnab.brainbites.ui.theme.Rubik
import com.roshnab.brainbites.viewmodel.BrainBiteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavHostController,
         viewModel: BrainBiteViewModel,
         category: String = "All") {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(text = "BrainBites",
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
        FactScreen("All", innerPadding)
    }

}

@Composable
fun ComingSoon()
{
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center){

        Text(
            text = "Coming Soon",
            fontSize = 28.sp
        )
    }
}