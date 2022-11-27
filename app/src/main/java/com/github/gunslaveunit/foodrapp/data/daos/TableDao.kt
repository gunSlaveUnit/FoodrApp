package com.github.gunslaveunit.foodrapp.data.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.github.gunslaveunit.foodrapp.data.models.Table

@Dao
interface TableDao {
    @Query("SELECT * FROM tables")
    fun all(): LiveData<List<Table>>

    @Insert()
    suspend fun add(doctor: Table)
}