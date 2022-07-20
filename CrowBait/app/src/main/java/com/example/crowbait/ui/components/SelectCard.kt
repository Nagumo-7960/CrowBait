package com.example.crowbait.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SelectCard(selectCardNumber: Int) {
    Box(contentAlignment = Alignment.Center){
        Card(
            modifier = Modifier.size(50.dp, 50.dp),
            shape = CircleShape,
        ) {
            //手動でテキストの位置を調整しているので、要修正
            Text(modifier = Modifier.padding(top = 10.dp, start = 18.dp),
                text = selectCardNumber.toString(), fontSize = 20.sp)
        }
    }

}

@Preview
@Composable
fun PreviewSelectCard() {
    SelectCard(0)
}

