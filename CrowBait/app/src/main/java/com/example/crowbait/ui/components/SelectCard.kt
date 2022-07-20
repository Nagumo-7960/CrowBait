package com.example.crowbait.ui.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SelectCard(selectCardNumber:Int){
    Card(shape = CircleShape) {
        Text(text = selectCardNumber.toString(), fontSize = 20.sp)
    }
}

@Preview
@Composable
fun PreviewSelectCard(){
    SelectCard(0)
}

