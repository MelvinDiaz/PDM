package com.diaz.cartrackercompose.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.diaz.cartrackercompose.data.dao.CarDao
import com.diaz.cartrackercompose.data.models.Car

@Database(entities = [Car::class], version = 1)
abstract class CarTrackerDatabase: RoomDatabase(){
    abstract fun carDao(): CarDao

    companion object{
        private var INSTANCE: CarTrackerDatabase? = null

            fun getInstance(application: Application): CarTrackerDatabase =
                INSTANCE ?: synchronized(this){
                    val instance = Room
                        .databaseBuilder(
                            application.applicationContext,
                            CarTrackerDatabase::class.java,
                            "car_database"
                        )
                        .build()
                    INSTANCE = instance
                    instance
                }
    }
}