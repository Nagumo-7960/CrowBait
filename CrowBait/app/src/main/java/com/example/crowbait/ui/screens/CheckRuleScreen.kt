package com.example.crowbait.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController

@Composable
fun CheckRuleScreen(toBack: () -> Unit) {
    LazyColumn {
        item {
            Column(modifier = Modifier.fillMaxSize()) {
                BackButton(toBack)
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 20.dp, start = 20.dp, bottom = 20.dp, end = 20.dp)
                ) {
                    BasicRules()
                    Column(modifier = Modifier.padding(top = 20.dp)) {
                        Text(
                            text = "ゲームの流れ",
                            fontSize = 35.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = "-1~10までの数字のうち、1枚ずつ山札から選ばれる",
                            fontSize = 20.sp,
                            color = Color.White
                        )
                        Text(
                            text = "先行プレイヤーが手札を選ぶ→後攻プレイヤーが手札を選ぶ→対戦結果が出る",
                            fontSize = 20.sp,
                            color = Color.White
                        )
                        Text(
                            text = "これを手札の枚数15回繰り返し、最終的に得点が多かったプレイヤーの勝利",
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                    Column(modifier = Modifier.padding(top = 20.dp)) {
                        Text(
                            text = "操作説明",
                            fontSize = 35.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Column {
                            Text(
                                text = "ホーム画面",
                                fontSize = 20.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Column(modifier = Modifier.padding(start = 20.dp)) {
                                Text(
                                    text = "ルールブック",
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "スタートボタン",
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                            }
                        }
                        Column {
                            Text(
                                text = "対戦画面",
                                fontSize = 20.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Column(modifier = Modifier.padding(start = 20.dp)) {
                                Text(
                                    text = "手札",
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "山札",
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "何回戦かを表示",
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "プレイヤーの得点",
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "対戦中断ボタン",
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                            }
                        }
                        Column {
                            Text(
                                text = "1回戦ごとの結果画面",
                                fontSize = 20.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Column(modifier = Modifier.padding(start = 20.dp)) {
                                Text(
                                    text = "何回戦かを表示",
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "山札",
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "先攻プレイヤーの選んだ手札",
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "先攻プレイヤーの得点",
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "後攻プレイヤーの選んだ手札",
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "後攻プレイヤーの得点",
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "次の対戦へ進むボタン",
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                            }
                        }

                        Column {
                            Text(
                                text = "最終結果画面",
                                fontSize = 20.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Column(modifier = Modifier.padding(start = 20.dp)) {
                                Text(
                                    text = "勝者の表示",
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "先攻プレイヤーの得点を表示",
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "後攻プレイヤーの得点を表示",
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "ホーム画面へ戻る",
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                            }
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun BackButton(toBack:() -> Unit){
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

@Composable
fun BasicRules(){
    Column {
        Text(
            text = "基本的なルール",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = "CrowBaitは、1~15の数字が書かれた手札から1枚のカードを選び、数字の大きい人が得点を獲得するカードゲームです。",
            fontSize = 20.sp,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun PreviewCheckRule() {
    val navController = rememberNavController()
    CheckRuleScreen { navController.navigate("home") }
}