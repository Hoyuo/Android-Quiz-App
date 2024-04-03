package com.example.template.initializer

import android.content.Context
import androidx.startup.Initializer
import com.example.template.initializer.di.InitializerEntryPoint

class DependencyGraphInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        InitializerEntryPoint.resolve(context)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}
