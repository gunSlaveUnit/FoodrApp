package com.github.gunslaveunit.foodrapp.data.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.github.gunslaveunit.foodrapp.data.database.FoodrAppDB
import com.github.gunslaveunit.foodrapp.data.models.Dish
import com.github.gunslaveunit.foodrapp.data.repositories.DishRepository

class DishViewModel(application: Application): AndroidViewModel(application) {
    private val dishRepository: DishRepository
    private val all: List<Dish>

    init {
        val dishDao = FoodrAppDB.getDatabase(application).dishDao()
        dishRepository = DishRepository(dishDao)
        all = dishRepository.all
    }

    fun all(): List<Dish> {
        return all
    }

    fun add(dish: Dish) {
        dishRepository.add(dish)
    }
}