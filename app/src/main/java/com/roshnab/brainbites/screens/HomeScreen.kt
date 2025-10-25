package com.roshnab.brainbites.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.roshnab.brainbites.R
import com.roshnab.brainbites.ui.theme.Rubik
import androidx.compose.ui.text.TextStyle


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController)
{
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
        }
    ){
        innerPadding ->

        Column(modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally){

            CategoryCard("Psychology", R.drawable.psychology, onClick = {
                navController.navigate("facts/Psychological")
            })
            CategoryCard("Tech", R.drawable.tech, onClick = {
                navController.navigate("facts/Tech")
            })
            CategoryCard("Science", R.drawable.science, onClick = {
                navController.navigate("facts/Science")
            })
            CategoryCard("History", R.drawable.history, onClick = {
                navController.navigate("facts/History")
            })
            CategoryCard("Nature", R.drawable.nature, onClick = {
                navController.navigate("facts/Nature")
            })
        }
    }
}

@Composable
fun CategoryCard(title: String,
                 cover: Int,
                 onClick: () -> Unit){

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .padding(vertical = 10.dp, horizontal = 10.dp)
        .clip(RoundedCornerShape(16.dp))
        .clickable(
            onClick = onClick
        )){

        Image(
            painter = painterResource(id = cover),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.3f))
        )

        Text(
            text = title,
            fontSize = 50.sp,
            color = Color.White,
            style = TextStyle(
                fontFamily = Rubik,
                fontWeight = FontWeight.Bold
            )
        )
    }
}