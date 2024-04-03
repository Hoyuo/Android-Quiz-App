package com.example.template.data.local.di

import com.example.template.data.local.source.ExampleDataBaseSource
import com.example.template.data.local.source.ExampleDataBaseSourceImpl
import com.example.template.data.local.source.ExampleDataStoreSource
import com.example.template.data.local.source.ExampleDataStoreSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalSourceModule {
    @Binds
    abstract fun bindExampleDataBaseSource(
        exampleDataBaseSourceImpl: ExampleDataBaseSourceImpl,
    ): ExampleDataBaseSource

    @Binds
    abstract fun bindExampleDataStoreSource(
        exampleDataStoreSourceImpl: ExampleDataStoreSourceImpl,
    ): ExampleDataStoreSource
}
