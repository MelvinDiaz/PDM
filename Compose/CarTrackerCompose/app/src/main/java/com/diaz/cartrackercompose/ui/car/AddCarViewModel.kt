package com.diaz.cartrackercompose.ui.car

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddCarViewModel(): ViewModel() {
    private val _model = MutableLiveData<String>()
    val carModel: LiveData<String> = _model

    private val _year = MutableLiveData<Int>()
    val year: LiveData<Int> = _year

    private val _plate = MutableLiveData<String>()
    val plate: LiveData<String> = _plate

    private val _addEnable = MutableLiveData<Boolean>()
    val addEnable: LiveData<Boolean> = _addEnable


    fun onAddChange(carModel: String, plate: String, year: Int){
        _model.value = carModel
        _year.value = year
        _plate.value = plate

        _addEnable.value = isValidModel(carModel)&&isValidYear(year)&&isValidPlate(plate)
    }

    private fun isValidYear(year: Int):Boolean = year.toString().isNotEmpty()
    private fun isValidModel(carModel: String):Boolean = carModel.isNotEmpty()
    private fun isValidPlate(plate: String):Boolean = plate.isNotEmpty()
}