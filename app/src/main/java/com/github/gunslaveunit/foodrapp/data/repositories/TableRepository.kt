package com.github.gunslaveunit.foodrapp.data.repositories

import com.github.gunslaveunit.foodrapp.data.daos.TableDao
import com.github.gunslaveunit.foodrapp.data.models.Table

class TableRepository(private val tableDao: TableDao) {
    val all: List<Table> = tableDao.all()

    fun add(doctor: Table) {
        tableDao.add(doctor)
    }
}