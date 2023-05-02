package com.diaz.cartrackercompose.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.diaz.cartrackercompose.data.models.Car

@Dao
interface CarDao {

    @Insert
    fun insertCar(car: Car)

    @Insert
    fun insertAllCar(cars: List<Car>)

    @Delete
    fun deleteCar(car: Car)

    @Update
    fun updateCar(car:Car)

    @Query("SELECT * FROM car_table")
    fun getCars(): List<Car>

    @Query("SELECT * FROM car_table WHERE plate = :plate")
    fun getCarByPlate(plate: String): LiveData<Car>
}