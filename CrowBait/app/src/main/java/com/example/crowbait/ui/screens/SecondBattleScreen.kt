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
import com.example.crowbait.ui.ViewModel.BattleScreenViewModel
import com.example.crowbait.ui.components.*

var secondPlayerHand: Array<Int?> = arrayOfNulls(15)
var secondPlayerPoint = 0
var secondCardSet = 1
var winnerColor:Color = Color.White

@Composable
fun SecondBattleScreen(toResult: () -> Unit, toHome:() -> Unit, viewModel: BattleScreenViewModel) {
    val isBattleConfirmation = viewModel.battleConfirmation.observeAsState().value
    val isBreakConfirmation = viewModel.breakConfirmation.observeAsState().value
    BattleBreakCard(
        toConfirm = {viewModel.changeBreakConfirmation()}
    )
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
                    Card {
                        Text(
                            modifier = Modifier
                                .background(color = Color.Cyan)
                                .padding(start = 10.dp, end = 10.dp),
                            text = "後攻プレイヤー",
                            fontSize = 30.sp
                        )
                    }
                    Row(modifier = Modifier.padding(start = 10.dp)) {
                        Text(
                            text = "得点：${secondPlayerPoint}",
                            fontSize = 30.sp,
                            color = Color.White
                        )
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
                            if (secondPlayer.usedHandsList.contains(i)) {
                                NonSelectCard(
                                    selectCardNumber = i,
                                )
                            } else {
                                SelectCard(
                                    selectCardNumber = i,
                                    onClick = { secondChangeConfirmation(i, viewModel) })
                            }
                        }
                    }
                }
                Row(modifier = Modifier.padding(top = 20.dp)) {
                    for (i in 6..10) {
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            if (secondPlayer.usedHandsList.contains(i)) {
                                NonSelectCard(
                                    selectCardNumber = i,
                                )
                            } else {
                                SelectCard(
                                    selectCardNumber = i,
                                    onClick = { secondChangeConfirmation(i, viewModel) })
                            }
                        }
                    }
                }
                Row(modifier = Modifier.padding(top = 20.dp)) {
                    for (i in 11..15) {
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            if (secondPlayer.usedHandsList.contains(i)) {
                                NonSelectCard(
                                    selectCardNumber = i,
                                )
                            } else {
                                SelectCard(
                                    selectCardNumber = i,
                                    onClick = { secondChangeConfirmation(i, viewModel) })
                            }
                        }
                    }
                }
            }

        }
        if (isBattleConfirmation == true) {
            HandConfirmationCard(
                determine_button = { getSecondPlayerHand(secondCardSet,toResult) },
                cancel_button = { viewModel.changeBattleConfirmation() },
                deckCardNumber = secondCardSet
            )
        }
        if(isBreakConfirmation == true){
            BreakConfirmationCard(
                determine_button = toHome,
                cancel_button = { viewModel.changeBreakConfirmation() }
            )
        }
    }
}

fun getSecondPlayerHand(handNumber: Int, toResult: () -> Unit, ) {
    //配列の(n回戦)番目に出す手の数字を入れる
    secondPlayer.usedHandsList.add(handNumber)
    secondPlayerHand[battleRound - 1] = handNumber
    Log.d("debag", "secondPlayerHand:${secondPlayerHand[battleRound - 1]}")
    finalBattleResultCheck()
    toResult()
}

fun secondChangeConfirmation(handNumber: Int, viewModel: BattleScreenViewModel){
    secondCardSet = handNumber
    viewModel.changeBattleConfirmation()
}

fun finalBattleResultCheck() {
    if (deckNumber>0){
        if (firstPlayerHand[battleRound - 1]!! > secondPlayerHand[battleRound - 1]!!) {
            firstPlayerPoint += deckNumber
            winnerColor = Color.Yellow
        }
        if (secondPlayerHand[battleRound - 1]!! > firstPlayerHand[battleRound - 1]!!) {
            secondPlayerPoint += deckNumber
            winnerColor = Color.Cyan
        }
    }else{
        if (firstPlayerHand[battleRound - 1]!! > secondPlayerHand[battleRound - 1]!!) {
            secondPlayerPoint += deckNumber
            winnerColor = Color.Yellow
        }
        if (secondPlayerHand[battleRound - 1]!! > firstPlayerHand[battleRound - 1]!!) {
            firstPlayerPoint += deckNumber
            winnerColor = Color.Cyan
        }

    }

}

@Preview
@Composable
fun PreviewSecondBattleScreen() {
    val navController = rememberNavController()
    SecondBattleScreen (
        toResult = {navController.navigate("result")},
        toHome = {navController.navigate("home")},
        viewModel = BattleScreenViewModel()
    )
}
