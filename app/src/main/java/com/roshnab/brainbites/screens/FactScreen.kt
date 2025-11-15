package com.roshnab.brainbites.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.roshnab.brainbites.R
import com.roshnab.brainbites.data.Bite
import com.roshnab.brainbites.viewmodel.BrainBiteViewModel
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.compose.ui.text.TextStyle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.roshnab.brainbites.ui.theme.Rubik // Assuming you have this theme package
import com.roshnab.brainbites.viewmodel.BrainBiteViewModelFactory
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FactScreen(
    category: String = "All",
    innerPadding: PaddingValues = PaddingValues(0.dp)
) {
    val context = LocalContext.current
    val viewModel: BrainBiteViewModel = viewModel(
        factory = BrainBiteViewModelFactory(context)
    )


    val flow = when (category) {
        "Tech" -> { viewModel.getBitesByCategory("Tech") }
        "Psychology" -> { viewModel.getBitesByCategory("Psychology") }
        "History" -> { viewModel.getBitesByCategory("History") }
        "Science" -> { viewModel.getBitesByCategory("Science") }
        "Nature" -> { viewModel.getBitesByCategory("Nature") }
        else -> { viewModel.getBitesByCategory("All") }
    }

    val bites = flow.collectAsState(initial = emptyList())



    var factIndex by remember { mutableStateOf(0) }
    val size = bites.value.size

    LaunchedEffect(bites.value.size) {
        factIndex = 0
    }



    if (bites.value.isEmpty()) {
        Text("loading...")
        return
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {

            Bite(text = bites.value[factIndex].text)

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        factIndex = Random.nextInt(0, bites.value.size)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF405a0d),
                        contentColor = Color(0xFFfbffe5)
                    ),
                    shape = RoundedCornerShape(22.dp),
                    modifier = Modifier
                        .height(70.dp)
                        .weight(1f)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_right),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = {
                        val bite = bites.value[factIndex]
                        viewModel.saveBite(bite.id, !bite.isSaved)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF405a0d),
                        contentColor = Color(0xFFfbffe5)
                    ),
                    shape = RoundedCornerShape(22.dp),
                    modifier = Modifier
                        .height(70.dp)
                        .width(70.dp)
                ) {
                    Icon(
                        painter = painterResource(if(bites.value[factIndex].isSaved) R.drawable.heart_bold else R.drawable.heart),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun FactScreen(
//    navController: NavHostController,
//    category: String = "All",
//    innerPadding: PaddingValues = PaddingValues(0.dp)
//) {
//    val context = LocalContext.current
//    val viewModel: BrainBiteViewModel = viewModel(
//        factory = BrainBiteViewModelFactory(context)
//    )
//
//
//    val flow = when (category) {
//        "Tech" -> { viewModel.getBitesByCategory("Tech") }
//        "Psychology" -> { viewModel.getBitesByCategory("Psychology") }
//        "History" -> { viewModel.getBitesByCategory("History") }
//        "Science" -> { viewModel.getBitesByCategory("Science") }
//        "Nature" -> { viewModel.getBitesByCategory("Nature") }
//        else -> { viewModel.getBitesByCategory("All") }
//    }
//
//    val bites = flow.collectAsState(initial = emptyList())
//
//
//
//    var factIndex by remember { mutableStateOf(0) }
//    val size = bites.value.size
//
//    LaunchedEffect(bites.value.size) {
//        factIndex = 0
//    }
//
//
//
//    if (bites.value.isEmpty()) {
//        Text("loading...")
//        return
//    }
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//            modifier = Modifier
//                .padding(innerPadding)
//                .fillMaxSize()
//        ) {
//
//            Bite(text = bites.value[factIndex].text)
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            Row(
//                modifier = Modifier
//                    .padding(horizontal = 16.dp)
//                    .fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Button(
//                    onClick = {
//                        factIndex = Random.nextInt(0, bites.value.size)
//                    },
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = Color(0xFF405a0d),
//                        contentColor = Color(0xFFfbffe5)
//                    ),
//                    shape = RoundedCornerShape(22.dp),
//                    modifier = Modifier
//                        .height(70.dp)
//                        .weight(1f)
//                ) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.arrow_right),
//                        contentDescription = null,
//                        modifier = Modifier.size(40.dp)
//                    )
//                }
//
//                Spacer(modifier = Modifier.width(8.dp))
//
//                Button(
//                    onClick = { /* favorite click */ },
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = Color(0xFF405a0d),
//                        contentColor = Color(0xFFfbffe5)
//                    ),
//                    shape = RoundedCornerShape(22.dp),
//                    modifier = Modifier
//                        .height(70.dp)
//                        .width(70.dp)
//                ) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.heart),
//                        contentDescription = null,
//                        modifier = Modifier.size(32.dp)
//                    )
//                }
//            }
//        }
//    }
//}



@Composable
fun Bite(text: String){

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0xFFe9ff93))
    ){
        Text(
            text = text,
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(24.dp),
            style = TextStyle(
                fontFamily = Rubik,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF203201)
            )
        )
    }
}