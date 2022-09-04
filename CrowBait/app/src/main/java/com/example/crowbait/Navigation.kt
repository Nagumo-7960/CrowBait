package com.example.crowbait

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.crowbait.ui.ViewModel.BattleScreenViewModel
import com.example.crowbait.ui.screens.*

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("checkrule") {
            CheckRuleScreen { navController.navigate("home") }
        }

        composable("home") {
            HomeScreen(
                toCheckRule = { navController.navigate("checkrule") },
                toStart = { navController.navigate("first") }
            )
        }

        composable("first") {
            val viewModel: BattleScreenViewModel = BattleScreenViewModel()
            FirstBattleScreen(
                toSecond = { navController.navigate("pass") },
                toHome = { navController.navigate("home") },
                viewModel = viewModel
            )
        }

        composable("pass") {
            val viewModel: BattleScreenViewModel = BattleScreenViewModel()
            PassScreen (
                toSecond = {navController.navigate("second") },
                toHome = {navController.navigate("home")},
                viewModel = viewModel
            )
        }

        composable("second") {
            val viewModel: BattleScreenViewModel = BattleScreenViewModel()
            SecondBattleScreen(
                toResult = { navController.navigate("result") },
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