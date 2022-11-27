package com.github.gunslaveunit.foodrapp.data.repositories

import androidx.lifecycle.LiveData
import com.github.gunslaveunit.foodrapp.data.daos.TableDao
import com.github.gunslaveunit.foodrapp.data.models.Table

class TableRepository(private val tableDao: TableDao) {
    val all: LiveData<List<Table>> = tableDao.all()

    suspend fun add(doctor: Table) {
        tableDao.add(doctor)
    }
}