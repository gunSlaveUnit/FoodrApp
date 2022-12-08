package com.github.gunslaveunit.foodrapp.data.models

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="dishes")
data class Dish (
    @PrimaryKey(autoGenerate=true)
    val id: Int,
    val title: String,
    val description: String,
    val calories: Int,
    val portion: Int,
    val composition: String,
    val price: Int,
    val photo: Bitmap
)