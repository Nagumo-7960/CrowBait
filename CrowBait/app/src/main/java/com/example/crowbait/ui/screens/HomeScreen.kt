package com.example.crowbait.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController

//test用
//var deckNumberSet = arrayOf(-1, 1)

var deckNumberSet = arrayOf(-1,-2,-3,-4,-5,1,2,3,4,5,6,7,8,9,10)
var deckNumber = 1

@Composable
fun HomeScreen(toStart: () -> Unit, toCheckRule: () -> Unit) {
    resetSetting()
    setDeckNumber()
    Column(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.padding(top = 20.dp, start = 20.dp, bottom = 20.dp)) {
            Card(
                modifier = Modifier.size(100.dp, 50.dp)
                    .clickable(
                        enabled = true,
                        onClick = toCheckRule
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
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        top = 20.dp
                    )
            ) {
                Card(
                    modifier = Modifier
                        .size(100.dp, 200.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Deck",
                            fontSize = 30.sp
                        )
                    }
                }
            }

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    modifier = Modifier
                        .size(250.dp, 75.dp)
                        .clickable(
                            enabled = true,
                            onClick = toStart
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "ゲームスタート", fontSize = 30.sp)
                    }
                }
            }

        }
    }

}

fun setDeckNumber() {
    deckNumber = deckNumberSet[battleRound - 1]
}

fun resetSetting() {
    deckNumberSet.shuffle()
    battleRound = 1
    firstPlayerPoint = 0
    secondPlayerPoint = 0
    firstPlayerHand = arrayOfNulls(15)
    secondPlayerHand = arrayOfNulls(15)
}


@Preview
@Composable
fun PreviewHomeScreen() {
    val navController = rememberNavController()
    HomeScreen (
        toCheckRule = {navController.navigate("first")},
        toStart = {navController.navigate("first")}
    )
}