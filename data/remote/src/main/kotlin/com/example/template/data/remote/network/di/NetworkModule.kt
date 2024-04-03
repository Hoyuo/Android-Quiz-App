package com.example.template.data.remote.network.di

import com.example.template.base.data.remote.adapter.ResultCallAdapter
import com.example.template.data.remote.network.interceptor.AuthInterceptor
import com.example.template.data.remote.network.interceptor.HeaderInterceptor
import com.example.template.data.remote.network.interceptor.LoggingInterceptor
import com.example.template.data.remote.network.policy.BaseUrl
import com.example.template.data.remote.network.policy.ConnectTimeout
import com.example.template.data.remote.network.policy.ReadTimeout
import com.example.template.data.remote.network.policy.RetryCount
import com.example.template.data.remote.network.policy.ServicePolicy
import com.example.template.data.remote.network.policy.WriteTimeout
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @WriteTimeout
    @Provides
    fun provideWriteTimeout(
        servicePolicy: ServicePolicy,
    ): Long = servicePolicy.writeTimeout

    @ReadTimeout
    @Provides
    fun provideReadTimeout(
        servicePolicy: ServicePolicy,
    ): Long = servicePolicy.readTimeout

    @ConnectTimeout
    @Provides
    fun provideConnectTimeout(
        servicePolicy: ServicePolicy,
    ): Long = servicePolicy.connectTimeout

    @RetryCount
    @Provides
    fun provideRetryCount(
        servicePolicy: ServicePolicy,
    ): Int = servicePolicy.retryCount

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @WriteTimeout writeTimeout: Long,
        @ReadTimeout readTimeout: Long,
        @ConnectTimeout connectTimeout: Long,
        @LoggingInterceptor loggingInterceptor: Interceptor,
        @HeaderInterceptor headerInterceptor: Interceptor,
        @AuthInterceptor authInterceptor: Interceptor,
    ): OkHttpClient =
        OkHttpClient
            .Builder()
            .writeTimeout(writeTimeout, TimeUnit.SECONDS)
            .readTimeout(readTimeout, TimeUnit.SECONDS)
            .connectTimeout(connectTimeout, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(headerInterceptor)
            .addInterceptor(authInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        @BaseUrl baseUrl: String,
        @RetryCount retryCount: Int,
        okHttpClient: OkHttpClient,
    ): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .addCallAdapterFactory(ResultCallAdapter.Factory(retryCount))
            .build()
    }
}
