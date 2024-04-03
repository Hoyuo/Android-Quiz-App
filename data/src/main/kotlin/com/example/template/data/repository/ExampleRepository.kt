package com.example.template.data.repository

import kotlinx.coroutines.flow.Flow

interface ExampleRepository {
    fun getName(): Flow<String>
}
