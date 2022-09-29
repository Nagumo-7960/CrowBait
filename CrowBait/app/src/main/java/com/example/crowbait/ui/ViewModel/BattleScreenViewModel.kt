package com.example.crowbait.ui.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class BattleScreenViewModel {
    private val _battleConfirmation: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)
    val battleConfirmation: LiveData<Boolean> get() = _battleConfirmation

    private val _breakConfirmation: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)
    val breakConfirmation: LiveData<Boolean> get() = _breakConfirmation

    fun changeBattleConfirmation() {
        _battleConfirmation.value = _battleConfirmation.value != true
    }

    fun changeBreakConfirmation() {
        _breakConfirmation.value = _breakConfirmation.value != true
    }
}