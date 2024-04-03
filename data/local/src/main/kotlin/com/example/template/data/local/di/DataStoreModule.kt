package com.example.template.data.local.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.Serializer
import androidx.datastore.dataStoreFile
import com.example.template.data.local.proto.Example
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
    @Provides
    @Singleton
    fun provideExampleSerializer(): Serializer<Example> =
        object : Serializer<Example> {
            override val defaultValue: Example
                get() = Example.getDefaultInstance()

            override suspend fun readFrom(input: InputStream): Example = Example.parseFrom(input)

            override suspend fun writeTo(
                t: Example,
                output: OutputStream,
            ) {
                t.writeTo(output)
            }
        }

    @Provides
    @Singleton
    fun provideDataStore(
        @ApplicationContext context: Context,
    ): DataStore<Example> =
        DataStoreFactory.create(
            serializer = provideExampleSerializer(),
            produceFile = { context.dataStoreFile("example.pb") },
        )
}
