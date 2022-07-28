package com.example.crowbait.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
fun SelectCard(selectCardNumber: Int, onClick: () -> Unit) {
    Box(contentAlignment = Alignment.Center) {
        Card(
            modifier = Modifier
                .size(50.dp, 50.dp)
                .clickable(
                    enabled = true,
                    onClick = onClick
                ),
            shape = CircleShape,
        ) {
            //手動でテキストの位置を調整しているので、要修正
            if (selectCardNumber < 10) {
                Text(
                    modifier = Modifier.padding(top = 10.dp, start = 18.dp),
                    text = selectCardNumber.toString(), fontSize = 20.sp
                )
            } else {
                Text(
                    modifier = Modifier.padding(top = 10.dp, start = 13.dp),
                    text = selectCardNumber.toString(), fontSize = 20.sp
                )
            }

        }
    }

}

@Composable
fun NonSelectCard(selectCardNumber: Int, onClick: () -> Unit) {
    Box(contentAlignment = Alignment.Center) {
        Card(
            modifier = Modifier
                .size(50.dp, 50.dp)
                .clickable(
                    enabled = false,
                    onClick = onClick
                ),
            shape = CircleShape,
            backgroundColor = Color.Gray
        ) {
            //手動でテキストの位置を調整しているので、要修正
            if (selectCardNumber < 10) {
                Text(
                    modifier = Modifier.padding(top = 10.dp, start = 18.dp),
                    text = selectCardNumber.toString(), fontSize = 20.sp
                )
            } else {
                Text(
                    modifier = Modifier.padding(top = 10.dp, start = 13.dp),
                    text = selectCardNumber.toString(), fontSize = 20.sp
                )
            }

        }
    }

}

@Preview
@Composable
fun PreviewSelectCard() {
    val navController = rememberNavController()
    SelectCard(
        10,
        onClick = {
            navController.navigate("battle")
        }
    )
}

@Preview
@Composable
fun PreviewNonSelectCard() {
    val navController = rememberNavController()
    NonSelectCard(
        10,
        onClick = {
            navController.navigate("battle")
        }
    )
}
