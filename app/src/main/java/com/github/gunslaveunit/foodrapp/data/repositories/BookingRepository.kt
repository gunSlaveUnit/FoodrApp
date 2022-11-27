package com.github.gunslaveunit.foodrapp.data.repositories

import androidx.lifecycle.LiveData
import com.github.gunslaveunit.foodrapp.data.daos.BookingDao
import com.github.gunslaveunit.foodrapp.data.models.Booking

class BookingRepository(private val bookingDao: BookingDao) {
    val all: LiveData<List<Booking>> = bookingDao.all()

    suspend fun add(booking: Booking) {
        bookingDao.add(booking)
    }
}