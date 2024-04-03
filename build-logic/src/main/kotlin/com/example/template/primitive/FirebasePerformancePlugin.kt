package com.example.template.primitive

import com.example.template.ktx.implementation
import com.example.template.ktx.library
import com.example.template.ktx.libs
import com.example.template.ktx.plugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class FirebasePerformancePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugin("firebase-perf").pluginId)
            }

            dependencies {
                implementation(platform(libs.library("firebase-bom")))
                implementation(libs.library("firebase-perf"))
            }
        }
    }
}
