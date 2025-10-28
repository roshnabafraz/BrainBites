package com.roshnab.brainbites.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.roshnab.brainbites.R
import com.roshnab.brainbites.ui.theme.Rubik
import com.roshnab.brainbites.viewmodel.BrainBiteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavHostController, viewModel: BrainBiteViewModel, category: String = "All") {

    val SelectedIcon = remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(text = "BrainBites",
                    fontSize = 28.sp,
                    style = TextStyle(
                        fontFamily = Rubik,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ))
            })
        },

        bottomBar = {
            NavigationBar{

                NavigationBarItem(
                    selected = true,
                    onClick = {
                        navController.navigate("home")
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.home),
                            contentDescription = "Home",
                            modifier = Modifier.size(24.dp)
                        )
                    }

                )

                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigate("categories")
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.category),
                            contentDescription = "Category",
                            modifier = Modifier.size(24.dp)
                        )
                    }

                )

                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigate("comingsoon")
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.heart),
                            contentDescription = "Category",
                            modifier = Modifier.size(24.dp)
                        )
                    }

                )

                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigate("comingsoon")
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.settings),
                            contentDescription = "Settings",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                )
            }


        }
    ){
            innerPadding ->
        FactScreen(navController, viewModel,"All", innerPadding)
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