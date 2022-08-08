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
fun ConfirmationCard(determine_button: () -> Unit, cancel_button: () -> Unit,deckCardNumber: Int?) {
    Card(modifier = Modifier.size(400.dp, 200.dp), shape = RoundedCornerShape(20)) {
        Column(
            modifier = Modifier.padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "確認", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Text(text = "${deckCardNumber}を選択していいですか？", fontSize = 20.sp)
            Column(modifier = Modifier.padding(top = 20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Card(
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
    ConfirmationCard(
        determine_button = {
            navController.navigate("battle")
        },
        cancel_button = {
            navController.navigate("battle")
        },
        deckCardNumber = 1
    )
}