package com.example.crowbait.ui.screens

import androidx.compose.foundation.background
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
import com.example.crowbait.ui.components.NewGameCard

@Composable
fun FinalResultScreen(toReset: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
//        BattleBreakCard()
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(top = 20.dp)) {
                Card(modifier = Modifier.size(270.dp, 100.dp)) {
                    Box(contentAlignment = Alignment.Center) {
                        if (finalBattleResultText() == "先攻プレイヤーの勝利") {
                            Text(
                                modifier = Modifier
                                    .background(color = Color.Yellow)
                                    .padding(start = 10.dp, end = 10.dp),
                                text = finalBattleResultText(),
                                fontSize = 35.sp
                            )
                        } else if (finalBattleResultText() == "後攻プレイヤーの勝利") {
                            Text(
                                modifier = Modifier
                                    .background(color = Color.Cyan)
                                    .padding(start = 10.dp, end = 10.dp),
                                text = finalBattleResultText(),
                                fontSize = 35.sp
                            )
                        } else {
                            Text(
                                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                                text = finalBattleResultText(),
                                fontSize = 35.sp
                            )
                        }
                    }
                }
            }
            Column(modifier = Modifier.padding(top = 100.dp)) {
                Column {
                    Card {
                        Text(
                            modifier = Modifier.background(color = Color.Yellow),
                            text = "先攻プレイヤー",
                            fontSize = 50.sp
                        )
                    }
                    Text(text = "得点：${firstPlayer.score}", fontSize = 50.sp, color = Color.White)
                }
                Column(modifier = Modifier.padding(top = 20.dp)) {
                    Card {
                        Text(
                            modifier = Modifier.background(color = Color.Cyan),
                            text = "後攻プレイヤー",
                            fontSize = 50.sp
                        )
                    }
                    Text(text = "得点：${secondPlayer.score}", fontSize = 50.sp, color = Color.White)
                }
            }
            Column(modifier = Modifier.padding(top = 30.dp)) {
                NewGameCard {
                    toReset()
                }
            }
        }
    }
}

fun finalBattleResultText(): String {
    if(firstPlayer.score>secondPlayer.score){
        return "先攻プレイヤーの勝利"
    }else if(firstPlayer.score<secondPlayer.score){
        return "後攻プレイヤーの勝利"
    }else{
        return "引き分け"
    }
}

@Preview
@Composable
fun PreviewFinalResultScreen() {
    val navController = rememberNavController()
    FinalResultScreen {
        navController.navigate("home")
    }
}