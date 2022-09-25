package com.example.crowbait.ui.screens

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

var secondCardSet = 1
var winnerColor: Color = Color.White

@Composable
fun SecondBattleScreen(toResult: () -> Unit, toHome: () -> Unit, viewModel: BattleScreenViewModel) {
    val isBattleConfirmation = viewModel.battleConfirmation.observeAsState().value
    val isBreakConfirmation = viewModel.breakConfirmation.observeAsState().value
    BattleBreakCard(
        toConfirm = { viewModel.changeBreakConfirmation() }
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
                            text = "得点：${secondPlayer.score}",
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
                for (i in 1..11 step 5) {
                    Row(modifier = Modifier.padding(top = 20.dp)) {
                        for (j in i..i + 4) {
                            Column(modifier = Modifier.padding(start = 10.dp)) {
                                if (secondPlayer.usedHandsList.contains(j)) {
                                    NonSelectCard(
                                        selectCardNumber = j,
                                    )
                                } else {
                                    SelectCard(
                                        selectCardNumber = j,
                                        onClick = { secondChangeConfirmation(j, viewModel) })
                                }
                            }
                        }
                    }
                }
            }

        }
        if (isBattleConfirmation == true) {
            HandConfirmationCard(
                determine_button = { getSecondPlayerHand(secondCardSet, toResult) },
                cancel_button = { viewModel.changeBattleConfirmation() },
                deckCardNumber = secondCardSet
            )
        }
        if (isBreakConfirmation == true) {
            BreakConfirmationCard(
                determine_button = toHome,
                cancel_button = { viewModel.changeBreakConfirmation() }
            )
        }
    }
}

fun getSecondPlayerHand(handNumber: Int, toResult: () -> Unit) {
    //配列の(n回戦)番目に出す手の数字を入れる
    secondPlayer.usedHandsList.add(handNumber)
    battleResultCheck()
    toResult()
}

fun secondChangeConfirmation(handNumber: Int, viewModel: BattleScreenViewModel) {
    secondCardSet = handNumber
    viewModel.changeBattleConfirmation()
}

fun battleResultCheck() {
    if (deckNumber > 0) {
        //相手が15を出している時、自分が1を出したら自分の得点になる
        if (secondPlayer.usedHandsList[battleRound - 1] == 15) {
            if (firstPlayer.usedHandsList[battleRound - 1] == 1) {
                firstPlayer.score += deckNumber
                winnerColor = Color.Yellow
                return
            }
        }
        if (firstPlayer.usedHandsList[battleRound - 1] == 15) {
            if (secondPlayer.usedHandsList[battleRound - 1] == 1) {
                secondPlayer.score += deckNumber
                winnerColor = Color.Cyan
                return
            }
        }

        //相手より1だけ大きい数字の手札を出した場合は、獲得する得点が倍になる
        if (firstPlayer.usedHandsList[battleRound - 1] == secondPlayer.usedHandsList[battleRound - 1] + 1) {
            firstPlayer.score += deckNumber * 2
            winnerColor = Color.Yellow
            return
        }
        if (secondPlayer.usedHandsList[battleRound - 1] == firstPlayer.usedHandsList[battleRound - 1] + 1) {
            secondPlayer.score += deckNumber * 2
            winnerColor = Color.Cyan
            return
        }

        if (firstPlayer.usedHandsList[battleRound - 1] > secondPlayer.usedHandsList[battleRound - 1]) {
            firstPlayer.score += deckNumber
            winnerColor = Color.Yellow
        }
        if (secondPlayer.usedHandsList[battleRound - 1] > firstPlayer.usedHandsList[battleRound - 1]) {
            secondPlayer.score += deckNumber
            winnerColor = Color.Cyan
        }
    } else {
        //得点がマイナスの時
        //相手が15を出している時、自分が1を出したら相手の得点になる
        if (secondPlayer.usedHandsList[battleRound - 1] == 15) {
            if (firstPlayer.usedHandsList[battleRound - 1] == 1) {
                secondPlayer.score += deckNumber
                winnerColor = Color.Cyan
                return
            }
        }
        if (firstPlayer.usedHandsList[battleRound - 1] == 15) {
            if (secondPlayer.usedHandsList[battleRound - 1] == 1) {
                firstPlayer.score += deckNumber
                winnerColor = Color.Yellow
                return
            }
        }

        //相手より1だけ大きい数字の手札を出した場合は、獲得する得点が倍になる
        if (firstPlayer.usedHandsList[battleRound - 1] == secondPlayer.usedHandsList[battleRound - 1] + 1) {
            secondPlayer.score += deckNumber * 2
            winnerColor = Color.Yellow
            return
        }
        if (secondPlayer.usedHandsList[battleRound - 1] == firstPlayer.usedHandsList[battleRound - 1] + 1) {
            firstPlayer.score += deckNumber * 2
            winnerColor = Color.Cyan
            return
        }

        if (firstPlayer.usedHandsList[battleRound - 1] > secondPlayer.usedHandsList[battleRound - 1]) {
            secondPlayer.score += deckNumber
            winnerColor = Color.Yellow
        }
        if (secondPlayer.usedHandsList[battleRound - 1] > firstPlayer.usedHandsList[battleRound - 1]) {
            firstPlayer.score += deckNumber
            winnerColor = Color.Cyan
        }

    }

}

@Preview
@Composable
fun PreviewSecondBattleScreen() {
    val navController = rememberNavController()
    SecondBattleScreen(
        toResult = { navController.navigate("result") },
        toHome = { navController.navigate("home") },
        viewModel = BattleScreenViewModel()
    )
}
