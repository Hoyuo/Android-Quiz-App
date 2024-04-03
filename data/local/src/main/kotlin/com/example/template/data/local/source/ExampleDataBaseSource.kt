package com.example.template.data.local.source

import com.example.template.data.local.entity.ExampleEntity

interface ExampleDataBaseSource {
    suspend fun getAll(): List<ExampleEntity>

    suspend fun insert(example: ExampleEntity)

    suspend fun update(example: ExampleEntity)

    suspend fun delete(example: ExampleEntity)
}
