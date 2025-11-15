package com.roshnab.brainbites.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.roshnab.brainbites.R
import com.roshnab.brainbites.ui.theme.Rubik

@Composable
fun SplashScreen(onTimeout: () -> Unit)
{
    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(2000)   // 2 sec splash delay
        onTimeout()
    }

    Box(modifier = Modifier.fillMaxSize().background(color = Color(0xFFffb703)),
        contentAlignment = Alignment.Center
        ){
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,) {

            Box(
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(150.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.brainbite_logo),
                    contentDescription = null,
                    modifier = Modifier.size(300.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Text(text = "BrainBites",
                fontSize = 40.sp,
                style = TextStyle(
                    fontFamily = Rubik,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ))
        }
        Text(text = "Developed by Roshnab",
            fontSize = 18.sp,
            style = TextStyle(
                fontFamily = Rubik,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            ),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp))
    }
}