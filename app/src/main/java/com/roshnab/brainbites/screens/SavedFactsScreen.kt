package com.roshnab.brainbites.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.roshnab.brainbites.ui.theme.Rubik
import com.roshnab.brainbites.viewmodel.BrainBiteViewModel
import com.roshnab.brainbites.viewmodel.BrainBiteViewModelFactory

@Composable
fun SavedFactsScreen() {
    val context = LocalContext.current
    val viewModel: BrainBiteViewModel = viewModel(
        factory = BrainBiteViewModelFactory(context)
    )

    val savedBites by viewModel.getSavedBites().collectAsState(initial = emptyList())

    LazyColumn {
        items(savedBites.size) { index ->
            val bite = savedBites[index]
            SavedBite(bite.text)
        }
    }
}

@Composable
fun SavedBite(text : String){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0xFFe9ff93))
    ){
        Text(
            text = text,
            fontSize = 18.sp,
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
