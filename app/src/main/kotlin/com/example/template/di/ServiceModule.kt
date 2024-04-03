package com.example.template.di

import android.content.Context
import com.example.template.R
import com.example.template.data.remote.network.policy.AccessToken
import com.example.template.data.remote.network.policy.BaseUrl
import com.example.template.data.remote.network.policy.RefreshToken
import com.example.template.data.remote.network.policy.ServicePolicy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @BaseUrl
    @Provides
    fun provideBaseUrl(
        @ApplicationContext context: Context,
    ): String = context.getString(R.string.server_url)

    @AccessToken
    @Provides
    fun provideAccessToken(
        @ApplicationContext context: Context,
    ): String = context.getString(R.string.access_token)

    @RefreshToken
    @Provides
    fun provideRefreshToken(
        @ApplicationContext context: Context,
    ): String = context.getString(R.string.refresh_token)

    @Provides
    fun provideNetworkService(
        @ApplicationContext context: Context,
    ): ServicePolicy =
        ServicePolicy(
            writeTimeout = context.resources.getInteger(R.integer.write_timeout).toLong(),
            readTimeout = context.resources.getInteger(R.integer.read_timeout).toLong(),
            connectTimeout = context.resources.getInteger(R.integer.connect_timeout).toLong(),
            retryCount = context.resources.getInteger(R.integer.retry_count),
        )
}
