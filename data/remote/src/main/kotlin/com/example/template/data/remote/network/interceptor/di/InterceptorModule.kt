package com.example.template.data.remote.network.interceptor.di

import com.example.template.data.remote.network.interceptor.AuthInterceptor
import com.example.template.data.remote.network.interceptor.HeaderInterceptor
import com.example.template.data.remote.network.interceptor.LoggingInterceptor
import com.example.template.data.remote.network.policy.AccessToken
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

@Module
@InstallIn(SingletonComponent::class)
object InterceptorModule {
    @LoggingInterceptor
    @Provides
    fun provideLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @HeaderInterceptor
    @Provides
    fun provideHeaderInterceptor(): Interceptor =
        Interceptor { chain ->
            val request =
                chain
                    .request()
                    .newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("User-Agent", System.getProperty("http.agent")!!)
                    .build()
            chain.proceed(request)
        }

    @AuthInterceptor
    @Provides
    fun provideAuthInterceptor(
        @AccessToken accessToken: String,
    ): Interceptor =
        Interceptor { chain ->
            val request =
                chain
                    .request()
                    .newBuilder()
                    .addHeader("Authorization", "Bearer $accessToken")
                    .build()
            chain.proceed(request)
        }
}
