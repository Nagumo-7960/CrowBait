package com.example.crowbait.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            ){
        Card(
            modifier = Modifier
                .size(100.dp, 200.dp)
                .padding(
                    top = 20.dp
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Deck",
                    fontSize = 30.sp
                )
            }
        }
        Card(
            modifier = Modifier
                .size(250.dp,75.dp)
        ) {
            Box (
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
                    ){
                Text(text = "ゲームスタート", fontSize = 30.sp)
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen(){
    HomeScreen()
}