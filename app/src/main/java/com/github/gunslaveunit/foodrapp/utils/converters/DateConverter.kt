package com.github.gunslaveunit.foodrapp.utils.converters

import android.annotation.SuppressLint
import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class DateConverter {
    @SuppressLint("SimpleDateFormat")
    private val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    @TypeConverter
    fun from(date: String): Date? {
        return formatter.parse(date)
    }

    @TypeConverter
    fun to(date: Date): String {
        return date.toString()
    }
}