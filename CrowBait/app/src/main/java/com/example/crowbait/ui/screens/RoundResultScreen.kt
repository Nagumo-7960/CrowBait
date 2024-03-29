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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.crowbait.ui.ViewModel.BattleScreenViewModel
import com.example.crowbait.ui.components.*

@Composable
fun RoundResultScreen(
    toFirst: () -> Unit,
    toFinal: () -> Unit,
    toHome: () -> Unit,
    viewModel: BattleScreenViewModel
) {
    when (roundResultCheck.winner) {
        "first" -> {
            winnerColor = Color.Yellow
        }
        "second" -> {
            winnerColor = Color.Cyan
        }
        else -> {
            winnerColor = Color.White
        }
    }

    Log.d("deckNumber", "deckNumber:${deckNumber}")
    val isBreakConfirmation = viewModel.breakConfirmation.observeAsState().value
    BattleBreakCard(
        toConfirm = { viewModel.changeBreakConfirmation() }
    )
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.fillMaxSize(),
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
            Column(modifier = Modifier.padding(top = 20.dp)) {
                Card(
                    modifier = Modifier
                        .size(340.dp, 90.dp),
                    backgroundColor = winnerColor
                ) {
                    Box(contentAlignment = Alignment.Center) {

                        if (roundResultCheck.winner == "first") {
                            Text(
                                modifier = Modifier
                                    .padding(start = 20.dp, end = 20.dp),
                                text = "先攻プレイヤーの勝ち",
                                fontSize = 25.sp
                            )
                        } else if (roundResultCheck.winner == "second") {
                            Text(
                                modifier = Modifier
                                    .padding(start = 20.dp, end = 20.dp),
                                text = "後攻プレイヤーの勝ち",
                                fontSize = 25.sp
                            )
                        } else if (roundResultCheck.winner == "none") {
                            Text(
                                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                                text = "引き分け",
                                fontSize = 25.sp
                            )
                        }
                    }
                }
            }
            Column(modifier = Modifier.padding(top = 30.dp)) {
                Row {
                    Column {
                        BigSelectCard(selectCardNumber = firstPlayer.usedHandsList.last())
                        Column(modifier = Modifier.padding(top = 10.dp)) {
                            Text(text = "先攻プレイヤー", fontSize = 15.sp, color = Color.White)
                            if (roundResultCheck.winner == "first" && deckNumber > 0) {
                                Text(
                                    text = "得点:${firstPlayer.previousScore}→${firstPlayer.score}",
                                    fontSize = 15.sp,
                                    color = Color.White
                                )
                            } else if (roundResultCheck.winner == "second" && deckNumber < 0) {
                                Text(
                                    text = "得点:${firstPlayer.previousScore}→${firstPlayer.score}",
                                    fontSize = 15.sp,
                                    color = Color.White
                                )
                            } else {
                                Text(
                                    text = "得点:${firstPlayer.score}",
                                    fontSize = 15.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }
                    Column(modifier = Modifier.padding(start = 30.dp)) {
                        BigSelectCard(selectCardNumber = secondPlayer.usedHandsList.last())
                        Column(modifier = Modifier.padding(top = 10.dp)) {
                            Text(text = "後攻プレイヤー", fontSize = 15.sp, color = Color.White)
                            if (roundResultCheck.winner == "second" && deckNumber > 0) {
                                Text(
                                    text = "得点:${secondPlayer.previousScore}→${secondPlayer.score}",
                                    fontSize = 15.sp,
                                    color = Color.White
                                )
                            } else if (roundResultCheck.winner == "first" && deckNumber < 0) {
                                Text(
                                    text = "得点:${secondPlayer.previousScore}→${secondPlayer.score}",
                                    fontSize = 15.sp,
                                    color = Color.White
                                )
                            } else {
                                Text(
                                    text = "得点:${secondPlayer.score}",
                                    fontSize = 15.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
            Column(modifier = Modifier.padding(top = 20.dp)) {
                if (battleRound == deckNumberList.size) {
                    FinalRoundCard {
                        toFinal()
                    }
                } else {
                    NextRoundCard(
                        onClick = { toFirst() }
                    )
                }
            }
        }
        if (isBreakConfirmation == true) {
            BreakConfirmationCard(
                determine_button = toHome,
                cancel_button = { viewModel.changeBreakConfirmation() }
            )
        }
    }
}

fun roundPlus(toFirst: () -> Unit) {
    battleRound++
    toFirst()
    setDeckNumber()
}

@Preview
@Composable
fun PreviewRoundResultScreen() {
    val navController = rememberNavController()
    firstPlayer.usedHandsList.add(5)
    secondPlayer.usedHandsList.add(3)
    roundResultCheck.roundResultCheck(firstPlayer, secondPlayer)
    RoundResultScreen(
        toFirst = { navController.navigate("first") },
        toFinal = { navController.navigate("final") },
        toHome = { navController.navigate("home") },
        viewModel = BattleScreenViewModel()
    )
}