package com.example.template.data.local.source

import com.example.template.data.local.proto.Example
import kotlinx.coroutines.flow.Flow

interface ExampleDataStoreSource {
    fun getExample(): Flow<Example>

    fun getId(): Flow<Int>

    fun getName(): Flow<String>

    suspend fun setExample(example: Example)

    suspend fun setName(name: String)
}
