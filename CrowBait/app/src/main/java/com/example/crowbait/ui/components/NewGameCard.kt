package com.example.crowbait.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crowbait.ui.screens.roundPlus

@Composable
fun NewGameCard(onClick:() -> Unit){
    Card(modifier = Modifier.size(80.dp, 40.dp)
        .clickable(
            enabled = true,
            onClick =  { onClick()}
        )
    ) {
        Box(contentAlignment = Alignment.Center){
            Text(
                modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                text = "タイトルへ",
                fontSize = 20.sp
            )
        }
    }
}