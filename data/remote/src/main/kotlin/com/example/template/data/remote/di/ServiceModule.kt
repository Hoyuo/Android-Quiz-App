package com.example.template.data.remote.di

import com.example.template.data.remote.service.ExampleService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun provideExampleService(
        retrofit: Retrofit,
    ): ExampleService = retrofit.create(ExampleService::class.java)
}
