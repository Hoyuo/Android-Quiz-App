package com.example.template.primitive

import com.example.template.ktx.android
import com.example.template.ktx.androidTestImplementation
import com.example.template.ktx.androidTestRuntimeOnly
import com.example.template.ktx.kaptTest
import com.example.template.ktx.library
import com.example.template.ktx.libs
import com.example.template.ktx.testImplementation
import com.example.template.ktx.testRuntimeOnly
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidKotlinUnitTestPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            android {
                testOptions {
                    unitTests.isIncludeAndroidResources = true
                    unitTests.all { test -> test.useJUnitPlatform() }
                }

                packagingOptions {
                    resources.excludes.add("META-INF/AL2.0")
                    resources.excludes.add("META-INF/LGPL2.1")
                    resources.excludes.add("META-INF/LICENSE.md")
                    resources.excludes.add("META-INF/LICENSE-notice.md")
                }
            }

            dependencies {
                // TestLibs
                testImplementation(libs.library("junit5-api"))
                testRuntimeOnly(libs.library("junit5-engine"))

                testImplementation(libs.library("kotlin-test-junit"))
                testImplementation(libs.library("kotlin-reflection"))
                testImplementation(libs.library("kotlinx-coroutines-test"))
                testImplementation(libs.library("turbine"))

                testImplementation(libs.library("androidx-test-core"))
                testImplementation(libs.library("androidx-test-core-ktx"))
                testImplementation(libs.library("androidx-test-junit"))
                testImplementation(libs.library("androidx-test-junit-ktx"))
                testImplementation(libs.library("androidx-test-runner"))
                testImplementation(libs.library("androidx-test-rules"))
                testImplementation(libs.library("androidx-test-monitor"))

                testImplementation(libs.library("truth"))
                testImplementation(libs.library("truth-ext"))

                testImplementation(libs.library("mockk"))
                testImplementation(libs.library("mockk-android"))
                testImplementation(libs.library("mockk-agent"))

                testImplementation(libs.library("hilt-test"))
                kaptTest(libs.library("hilt-compiler"))

                testImplementation(libs.library("okhttp-mockwebserver"))

                // AndroidTestLibs
                androidTestImplementation(libs.library("junit5-api"))
                androidTestRuntimeOnly(libs.library("junit5-engine"))
                androidTestImplementation(libs.library("junit5-android-test"))
                androidTestRuntimeOnly(libs.library("junit5-android-runner"))

                androidTestImplementation(libs.library("kotlin-test-junit"))
                androidTestImplementation(libs.library("kotlin-reflection"))
                androidTestImplementation(libs.library("kotlinx-coroutines-test"))
                androidTestImplementation(libs.library("turbine"))

                androidTestImplementation(libs.library("androidx-test-core"))
                androidTestImplementation(libs.library("androidx-test-core-ktx"))
                androidTestImplementation(libs.library("androidx-test-junit"))
                androidTestImplementation(libs.library("androidx-test-junit-ktx"))
                androidTestImplementation(libs.library("androidx-test-runner"))
                androidTestImplementation(libs.library("androidx-test-rules"))
                androidTestImplementation(libs.library("androidx-test-monitor"))

                androidTestImplementation(libs.library("mockk"))
                androidTestImplementation(libs.library("mockk-android"))
                androidTestImplementation(libs.library("mockk-agent"))

                androidTestImplementation(libs.library("hilt-test"))
            }
        }
    }
}
