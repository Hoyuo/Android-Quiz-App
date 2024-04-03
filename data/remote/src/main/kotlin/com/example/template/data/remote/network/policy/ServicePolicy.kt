package com.example.template.data.remote.network.policy

data class ServicePolicy(
    val writeTimeout: Long,
    val readTimeout: Long,
    val connectTimeout: Long,
    val retryCount: Int,
)
