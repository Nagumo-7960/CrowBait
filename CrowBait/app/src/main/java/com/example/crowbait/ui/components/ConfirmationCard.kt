package com.example.crowbait.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ConfirmationCard() {
    Card(modifier = Modifier.size(400.dp, 200.dp), shape = RoundedCornerShape(20)) {

    }
}

@Preview
@Composable
fun PreviewConfirmationCard() {
    ConfirmationCard()
}