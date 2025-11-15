package com.roshnab.brainbites.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.roshnab.brainbites.R

@Composable
fun CustomBottomBar(navController: NavController, isPressed: String)
{

    val isPressed = remember { mutableStateOf(isPressed) }
    val IconSize = 35.dp


    Box(modifier = Modifier.fillMaxWidth()
        .height(70.dp).background(Color.White),
        contentAlignment = Alignment.Center) {
        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 15.dp),
            horizontalArrangement = Arrangement.SpaceEvenly){

            IconButton(modifier = Modifier.weight(1f),
                onClick = {
                    navController.navigate("home")
                    isPressed.value = "home" }) {
                Icon(
                    painter = if(isPressed.value == "home") painterResource(id= R.drawable.home_bold)
                    else painterResource(id= R.drawable.home),
                    contentDescription = if(isPressed.value == "home") "home"  else null,
                    modifier = Modifier.size(IconSize)
                )
            }

            IconButton(modifier = Modifier.weight(1f),
                onClick = {
                    navController.navigate("categories")
                    isPressed.value = "categories" }) {
                Icon(
                    painter = if(isPressed.value == "categories") painterResource(id= R.drawable.category_bold)
                    else painterResource(id= R.drawable.category),
                    contentDescription = if(isPressed.value == "categories") "categories"  else null,
                    modifier = Modifier.size(IconSize)
                )
            }

            IconButton(modifier = Modifier.weight(1f),
                onClick = {
                    navController.navigate("saved")
                    isPressed.value = "heart" }) {
                Icon(
                    painter = if(isPressed.value == "heart") painterResource(id= R.drawable.heart_bold)
                    else painterResource(id= R.drawable.heart),
                    contentDescription = if(isPressed.value == "heart") "heart"  else null,
                    modifier = Modifier.size(IconSize)
                )
            }

            IconButton(modifier = Modifier.weight(1f),
                onClick = {
                    navController.navigate("comingsoon")
                    isPressed.value = "setting" }) {
                Icon(
                    painter = if(isPressed.value == "setting") painterResource(id= R.drawable.setting_bold)
                    else painterResource(id= R.drawable.setting),
                    contentDescription = if(isPressed.value == "setting") "setting"  else null,
                    modifier = Modifier.size(IconSize)
                )
            }
        }
    }
}
