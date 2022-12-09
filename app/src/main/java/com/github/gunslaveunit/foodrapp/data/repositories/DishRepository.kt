package com.github.gunslaveunit.foodrapp.data.repositories

import com.github.gunslaveunit.foodrapp.data.daos.DishDao
import com.github.gunslaveunit.foodrapp.data.models.Dish

class DishRepository(private val dishDao: DishDao) {
    val all: List<Dish> = dishDao.all()

    fun add(dish: Dish) {
        dishDao.add(dish)
    }

    fun delete(dish: Dish) {
        dishDao.delete(dish)
    }
}