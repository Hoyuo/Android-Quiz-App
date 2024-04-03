package com.example.template.base.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.template.base.ui.effect.BaseEffect
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

abstract class BaseViewModel<E : BaseEffect> : ViewModel() {
    private val _effect: MutableStateFlow<E?> = MutableStateFlow(null)
    val effect = _effect.asStateFlow()

    protected fun sendEffect(event: E) {
        _effect.value = event
    }

    fun clearEffect() {
        _effect.value = null
    }

    protected fun <T> Flow<T>.stateIn(initialValue: T): StateFlow<T> =
        this.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(0),
            initialValue = initialValue,
        )

    protected fun <T> Flow<T>.launchIn(): Job =
        viewModelScope.launch {
            collect() // tail-call
        }
}
