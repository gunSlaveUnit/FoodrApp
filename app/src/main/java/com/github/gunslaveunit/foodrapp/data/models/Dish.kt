package com.github.gunslaveunit.foodrapp.data.models

import android.graphics.Bitmap
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName="dishes")
@Parcelize
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
): Parcelable