package com.example.template.domain.usecase

import com.example.template.data.repository.ExampleRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GetExampleNameUseCase
    @Inject
    constructor(
        private val exampleRepository: ExampleRepository,
    ) {
        operator fun invoke() = exampleRepository.getName()
    }
