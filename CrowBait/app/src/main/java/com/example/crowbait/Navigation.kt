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
                toHome = {navController.navigate("home")},
                viewModel = viewModel
            )
        }

        composable("result") {
            val viewModel: BattleScreenViewModel = BattleScreenViewModel()
            RoundResultScreen(
                toFirst = { navController.navigate("first") },
                toHome = {navController.navigate("home")},
                toFinal = { navController.navigate("final") },
                viewModel = viewModel
            )
        }

        composable("final") {
            FinalResultScreen {
                navController.navigate("home")
            }
        }
    }

}