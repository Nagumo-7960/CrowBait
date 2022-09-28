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


var firstCardSet = 1

@Composable
fun FirstBattleScreen(toSecond: () -> Unit, toHome:() -> Unit,viewModel: BattleScreenViewModel) {
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
                        Text(text = "得点：${firstPlayer.score}", fontSize = 30.sp, color = Color.White)
                    }
                }
            }
            Column(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                for(i in 1..11 step 5){
                    Row(modifier = Modifier.padding(top = 20.dp)) {
                        for (j in i..i+4) {
                            Column(modifier = Modifier.padding(start = 10.dp)) {
                                if (firstPlayer.usedHandsList.contains(j)) {
                                    NonSelectCard(
                                        selectCardNumber = j,
                                    )
                                } else {
                                    SelectCard(
                                        selectCardNumber = j,
                                        onClick = { firstChangeConfirmation(j, viewModel) })
                                }
                            }
                        }
                    }
                }
            }

        }
        if (isBattleConfirmation == true) {
            HandConfirmationCard(
                determine_button = { getFirstPlayerHand(firstCardSet,toSecond) },
                cancel_button = { viewModel.changeBattleConfirmation() },
                handCardNumber = firstCardSet
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

fun getFirstPlayerHand(handNumber: Int, toSecond: () -> Unit, ) {
    //配列の(n回戦)番目に出す手の数字を入れる
    firstPlayer.usedHandsList.add(handNumber)
    toSecond()
}

fun firstChangeConfirmation(handNumber: Int, viewModel: BattleScreenViewModel){
    firstCardSet = handNumber
    viewModel.changeBattleConfirmation()
}

@Preview
@Composable
fun PreviewBattleScreen() {
    val navController = rememberNavController()
    val viewModel: BattleScreenViewModel = BattleScreenViewModel()
    FirstBattleScreen(
        toSecond = {navController.navigate("second")},
        toHome = {navController.navigate("home")},
        viewModel = viewModel
    )
}