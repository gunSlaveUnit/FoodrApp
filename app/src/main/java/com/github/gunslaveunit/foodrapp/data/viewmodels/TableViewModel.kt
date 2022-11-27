package com.github.gunslaveunit.foodrapp.data.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.github.gunslaveunit.foodrapp.data.database.FoodrAppDB
import com.github.gunslaveunit.foodrapp.data.models.Table
import com.github.gunslaveunit.foodrapp.data.repositories.TableRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TableViewModel(application: Application): AndroidViewModel(application) {
    private val tableRepository: TableRepository
    val getAll: LiveData<List<Table>>

    init {
        val tableDao = FoodrAppDB.getDatabase(application).tableDao()
        tableRepository = TableRepository(tableDao)
        getAll = tableRepository.getAll
    }

    fun add(table: Table) {
        viewModelScope.launch(Dispatchers.IO) {
            tableRepository.add(table)
        }
    }
}