package com.example.template.data.remote.source

import com.example.template.data.remote.service.ExampleService
import javax.inject.Inject

class ExampleRemoteSourceImpl
    @Inject
    constructor(
        private val exampleService: ExampleService,
    ) : ExampleRemoteSource {
        override suspend fun getExample(): String = exampleService.getExample()

        override suspend fun postExample(): String = exampleService.postExample()
    }
