package com.example.template.data.repository

import com.example.template.data.local.source.ExampleDataBaseSource
import com.example.template.data.remote.source.ExampleRemoteSource
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ExampleRepositoryImpl
    @Inject
    constructor(
        private val exampleRemoteSource: ExampleRemoteSource,
        private val exampleDataBaseSource: ExampleDataBaseSource,
//     private val exampleDataStoreSource: ExampleDataStoreSource,
    ) : ExampleRepository {
        override fun getName(): Flow<String> =
            flow {
                // emit(exampleRemoteSource.getExample())

                // emit(exampleDatabaseSource.getAll().first().name)
                emit("hello world")
            }
    }
