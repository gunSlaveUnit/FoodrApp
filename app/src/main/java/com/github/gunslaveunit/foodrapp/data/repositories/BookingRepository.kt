package com.github.gunslaveunit.foodrapp.data.repositories

import com.github.gunslaveunit.foodrapp.data.daos.BookingDao
import com.github.gunslaveunit.foodrapp.data.models.Booking

class BookingRepository(private val bookingDao: BookingDao) {
    val all: List<Booking> = bookingDao.all()

    fun add(booking: Booking) {
        bookingDao.add(booking)
    }

    fun delete(booking: Booking) {
        bookingDao.delete(booking)
    }
}