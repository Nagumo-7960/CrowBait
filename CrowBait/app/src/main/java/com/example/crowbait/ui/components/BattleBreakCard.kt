package com.example.crowbait.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BattleBreakCard() {
    Column(
        modifier = Modifier
            .padding(
                top = 20.dp,
                start = 20.dp,
                bottom = 20.dp
            )
    ) {
        Card(
            modifier = Modifier
                .size(100.dp, 50.dp)
                .clickable(
                    enabled = true,
                    onClick = {}
                )
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "ルール説明",
                    fontSize = 15.sp
                )
            }
        }
    }
    }


@Preview
@Composable
fun PreviewBattleBreakCard(){
    BattleBreakCard()
}