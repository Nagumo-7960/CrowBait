package com.example.crowbait.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController

@Composable
fun PassScreen(toSecond:() -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Card(
            modifier = Modifier
                .size(280.dp, 75.dp)
                .clickable(
                    enabled = true,
                    onClick = toSecond
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "私は後攻プレイヤーです", fontSize = 25.sp)
            }
        }
    }
}

@Preview
@Composable
fun PreviewPassScreen(){
    val navController = rememberNavController()
    PassScreen{navController.navigate("second")}
}