package com.diaz.cartrackercompose

import android.app.Application
import com.diaz.cartrackercompose.data.CarTrackerDatabase
import com.diaz.cartrackercompose.repositories.CarRepository

class CarTrackerApplication: Application() {

    private val db: CarTrackerDatabase by lazy {
        CarTrackerDatabase.getInstance(this)
    }
    val carRepository: CarRepository by lazy {
        CarRepository(db.carDao())
    }
}