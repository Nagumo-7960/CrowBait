package com.example.crowbait.ui.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class BattleScreenViewModel {
    private val _battleConfirmation:MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)
    val battleConfirmation: LiveData<Boolean> get() = _battleConfirmation

    private val _breakConfirmation:MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)
    val breakConfirmation: LiveData<Boolean> get() = _breakConfirmation

    fun changeBattleConfirmation(){
        if(_battleConfirmation.value==true) _battleConfirmation.value=false
        else _battleConfirmation.value = true
    }
    fun changeBreakConfirmation(){
        if(_breakConfirmation.value==true) _breakConfirmation.value=false
        else _breakConfirmation.value = true
    }
}