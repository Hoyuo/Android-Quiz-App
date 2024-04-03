package com.example.template.data.remote.service

import retrofit2.http.GET
import retrofit2.http.POST

interface ExampleService {
    @GET("/example")
    suspend fun getExample(): String

    @POST("/example")
    suspend fun postExample(): String
}
