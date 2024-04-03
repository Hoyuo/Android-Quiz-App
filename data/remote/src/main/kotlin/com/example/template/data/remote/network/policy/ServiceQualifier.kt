package com.example.template.data.remote.network.policy

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class BaseUrl

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class AccessToken

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class RefreshToken

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class WriteTimeout

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ReadTimeout

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ConnectTimeout

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class RetryCount
