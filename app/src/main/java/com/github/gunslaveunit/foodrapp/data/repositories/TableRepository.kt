package com.github.gunslaveunit.foodrapp.data.repositories

import androidx.lifecycle.LiveData
import com.github.gunslaveunit.foodrapp.data.daos.TableDao
import com.github.gunslaveunit.foodrapp.data.models.Table

class TableRepository(private val tableDao: TableDao) {
    val getAll: LiveData<List<Table>> = tableDao.getAll()

    suspend fun add(doctor: Table) {
        tableDao.add(doctor)
    }
}