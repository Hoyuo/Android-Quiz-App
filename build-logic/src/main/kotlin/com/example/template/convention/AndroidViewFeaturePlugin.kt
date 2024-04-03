package com.example.template.convention

import com.example.template.ktx.implementation
import com.example.template.ktx.library
import com.example.template.ktx.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidViewFeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.example.template.primitive.android.library")
                apply("com.example.template.primitive.android.kotlin")
                apply("com.example.template.primitive.android.kotlin.ksp")
                apply("com.example.template.primitive.android.view")
                apply("com.example.template.primitive.android.navigation")
                apply("com.example.template.primitive.android.hilt")
            }

            dependencies {
                implementation(libs.library("timber"))
            }
        }
    }
}
