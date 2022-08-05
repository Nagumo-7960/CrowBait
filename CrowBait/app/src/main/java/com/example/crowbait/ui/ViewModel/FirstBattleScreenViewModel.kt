package com.example.crowbait.ui.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FirstBattleScreenViewModel {
    private val _confirmation:MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)
    val confirmation: LiveData<Boolean> get() = _confirmation

    fun changeConfirmation(){
        if(_confirmation.value==true) _confirmation.value=false
        else _confirmation.value = true
    }
}