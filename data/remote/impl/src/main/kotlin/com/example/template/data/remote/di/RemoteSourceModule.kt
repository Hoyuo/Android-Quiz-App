package com.example.template.data.remote.di

import com.example.template.data.remote.source.ExampleRemoteSource
import com.example.template.data.remote.source.ExampleRemoteSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteSourceModule {
    @Binds
    @Singleton
    abstract fun bindExampleRemoteSource(remoteSourceImpl: ExampleRemoteSourceImpl): ExampleRemoteSource
}
