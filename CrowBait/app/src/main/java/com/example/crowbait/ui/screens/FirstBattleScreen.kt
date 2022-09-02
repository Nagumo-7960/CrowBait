package com.example.crowbait.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.crowbait.ui.ViewModel.FirstBattleScreenViewModel
import com.example.crowbait.ui.components.*

var battleRound = 1
var firstPlayerHand: Array<Int?> = arrayOfNulls(15)
var firstPlayerPoint = 0
var firstCardSet = 1

@Composable
fun FirstBattleScreen(toSecond: () -> Unit, viewModel: FirstBattleScreenViewModel) {
    val isConfirmation = viewModel.confirmation.observeAsState().value
    BattleBreakCard()
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.padding(
                    top = 20.dp
                )
            ) {
                Text(text = "${battleRound}回戦", fontSize = 30.sp, color = Color.White)
            }
            Column(
                modifier = Modifier.padding(
                    top = 20.dp
                )
            ) {
                DeckCard(deckCardNumber = deckNumber)
            }
            Column(modifier = Modifier.padding(top = 40.dp)) {
                Row {
                    Card{
                        Text(
                            modifier = Modifier
                                .background(color = Color.Yellow)
                                .padding(start = 10.dp, end = 10.dp),
                            text = "先攻プレイヤー",
                            fontSize = 30.sp
                        )
                    }
                    Row(modifier = Modifier.padding(start = 10.dp)) {
                        Text(text = "得点：${firstPlayerPoint}", fontSize = 30.sp, color = Color.White)
                    }
                }
            }
            Column(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Row {
                    for (i in 1..5) {
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            if (firstPlayerHand.contains(i)) {
                                NonSelectCard(selectCardNumber = i)
                            } else {
                                SelectCard(
                                    selectCardNumber = i,
                                    onClick = { firstChangeConfirmation(i, viewModel) })
                            }
                        }

                    }
                }
                Row(modifier = Modifier.padding(top = 20.dp)) {
                    for (i in 6..10) {
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            if (firstPlayerHand.contains(i)) {
                                NonSelectCard(selectCardNumber = i)
                            } else {
                                SelectCard(
                                    selectCardNumber = i,
                                    onClick = { firstChangeConfirmation(i, viewModel) })
                            }
                        }
                    }
                }
                Row(modifier = Modifier.padding(top = 20.dp)) {
                    for (i in 11..15) {
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            if (firstPlayerHand.contains(i)) {
                                NonSelectCard(selectCardNumber = i)
                            } else {
                                SelectCard(
                                    selectCardNumber = i,
                                    onClick = { firstChangeConfirmation(i, viewModel) })
                            }
                        }
                    }
                }
            }

        }
        if (isConfirmation == true) {
            HandConfirmationCard(
                determine_button = { getFirstPlayerHand(firstCardSet,toSecond) },
                cancel_button = { viewModel.changeConfirmation() },
                deckCardNumber = firstCardSet
            )
        }
    }

}

fun getFirstPlayerHand(handNumber: Int, toSecond: () -> Unit, ) {
    //配列の(n回戦)番目に出す手の数字を入れる
    firstPlayerHand[battleRound - 1] = handNumber
    Log.d("debag", "firstPlayerHand:${firstPlayerHand[battleRound - 1]}")
    toSecond()
}

fun firstChangeConfirmation(handNumber: Int, viewModel: FirstBattleScreenViewModel){
    firstCardSet = handNumber
    viewModel.changeConfirmation()
}

@Preview
@Composable
fun PreviewBattleScreen() {
    val navController = rememberNavController()
    val viewModel: FirstBattleScreenViewModel = FirstBattleScreenViewModel()
    FirstBattleScreen(
        toSecond = {navController.navigate("second")},
        viewModel = viewModel
    )
}