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
    suspend fun insertCar(car: Car)

    @Insert
    suspend fun insertAllCar(cars: List<Car>)

    @Delete
    suspend fun deleteCar(car: Car)

    @Update
    suspend fun updateCar(car:Car)

    @Query("SELECT * FROM car_table")
    suspend fun getCars(): List<Car>

    //@Query("SELECT * FROM car_table WHERE plate = :plate")
    //suspend fun getCarByPlate(plate: String): LiveData<Car>
}