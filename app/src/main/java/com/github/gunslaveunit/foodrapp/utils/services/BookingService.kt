package com.github.gunslaveunit.foodrapp.utils.services

import com.github.gunslaveunit.foodrapp.data.models.Booking
import com.github.gunslaveunit.foodrapp.data.repositories.BookingRepository

class BookingService(bookingRepository: BookingRepository) {
    private lateinit var bookingRepository: BookingRepository

    init {
        this.bookingRepository = bookingRepository
    }

    suspend fun make(booking: Booking) {
        bookingRepository.add(booking)
    }
}