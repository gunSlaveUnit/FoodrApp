package com.github.gunslaveunit.foodrapp.data.models

import android.graphics.Bitmap
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName="tables")
@Parcelize
data class Table(
    @PrimaryKey(autoGenerate=true)
    val id: Int,
    val number: Int,
    val description: String,
    val capacity: Int,
    val image: Bitmap
): Parcelable