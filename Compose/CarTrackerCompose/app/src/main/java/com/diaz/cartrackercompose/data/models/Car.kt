package com.diaz.cartrackercompose.data.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "car_table")
data class Car(
    val model: String,
    val year: Int,
    val plate: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L

    @Ignore
    var brand: Brand? = null

}