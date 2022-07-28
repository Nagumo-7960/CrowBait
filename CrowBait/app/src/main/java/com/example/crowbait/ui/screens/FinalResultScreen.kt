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

@Composable
fun FinalResultScreen(){
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier.padding(top = 20.dp)) {
            Card (modifier = Modifier.size(270.dp,100.dp)){
                Box(contentAlignment = Alignment.Center) {
                    Text(modifier = Modifier.padding(start = 10.dp, end = 10.dp),text = "先攻プレイヤーの勝利", fontSize = 35.sp)
                }
            }
        }
        Column(modifier = Modifier.padding(top = 100.dp)) {
                Column() {
                  Card() {
                      Text(text = "先攻プレイヤー", fontSize = 50.sp)
                  }
                    Text(text = "得点：${firstPlayerPoint}", fontSize = 50.sp, color = Color.White)
                }
                Column(modifier = Modifier.padding(top = 20.dp)) {
                    Card() {
                        Text(text = "後攻プレイヤー", fontSize = 50.sp)
                    }
                    Text(text = "得点：${secondPlayerPoint}", fontSize = 50.sp,color = Color.White)
                }
        }
    }
}

@Preview
@Composable
fun PreviewFinalResultScreen(){
    FinalResultScreen()
}