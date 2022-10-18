package com.example.crowbait.model

import com.example.crowbait.ui.screens.battleRound
import com.example.crowbait.ui.screens.deckNumber

class RoundResultCheck {

    var winner: String = ""

    fun roundResultCheck(firstPlayer: Player, secondPlayer: Player) {
        if (firstPlayer.usedHandsList[battleRound - 1] == secondPlayer.usedHandsList[battleRound - 1]) {
            winner = "none"
        }
        if (deckNumber > 0) {
            //相手が15を出している時、自分が1を出したら自分の得点になる
            if (secondPlayer.usedHandsList[battleRound - 1] == 15) {
                if (firstPlayer.usedHandsList[battleRound - 1] == 1) {
                    firstPlayer.previousScore = firstPlayer.score
                    firstPlayer.score += deckNumber
                    winner = "first"
                    return
                }
            }
            if (firstPlayer.usedHandsList[battleRound - 1] == 15) {
                if (secondPlayer.usedHandsList[battleRound - 1] == 1) {
                    secondPlayer.previousScore = secondPlayer.score
                    secondPlayer.score += deckNumber
                    winner = "second"
                    return
                }
            }

            //相手より1だけ大きい数字の手札を出した場合は、獲得する得点が倍になる
            if (firstPlayer.usedHandsList[battleRound - 1] == secondPlayer.usedHandsList[battleRound - 1] + 1) {
                firstPlayer.previousScore = firstPlayer.score
                firstPlayer.score += deckNumber * 2
                winner = "first"
                return
            }
            if (secondPlayer.usedHandsList[battleRound - 1] == firstPlayer.usedHandsList[battleRound - 1] + 1) {
                secondPlayer.previousScore = secondPlayer.score
                secondPlayer.score += deckNumber * 2
                winner = "second"
                return
            }

            if (firstPlayer.usedHandsList[battleRound - 1] > secondPlayer.usedHandsList[battleRound - 1]) {
                firstPlayer.previousScore = firstPlayer.score
                firstPlayer.score += deckNumber
                winner = "first"
                return
            }
            if (secondPlayer.usedHandsList[battleRound - 1] > firstPlayer.usedHandsList[battleRound - 1]) {
                secondPlayer.previousScore = secondPlayer.score
                secondPlayer.score += deckNumber
                winner = "second"
                return
            }
        } else {
            //得点がマイナスの時
            //相手が15を出している時、自分が1を出したら相手の得点になる
            if (secondPlayer.usedHandsList[battleRound - 1] == 15) {
                if (firstPlayer.usedHandsList[battleRound - 1] == 1) {
                    secondPlayer.previousScore = secondPlayer.score
                    secondPlayer.score += deckNumber
                    winner = "first"
                    return
                }
            }
            if (firstPlayer.usedHandsList[battleRound - 1] == 15) {
                if (secondPlayer.usedHandsList[battleRound - 1] == 1) {
                    firstPlayer.previousScore = firstPlayer.score
                    firstPlayer.score += deckNumber
                    winner = "second"
                    return
                }
            }

            //相手より1だけ大きい数字の手札を出した場合は、獲得する得点が倍になる
            if (firstPlayer.usedHandsList[battleRound - 1] == secondPlayer.usedHandsList[battleRound - 1] + 1) {
                secondPlayer.previousScore = secondPlayer.score
                secondPlayer.score += deckNumber * 2
                winner = "first"
                return
            }
            if (secondPlayer.usedHandsList[battleRound - 1] == firstPlayer.usedHandsList[battleRound - 1] + 1) {
                firstPlayer.previousScore = firstPlayer.score
                firstPlayer.score += deckNumber * 2
                winner = "second"
                return
            }

            if (firstPlayer.usedHandsList[battleRound - 1] > secondPlayer.usedHandsList[battleRound - 1]) {
                secondPlayer.previousScore = secondPlayer.score
                secondPlayer.score += deckNumber
                winner = "first"
                return
            }
            if (secondPlayer.usedHandsList[battleRound - 1] > firstPlayer.usedHandsList[battleRound - 1]) {
                firstPlayer.previousScore = firstPlayer.score
                firstPlayer.score += deckNumber
                winner = "second"
                return
            }

        }

    }
}