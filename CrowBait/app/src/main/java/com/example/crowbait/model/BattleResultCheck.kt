package com.example.crowbait.model

import androidx.compose.ui.graphics.Color
import com.example.crowbait.ui.screens.battleRound
import com.example.crowbait.ui.screens.deckNumber
import com.example.crowbait.ui.screens.winnerColor

class BattleResultCheck {

    var winPlayer:String = ""

    fun battleResultCheck(firstPlayer: Player,secondPlayer: Player){
        if(firstPlayer.usedHandsList[battleRound-1]==secondPlayer.usedHandsList[battleRound-1]){
            winPlayer = "none"
        }
        if (deckNumber > 0) {
            //相手が15を出している時、自分が1を出したら自分の得点になる
            if (com.example.crowbait.ui.screens.secondPlayer.usedHandsList[battleRound - 1] == 15) {
                if (com.example.crowbait.ui.screens.firstPlayer.usedHandsList[battleRound - 1] == 1) {
                    com.example.crowbait.ui.screens.firstPlayer.score += deckNumber
                    winPlayer = "first"
                    firstPlayer.win=true
                    return
                }
            }
            if (com.example.crowbait.ui.screens.firstPlayer.usedHandsList[battleRound - 1] == 15) {
                if (com.example.crowbait.ui.screens.secondPlayer.usedHandsList[battleRound - 1] == 1) {
                    com.example.crowbait.ui.screens.secondPlayer.score += deckNumber
                    winPlayer = "second"
                    return
                }
            }

            //相手より1だけ大きい数字の手札を出した場合は、獲得する得点が倍になる
            if (com.example.crowbait.ui.screens.firstPlayer.usedHandsList[battleRound - 1] == com.example.crowbait.ui.screens.secondPlayer.usedHandsList[battleRound - 1] + 1) {
                com.example.crowbait.ui.screens.firstPlayer.score += deckNumber * 2
                winPlayer = "first"
                return
            }
            if (com.example.crowbait.ui.screens.secondPlayer.usedHandsList[battleRound - 1] == com.example.crowbait.ui.screens.firstPlayer.usedHandsList[battleRound - 1] + 1) {
                com.example.crowbait.ui.screens.secondPlayer.score += deckNumber * 2
                winPlayer = "second"
                return
            }

            if (com.example.crowbait.ui.screens.firstPlayer.usedHandsList[battleRound - 1] > com.example.crowbait.ui.screens.secondPlayer.usedHandsList[battleRound - 1]) {
                com.example.crowbait.ui.screens.firstPlayer.score += deckNumber
                winPlayer = "first"
            }
            if (com.example.crowbait.ui.screens.secondPlayer.usedHandsList[battleRound - 1] > com.example.crowbait.ui.screens.firstPlayer.usedHandsList[battleRound - 1]) {
                com.example.crowbait.ui.screens.secondPlayer.score += deckNumber
                winPlayer = "second"
            }
        } else {
            //得点がマイナスの時
            //相手が15を出している時、自分が1を出したら相手の得点になる
            if (com.example.crowbait.ui.screens.secondPlayer.usedHandsList[battleRound - 1] == 15) {
                if (com.example.crowbait.ui.screens.firstPlayer.usedHandsList[battleRound - 1] == 1) {
                    com.example.crowbait.ui.screens.secondPlayer.score += deckNumber
                    winPlayer = "first"
                    return
                }
            }
            if (com.example.crowbait.ui.screens.firstPlayer.usedHandsList[battleRound - 1] == 15) {
                if (com.example.crowbait.ui.screens.secondPlayer.usedHandsList[battleRound - 1] == 1) {
                    com.example.crowbait.ui.screens.firstPlayer.score += deckNumber
                    winPlayer = "second"
                    return
                }
            }

            //相手より1だけ大きい数字の手札を出した場合は、獲得する得点が倍になる
            if (com.example.crowbait.ui.screens.firstPlayer.usedHandsList[battleRound - 1] == com.example.crowbait.ui.screens.secondPlayer.usedHandsList[battleRound - 1] + 1) {
                com.example.crowbait.ui.screens.secondPlayer.score += deckNumber * 2
                winPlayer = "first"
                return
            }
            if (com.example.crowbait.ui.screens.secondPlayer.usedHandsList[battleRound - 1] == com.example.crowbait.ui.screens.firstPlayer.usedHandsList[battleRound - 1] + 1) {
                com.example.crowbait.ui.screens.firstPlayer.score += deckNumber * 2
                winPlayer = "second"
                return
            }

            if (com.example.crowbait.ui.screens.firstPlayer.usedHandsList[battleRound - 1] > com.example.crowbait.ui.screens.secondPlayer.usedHandsList[battleRound - 1]) {
                com.example.crowbait.ui.screens.secondPlayer.score += deckNumber
                winPlayer = "first"
            }
            if (com.example.crowbait.ui.screens.secondPlayer.usedHandsList[battleRound - 1] > com.example.crowbait.ui.screens.firstPlayer.usedHandsList[battleRound - 1]) {
                com.example.crowbait.ui.screens.firstPlayer.score += deckNumber
                winPlayer = "second"
            }

        }

    }
}