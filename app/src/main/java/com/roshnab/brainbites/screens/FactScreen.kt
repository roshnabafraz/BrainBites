package com.roshnab.brainbites.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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
import androidx.navigation.NavHostController
import androidx.compose.ui.text.TextStyle
import com.roshnab.brainbites.ui.theme.Rubik

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FactScreen(navController: NavHostController,
               viewModel: BrainBiteViewModel,
               category: String = "All",
               innerPadding: PaddingValues = PaddingValues(0.dp)) {

        val bites: State<List<Bite>> = when (category) {
            "Tech" -> viewModel.TechBites.observeAsState(emptyList())
            "Psychological" -> viewModel.PsychologicalBites.observeAsState(emptyList())
            "Science" -> viewModel.ScienceBites.observeAsState(emptyList())
            "History" -> viewModel.HistoryBites.observeAsState(emptyList())
            "Nature" -> viewModel.NatureBites.observeAsState(emptyList())
            else -> viewModel.allBites.observeAsState(emptyList())
        }

        val BiteList = bites.value
        val ListSize = BiteList.size

        var factIndex by remember { mutableStateOf(0) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFf5ffc6))
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(innerPadding)
                    .fillMaxSize()) {

                bites.value.let { biteList ->
                    if (biteList.size > factIndex) {
                        val fact = biteList[factIndex]
                        Bite(fact.text)
                    } else {
                        // factIndex = 0
                    }}

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        factIndex = if( category == "Random"){
                            (0 until ListSize).random()
                        }else{
                            (factIndex + 1) % ListSize
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF405a0d),
                        contentColor = Color(0xFFfbffe5)
                    ),
                    shape = RoundedCornerShape(22.dp),
                    modifier = Modifier
                        .height(70.dp)
                        .width(300.dp)
                ) {
                    Icon(painter = painterResource(id = R.drawable.arrow_right),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp))
                }

            }
        }
}

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