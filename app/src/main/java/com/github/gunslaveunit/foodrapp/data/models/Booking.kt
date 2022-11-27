package com.github.gunslaveunit.foodrapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName="bookings")
data class Booking (
    @PrimaryKey(autoGenerate=true)
    val id: Int,
    val table: Int,
    val guestName: String,
    val contactPhone: String,
    val startTime: Date,
    val endTime: Date
)