package com.github.gunslaveunit.foodrapp.utils.services

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import com.github.gunslaveunit.foodrapp.data.models.Booking
import com.github.gunslaveunit.foodrapp.data.repositories.BookingRepository
import java.text.SimpleDateFormat

class BookingService(bookingRepository: BookingRepository) {
    private lateinit var bookingRepository: BookingRepository

    init {
        this.bookingRepository = bookingRepository
    }

    @SuppressLint("SimpleDateFormat")
    fun make(booking: Booking) {
        val formatter = SimpleDateFormat("dd.MM.yyyy HH:mm")
        val startDate = formatter.parse(booking.startTime)
        val endDate = formatter.parse(booking.endTime)

        val bookings = bookingRepository.all
        var isFree = true
        for (existingBooking in bookings) {
            val startExistingDate = formatter.parse(existingBooking.startTime)
            val endExistingDate = formatter.parse(existingBooking.endTime)

            Log.d("startExistingDate", startExistingDate.toString())
            Log.d("endExistingDate", endExistingDate.toString())

            if (existingBooking.tableId == booking.tableId
                && ((startExistingDate < startDate && startDate < endExistingDate)
                || (startExistingDate < endDate && endDate < endExistingDate))) {
                isFree = false
                break
            }
        }

        if (isFree)
            bookingRepository.add(booking)
    }
}