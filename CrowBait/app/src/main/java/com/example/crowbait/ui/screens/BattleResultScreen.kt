package com.example.crowbait.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crowbait.ui.components.DeckCard

@Composable
fun BattleResultScreen() {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            modifier = Modifier.padding(
                top = 20.dp
            )
        ) {
            Text(text = "${battleRound}回戦", fontSize = 30.sp, color = Color.White)
        }
        Column(
            modifier = Modifier.padding(
                top = 20.dp
            )
        ) {
            DeckCard(deckCardNumber = 1)
        }
        Column(modifier = Modifier.padding(top = 20.dp)) {
            Card(modifier = Modifier.size(340.dp, 90.dp)) {
                Box(contentAlignment = Alignment.Center) {
                    Text(modifier = Modifier.padding(start = 20.dp, end = 20.dp),text = "先攻プレイヤーの得点", fontSize = 30.sp)
                }
            }
        }
        Column(modifier = Modifier.padding(top = 30.dp)) {
            Row {
                Column() {
                    DeckCard(deckCardNumber = firstPlayerHand[battleRound - 1])
                    Column(modifier = Modifier.padding(top = 10.dp)) {
                        Text(text = "先攻プレイヤー", fontSize = 15.sp, color = Color.White)
                        Text(text = "得点:0", fontSize = 15.sp, color = Color.White)
                    }
                }
                Column(modifier = Modifier.padding(start = 30.dp)) {
                    DeckCard(deckCardNumber = secondPlayerHand[battleRound - 1])
                    Column(modifier = Modifier.padding(top = 10.dp)) {
                        Text(text = "後攻プレイヤー", fontSize = 15.sp, color = Color.White)
                        Text(text = "得点:0", fontSize = 15.sp, color = Color.White)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewBattleResultScreen() {
    BattleResultScreen()
}