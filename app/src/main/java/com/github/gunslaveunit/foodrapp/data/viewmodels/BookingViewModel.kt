package com.github.gunslaveunit.foodrapp.data.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.github.gunslaveunit.foodrapp.data.database.FoodrAppDB
import com.github.gunslaveunit.foodrapp.data.models.Booking
import com.github.gunslaveunit.foodrapp.data.repositories.BookingRepository
import com.github.gunslaveunit.foodrapp.utils.services.BookingService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookingViewModel(application: Application): AndroidViewModel(application) {
    private val bookingRepository: BookingRepository
    private val all: LiveData<List<Booking>>
    private val bookingService: BookingService

    init {
        val bookingDao = FoodrAppDB.getDatabase(application).bookingDao()
        bookingRepository = BookingRepository(bookingDao)
        all = bookingRepository.all
        bookingService = BookingService(bookingRepository)
    }

    fun all(): LiveData<List<Booking>> {
        return all
    }

    fun make(booking: Booking) {
        viewModelScope.launch(Dispatchers.IO) {
            bookingService.make(booking)
        }
    }

    fun add(booking: Booking) {
        viewModelScope.launch(Dispatchers.IO) {
            bookingRepository.add(booking)
        }
    }
}