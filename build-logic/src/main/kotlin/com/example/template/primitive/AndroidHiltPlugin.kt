package com.example.template.primitive

import com.example.template.ktx.android
import com.example.template.ktx.hilt
import com.example.template.ktx.implementation
import com.example.template.ktx.kapt
import com.example.template.ktx.library
import com.example.template.ktx.libs
import com.example.template.ktx.plugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugin("hilt").pluginId)
                apply(libs.plugin("kotlin-kapt").pluginId)
            }

            android {
                packagingOptions {
                    resources {
                        excludes += "META-INF/gradle/incremental.annotation.processors"
                    }
                }
            }

            dependencies {
                implementation(libs.library("hilt"))
                kapt(libs.library("hilt-compiler"))
            }

            kapt {
                correctErrorTypes = true
            }

            hilt {
                enableAggregatingTask = true
            }
        }
    }
}
