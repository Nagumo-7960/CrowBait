package com.example.crowbait

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.crowbait.ui.ViewModel.FirstBattleScreenViewModel
import com.example.crowbait.ui.screens.*

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen {
                navController.navigate("first")
            }
        }

        composable("first") {
            val viewModel:FirstBattleScreenViewModel = FirstBattleScreenViewModel()
            FirstBattleScreen (
               toSecond ={ navController.navigate("second")},
                viewModel = viewModel
            )
        }

        composable("second") {
            val viewModel:FirstBattleScreenViewModel = FirstBattleScreenViewModel()
            SecondBattleScreen (
                toResult ={navController.navigate("result")},
                viewModel = viewModel
                )
        }

        composable("result") {
            BattleResultScreen(
                toFirst = { navController.navigate("first") },
                toFinal = { navController.navigate("final") }
            )
        }

        composable("final") {
            FinalResultScreen {
                navController.navigate("home")
            }
        }
    }

}