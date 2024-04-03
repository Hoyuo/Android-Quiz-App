package com.example.template.primitive

import com.example.template.ktx.androidLibrary
import com.example.template.ktx.bundle
import com.example.template.ktx.implementation
import com.example.template.ktx.library
import com.example.template.ktx.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidViewPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            androidLibrary {
                buildFeatures {
                    viewBinding = true
                    dataBinding = true
                }
            }

            dependencies {
                implementation(libs.library("androidx-appcompat"))
                implementation(libs.library("androidx-activity"))
                implementation(libs.library("androidx-fragment"))
                implementation(libs.library("androidx-recyclerview"))
                implementation(libs.library("androidx-constraintlayout"))

                implementation(libs.library("google-material"))

                implementation(libs.bundle("lifecycle"))
            }
        }
    }
}
