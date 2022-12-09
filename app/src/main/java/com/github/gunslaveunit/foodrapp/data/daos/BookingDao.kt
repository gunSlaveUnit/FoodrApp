package com.github.gunslaveunit.foodrapp.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.github.gunslaveunit.foodrapp.data.models.Booking

@Dao
interface BookingDao {
    @Query("SELECT * FROM bookings")
    fun all(): List<Booking>

    @Insert
    fun add(booking: Booking)

    @Delete
    fun delete(booking: Booking)
}