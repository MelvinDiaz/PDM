package com.diaz.cartrackercompose.ui.car

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.diaz.cartrackercompose.CarTrackerApplication
import com.diaz.cartrackercompose.repositories.CarRepository

class CarViewModel(private val repository: CarRepository): ViewModel() {
    fun getCars() = repository.getCars()

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as CarTrackerApplication
                CarViewModel(app.carRepository)
            }
        }
    }
}