package com.example.crowbait.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.crowbait.R
import com.example.crowbait.model.Player
import com.example.crowbait.model.RoundResultCheck

//test用
//var deckNumberList = arrayOf(-1, 1)

var deckNumberList = arrayOf(-1, -2, -3, -4, -5, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
var deckNumber = 1
var battleRound = 1

var firstPlayer = Player()
var secondPlayer = Player()

val roundResultCheck = RoundResultCheck()

@Composable
fun HomeScreen(toStart: () -> Unit, toCheckRule: () -> Unit) {
    resetSetting(firstPlayer, secondPlayer)
    setDeckNumber()
    Column(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.padding(top = 20.dp, start = 20.dp, bottom = 20.dp)) {
            Card(
                modifier = Modifier
                    .size(100.dp, 50.dp)
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
                        top = 100.dp,
                        start = 40.dp,
                        end = 40.dp
                    )
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Image(
                        modifier = Modifier.fillMaxWidth(),
                        painter = painterResource(id = R.drawable.titlelogo_black),
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )
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
    deckNumber = deckNumberList[battleRound - 1]
}

fun resetSetting(firstPlayer: Player, secondPlayer: Player) {
    //プレイヤーの得点と手札を初期化
    firstPlayer.score = 0
    firstPlayer.usedHandsList = mutableListOf<Int>()
    secondPlayer.score = 0
    secondPlayer.usedHandsList = mutableListOf<Int>()

    //山札をシャッフルし、ラウンドを1に戻す
    deckNumberList.shuffle()
    battleRound = 1
}


@Preview
@Composable
fun PreviewHomeScreen() {
    val navController = rememberNavController()
    HomeScreen(
        toCheckRule = { navController.navigate("first") },
        toStart = { navController.navigate("first") }
    )
}