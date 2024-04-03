package com.example.template.internal

import com.android.build.api.dsl.BuildType
import java.io.File

fun BuildType.proguardPath(path: String) {
    val files =
        File(path)
            .listFiles()
            ?.filter { it.extension == "pro" }
            ?.onEach { println("[proguard] ${it.name}") }
            ?.map { file -> file.absolutePath }
            ?.toTypedArray()
            ?: return
    proguardFiles(*files)
}
