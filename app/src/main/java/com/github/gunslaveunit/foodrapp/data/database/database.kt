package com.github.gunslaveunit.foodrapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.github.gunslaveunit.foodrapp.data.daos.BookingDao
import com.github.gunslaveunit.foodrapp.data.daos.TableDao
import com.github.gunslaveunit.foodrapp.data.models.Booking
import com.github.gunslaveunit.foodrapp.data.models.Table
import com.github.gunslaveunit.foodrapp.utils.converters.BitmapConverter
import com.github.gunslaveunit.foodrapp.utils.converters.DateConverter

@Database(entities = [Table::class, Booking::class], version = 1, exportSchema = false)
@TypeConverters(value = [BitmapConverter::class, DateConverter::class])
abstract class FoodrAppDB : RoomDatabase() {
    abstract fun tableDao(): TableDao
    abstract fun bookingDao(): BookingDao

    companion object {
        @Volatile
        private var INSTANCE: FoodrAppDB? = null

        fun getDatabase(context: Context): FoodrAppDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room
                    .databaseBuilder(
                        context.applicationContext,
                        FoodrAppDB::class.java,
                        "foodrappdb"
                    )
                    .build()

                INSTANCE = instance

                instance
            }
        }
    }
}