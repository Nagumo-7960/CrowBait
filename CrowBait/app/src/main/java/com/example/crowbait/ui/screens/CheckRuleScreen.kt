package com.example.crowbait.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp, start = 20.dp, bottom = 20.dp, end = 20.dp)
        ) {
            Column {
                Text(
                    text = "基本的なルール",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "CrowBaitは、1~15の数字が書かれた手札から1枚のカードを選び、数字の大きい人が得点を獲得するカードゲームです。",
                    fontSize = 20.sp
                )
            }
            Column {
                Text(
                    text = "ゲームの流れ",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "-1~10までの数字のうち、1枚ずつ山札から選ばれる",
                    fontSize = 20.sp
                )
                Text(
                    text = "先行プレイヤーが手札を選ぶ→後攻プレイヤーが手札を選ぶ→対戦結果が出る",
                    fontSize = 20.sp
                )
                Text(
                    text = "これを手札の枚数15回繰り返し、最終的に得点が多かったプレイヤーの勝利",
                    fontSize = 20.sp
                )
            }
            Column {
                Text(
                    text = "操作説明",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "CrowBaitは、1~15の数字が書かれた手札から1枚のカードを選び、数字の大きい人が得点を獲得するカードゲームです。",
                    fontSize = 20.sp
                )
            }

        }
    }
}

@Preview
@Composable
fun PreviewCheckRule() {
    val navController = rememberNavController()
    CheckRuleScreen { navController.navigate("home") }
}