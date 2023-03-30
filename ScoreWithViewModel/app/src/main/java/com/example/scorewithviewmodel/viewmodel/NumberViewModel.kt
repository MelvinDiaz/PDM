package com.example.scorewithviewmodel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.scorewithviewmodel.model.NumberModelA
import com.example.scorewithviewmodel.model.NumberModelB
import com.example.scorewithviewmodel.model.NumberProvider

class NumberViewModel (): ViewModel(){
    var numA = 0
    var numB = 0
    val numberModelA = MutableLiveData<NumberModelA>()
    val numberModelB = MutableLiveData<NumberModelB>()

    fun addNumberA() {
        val currentNumberA = NumberProvider.addNumberA(numA)
        numberModelA.postValue(currentNumberA)
        numA = currentNumberA.numberA
    }

    fun addNumberB() {
        val currentNumberB = NumberProvider.addNumberB(numB)
        numberModelB.postValue(currentNumberB)
        numB = currentNumberB.numberB
    }
}