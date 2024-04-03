package com.example.template.data.local.source

import androidx.datastore.core.DataStore
import com.example.template.data.local.proto.Example
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ExampleDataStoreSourceImpl
    @Inject
    constructor(
        private val dataStore: DataStore<Example>,
    ) : ExampleDataStoreSource {
        override fun getExample(): Flow<Example> = dataStore.data

        override fun getId(): Flow<Int> = dataStore.data.map { it.id }

        override fun getName(): Flow<String> = dataStore.data.map { it.name }

        override suspend fun setExample(example: Example) {
            dataStore.updateData {
                it
                    .toBuilder()
                    .setId(example.id)
                    .setName(example.name)
                    .build()
            }
        }

        override suspend fun setName(name: String) {
            dataStore.updateData {
                it
                    .toBuilder()
                    .setName(name)
                    .build()
            }
        }
    }
