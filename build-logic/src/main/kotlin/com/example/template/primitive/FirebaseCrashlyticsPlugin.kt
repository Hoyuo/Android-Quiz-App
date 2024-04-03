package com.example.template.primitive

import com.example.template.ktx.androidLibrary
import com.example.template.ktx.implementation
import com.example.template.ktx.library
import com.example.template.ktx.libs
import com.example.template.ktx.plugin
import com.google.firebase.crashlytics.buildtools.gradle.CrashlyticsExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class FirebaseCrashlyticsPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugin("firebase-crashlytics").pluginId)
            }

            androidLibrary {
                buildTypes {
                    getByName("release") {
                        configure<CrashlyticsExtension> {
                            nativeSymbolUploadEnabled = true
                        }
                    }
                }
            }

            dependencies {
                implementation(platform(libs.library("firebase-bom")))
                implementation(libs.library("firebase-crashlytics"))
            }
        }
    }
}
