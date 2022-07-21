package com.example.crowbait.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DeckCard(deckCardNumber:Int){
    Card(
        modifier = Modifier
            .size(100.dp, 200.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = deckCardNumber.toString(),
                fontSize = 30.sp
            )
        }
    }
}