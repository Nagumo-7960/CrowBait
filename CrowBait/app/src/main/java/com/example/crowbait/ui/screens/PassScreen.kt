package com.example.crowbait.ui.screens

import androidx.compose.foundation.clickable
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
import com.example.crowbait.ui.ViewModel.BattleScreenViewModel
import com.example.crowbait.ui.components.BattleBreakCard
import com.example.crowbait.ui.components.BreakConfirmationCard

@Composable
fun PassScreen(toSecond: () -> Unit, toHome: () -> Unit, viewModel: BattleScreenViewModel) {
    val isBreakConfirmation = viewModel.breakConfirmation.observeAsState().value
    BattleBreakCard(
        toConfirm = { viewModel.changeBreakConfirmation() }
    )
    Box(contentAlignment = Alignment.Center) {
        if (isBreakConfirmation == true) {
            BreakConfirmationCard(
                determine_button = toHome,
                cancel_button = { viewModel.changeBreakConfirmation() }
            )
        }
        Column(
            modifier = Modifier.padding(top = 250.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "後攻プレイヤーに渡してください", fontSize = 20.sp, color = Color.White)

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                Card(
                    modifier = Modifier
                        .size(290.dp, 75.dp)
                        .clickable(
                            enabled = true,
                            onClick = toSecond
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "私は後攻プレイヤーです", fontSize = 25.sp)
                    }
                }
            }
        }
    }


}


//@Preview
//@Composable
//fun PreviewPassScreen(){
//    val navController = rememberNavController()
//    PassScreen{navController.navigate("second")}
//}