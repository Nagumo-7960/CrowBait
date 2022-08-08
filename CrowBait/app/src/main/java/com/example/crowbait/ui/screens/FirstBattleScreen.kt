package com.example.crowbait.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.crowbait.ui.ViewModel.FirstBattleScreenViewModel
import com.example.crowbait.ui.components.ConfirmationCard
import com.example.crowbait.ui.components.DeckCard
import com.example.crowbait.ui.components.NonSelectCard
import com.example.crowbait.ui.components.SelectCard

var battleRound = 1
var firstPlayerHand: Array<Int?> = arrayOfNulls(15)
var firstPlayerPoint = 0
var cardSet = 1

@Composable
fun FirstBattleScreen(toSecond: () -> Unit, viewModel: FirstBattleScreenViewModel) {
    val isConfirmation = viewModel.confirmation.observeAsState().value

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
                            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
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
                                    onClick = { changeConfirmation(i, viewModel) })
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
                                    onClick = { changeConfirmation(i, viewModel) })
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
                                    onClick = { changeConfirmation(i, viewModel) })
                            }
                        }
                    }
                }
            }

        }
        if (isConfirmation == true) {
            ConfirmationCard(
                determine_button = { getFirstPlayerHand(cardSet,toSecond) },
                cancel_button = { viewModel.changeConfirmation() },
                deckCardNumber = cardSet
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

fun changeConfirmation(handNumber: Int, viewModel: FirstBattleScreenViewModel){
    cardSet = handNumber
    viewModel.changeConfirmation()
}

//@Preview
//@Composable
//fun PreviewBattleScreen() {
//    val navController = rememberNavController()
//    FirstBattleScreen{
//        navController.navigate("second")
//    }
//}