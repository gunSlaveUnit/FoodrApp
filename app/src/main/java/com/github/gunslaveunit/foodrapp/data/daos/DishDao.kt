package com.github.gunslaveunit.foodrapp.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.github.gunslaveunit.foodrapp.data.models.Dish

@Dao
interface DishDao {
    @Query("SELECT * FROM dishes")
    fun all(): List<Dish>

    @Insert
    fun add(dish: Dish)

    @Delete
    fun delete(dish: Dish)
}