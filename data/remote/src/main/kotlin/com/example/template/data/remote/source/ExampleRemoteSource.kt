package com.example.template.data.remote.source

/**
 * This is file template
 * Do not used in production yet
 */

interface ExampleRemoteSource {
    suspend fun getExample(): String

    suspend fun postExample(): String
}
