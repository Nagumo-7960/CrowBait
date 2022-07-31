package com.example.crowbait.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConfirmationCard() {
    Card(modifier = Modifier.size(400.dp, 200.dp), shape = RoundedCornerShape(20)) {
        Column(modifier = Modifier.padding(top=20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "確認", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Text(text = "このカードを選択していいですか？", fontSize = 20.sp)
        }
    }
}

@Preview
@Composable
fun PreviewConfirmationCard() {
    ConfirmationCard()
}