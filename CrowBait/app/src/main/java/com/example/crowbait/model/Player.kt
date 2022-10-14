package com.example.crowbait.model

class Player (){
    var score: Int = 0
    var previousScore : Int = 0
    var usedHandsList = mutableListOf<Int>()

    fun checkPlayerHand(cardNumber:Int){
        usedHandsList.add(cardNumber)
    }
}