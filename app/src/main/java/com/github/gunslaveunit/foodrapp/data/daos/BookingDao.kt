package com.github.gunslaveunit.foodrapp.data.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.github.gunslaveunit.foodrapp.data.models.Booking

@Dao
interface BookingDao {
    @Query("SELECT * FROM bookings")
    fun all(): LiveData<List<Booking>>

    @Insert()
    suspend fun add(booking: Booking)
}