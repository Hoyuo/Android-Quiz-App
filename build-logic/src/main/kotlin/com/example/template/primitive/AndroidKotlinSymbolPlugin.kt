package com.example.template.primitive

import com.example.template.ktx.implementation
import com.example.template.ktx.library
import com.example.template.ktx.libs
import com.example.template.ktx.plugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidKotlinSymbolPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugin("kotlin-ksp").pluginId)
            }

            dependencies {
                implementation(libs.library("kotlinx-ksp"))
            }
        }
    }
}
