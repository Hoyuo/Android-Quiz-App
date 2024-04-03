package com.example.template.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.template.data.local.entity.ExampleEntity

@Dao
interface ExampleDao {
    @Insert
    suspend fun insert(example: ExampleEntity)

    @Update
    suspend fun update(example: ExampleEntity)

    @Delete
    suspend fun delete(example: ExampleEntity)

    @Query("SELECT * FROM example")
    suspend fun getAll(): List<ExampleEntity>
}
