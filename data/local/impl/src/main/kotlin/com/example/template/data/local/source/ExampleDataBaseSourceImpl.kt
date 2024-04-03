package com.example.template.data.local.source

import com.example.template.data.local.dao.ExampleDao
import com.example.template.data.local.entity.ExampleEntity
import javax.inject.Inject

class ExampleDataBaseSourceImpl
    @Inject
    constructor(
        private val exampleDao: ExampleDao,
    ) : ExampleDataBaseSource {
        override suspend fun getAll(): List<ExampleEntity> = exampleDao.getAll()

        override suspend fun insert(example: ExampleEntity) {
            exampleDao.insert(example)
        }

        override suspend fun update(example: ExampleEntity) {
            exampleDao.update(example)
        }

        override suspend fun delete(example: ExampleEntity) {
            exampleDao.delete(example)
        }
    }
