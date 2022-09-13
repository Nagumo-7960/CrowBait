package com.example.crowbait.model

class Player (){
    val score: Int = 0
    val usedHandsList = mutableListOf<Int>()

    fun checkPlayerHand(cardNumber:Int){
        usedHandsList.add(cardNumber)
    }
}