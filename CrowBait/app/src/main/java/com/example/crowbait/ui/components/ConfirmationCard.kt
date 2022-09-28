package com.example.crowbait.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun HandConfirmationCard(determine_button: () -> Unit, cancel_button: () -> Unit, handCardNumber: Int?) {
    Card(modifier = Modifier.size(370.dp, 200.dp), shape = RoundedCornerShape(20)) {
        Column(
            modifier = Modifier.padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "確認", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Text(text = "${handCardNumber}を選択していいですか？", fontSize = 20.sp)
            Column(modifier = Modifier.padding(top = 20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Card(
                        elevation = 4.dp,
                        modifier = Modifier
                            .size(200.dp, 100.dp)
                            .clickable(
                                enabled = true,
                                onClick = cancel_button
                            )
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = "キャンセル",
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Blue
                            )
                        }
                    }
                    Card(
                        modifier = Modifier
                            .size(200.dp, 100.dp)
                            .clickable(
                                enabled = true,
                                onClick = determine_button
                            )
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = "決定",
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Red
                            )
                        }
                    }
                }
            }

        }
    }
}

@Composable
fun BreakConfirmationCard(determine_button: () -> Unit, cancel_button: () -> Unit) {
    Card(modifier = Modifier.size(370.dp, 200.dp), shape = RoundedCornerShape(20)) {
        Column(
            modifier = Modifier.padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "確認", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Text(text = "ゲームを中断してもいいですか？", fontSize = 20.sp)
            Column(modifier = Modifier.padding(top = 20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Card(
                        elevation = 4.dp,
                        modifier = Modifier
                            .size(200.dp, 100.dp)
                            .clickable(
                                enabled = true,
                                onClick = cancel_button
                            )
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = "キャンセル",
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Blue
                            )
                        }
                    }
                    Card(
                        modifier = Modifier
                            .size(200.dp, 100.dp)
                            .clickable(
                                enabled = true,
                                onClick = determine_button
                            )
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = "決定",
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Red
                            )
                        }
                    }
                }
            }

        }
    }
}

@Preview
@Composable
fun PreviewConfirmationCard() {
    val navController = rememberNavController()
    HandConfirmationCard(
        determine_button = {
            navController.navigate("battle")
        },
        cancel_button = {
            navController.navigate("battle")
        },
        handCardNumber = 1
    )
}