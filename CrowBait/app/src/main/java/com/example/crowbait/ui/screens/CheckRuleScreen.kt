package com.example.crowbait.ui.screens

import androidx.compose.foundation.clickable
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
import androidx.navigation.compose.rememberNavController

@Composable
fun CheckRuleScreen(toBack: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(top = 20.dp, start = 20.dp, bottom = 20.dp)) {
            Card(
                modifier = Modifier
                    .size(100.dp, 50.dp)
                    .clickable(
                        enabled = true,
                        onClick = toBack
                    )
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "もどる",
                        fontSize = 15.sp
                    )
                }
            }
        }
    }
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text(text = "ルール説明", color = Color.White)
    }
}

@Preview
@Composable
fun PreviewCheckRule() {
    val navController = rememberNavController()
    CheckRuleScreen { navController.navigate("home") }
}