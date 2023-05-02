package com.diaz.cartrackercompose.repositories

import com.diaz.cartrackercompose.data.dao.CarDao

class CarRepository (private val carDao: CarDao) {
    fun getCars() = carDao.getCars()

    fun getCarByPlate(plate: String) = carDao.getCarByPlate(plate)
}