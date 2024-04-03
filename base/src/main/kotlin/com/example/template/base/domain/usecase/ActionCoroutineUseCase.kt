package com.example.template.base.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

abstract class ActionCoroutineUseCase<R>(
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Default,
) {
    private val tag = this::class.java.simpleName

    suspend operator fun invoke(): Result<R> =
        try {
            withContext(coroutineDispatcher) {
                Timber.tag(tag).i("START")
                execute().let {
                    Timber.tag(tag).i("END-Success\n$it")
                    Result.success(it)
                }
            }
        } catch (e: Throwable) {
            Timber.tag(tag).w("END-Failure\n$e")
            Result.failure(e)
        }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(): R
}
