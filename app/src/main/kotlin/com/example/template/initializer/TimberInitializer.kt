package com.example.template.initializer

import android.content.Context
import androidx.startup.Initializer
import com.example.template.initializer.di.InitializerEntryPoint
import javax.inject.Inject
import timber.log.Timber

class TimberInitializer : Initializer<Timber.Tree> {
    @Inject
    lateinit var timberTree: Timber.Tree

    override fun create(context: Context): Timber.Tree {
        // injecting dependencies from Hilt
        InitializerEntryPoint.resolve(context).inject(this)

        Timber.plant(timberTree)
        Timber.d("TimberInitializer is initialized.")

        return timberTree
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return listOf(DependencyGraphInitializer::class.java)
    }
}
