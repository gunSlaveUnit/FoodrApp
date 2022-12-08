package com.github.gunslaveunit.foodrapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName="bookings")
data class Booking (
    @PrimaryKey(autoGenerate=true)
    val id: Int,
    val tableId: Int,
    val guestName: String,
    val contactPhone: String,
    val startTime: Date,
    val endTime: Date
)