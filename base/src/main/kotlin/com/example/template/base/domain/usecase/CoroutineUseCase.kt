package com.example.template.base.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * Origin Source : https://github.com/google/iosched/blob/main/shared/src/main/java/com/google/samples/apps/iosched/shared/domain/CoroutineUseCase.kt
 *
 * Executes business logic synchronously or asynchronously using Coroutines.
 */
abstract class CoroutineUseCase<in P, R>(
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Default,
) {
    private val tag = this::class.java.simpleName

    suspend operator fun invoke(parameters: P): Result<R> =
        try {
            withContext(coroutineDispatcher) {
                Timber.tag(tag).i("START\n$parameters")
                execute(parameters).let {
                    Timber.tag(tag).i("END-Success\n$it")
                    Result.success(it)
                }
            }
        } catch (e: Throwable) {
            Timber.tag(tag).w("END-Failure\n$e")
            Result.failure(e)
        }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): R
}
