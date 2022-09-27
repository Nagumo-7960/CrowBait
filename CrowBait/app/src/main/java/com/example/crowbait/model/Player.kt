package com.example.crowbait.model

class Player (){
    var score: Int = 0
    var usedHandsList = mutableListOf<Int>()
    var win: Boolean = false

    fun checkPlayerHand(cardNumber:Int){
        usedHandsList.add(cardNumber)
    }
}