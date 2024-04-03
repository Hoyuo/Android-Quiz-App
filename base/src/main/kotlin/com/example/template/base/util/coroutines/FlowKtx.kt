package com.example.template.base.util.coroutines

import kotlinx.coroutines.flow.flow

fun <T> (suspend () -> T).toFlow() =
    flow {
        emit(invoke())
    }

fun <T> (() -> T).toFlow() =
    flow {
        emit(invoke())
    }
