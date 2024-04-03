package com.example.template.base.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import timber.log.Timber

abstract class FlowResultUseCase<in P, R>(
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Default,
) {
    private val tag = this::class.java.simpleName

    operator fun invoke(parameters: P): Flow<Result<R>> =
        execute(parameters)
            .onStart { Timber.tag(tag).i("START\n$parameters") }
            .distinctUntilChanged()
            .onEach { Timber.tag(tag).i("END-Success\n$it") }
            .catch { e ->
                Timber.tag(tag).w("END-Failure\n$e")
                emit(Result.failure(e))
            }.flowOn(coroutineDispatcher)

    protected abstract fun execute(parameters: P): Flow<Result<R>>
}
