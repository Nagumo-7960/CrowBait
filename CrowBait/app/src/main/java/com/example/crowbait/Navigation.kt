package com.example.crowbait

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.crowbait.ui.screens.FirstBattleScreen
import com.example.crowbait.ui.screens.HomeScreen
import com.example.crowbait.ui.screens.SecondBattleScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(){
                navController.navigate("first")
            }
        }

        composable("first") {
            FirstBattleScreen(){
                navController.navigate("second")
            }
        }

        composable("second") {
            SecondBattleScreen()
        }
    }

}