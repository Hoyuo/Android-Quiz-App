package com.example.template.ktx

import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.TestedExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.example.template.internal.isArmProcessor
import com.google.protobuf.gradle.ProtobufExtension
import dagger.hilt.android.plugin.HiltExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.exclude
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.gradle.plugin.KaptExtension

fun Project.androidApplication(action: BaseAppModuleExtension.() -> Unit) {
    extensions.configure(action)
}

fun Project.androidLibrary(action: LibraryExtension.() -> Unit) {
    extensions.configure(action)
}

fun Project.android(action: TestedExtension.() -> Unit) {
    extensions.configure(action)
}

fun Project.kapt(action: KaptExtension.() -> Unit) {
    extensions.configure(action)
}

fun Project.hilt(action: HiltExtension.() -> Unit) {
    extensions.configure(action)
}

fun Project.protobuf(action: ProtobufExtension.() -> Unit) {
    extensions.configure(action)
}

fun TestedExtension.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}

fun Project.setupAndroid() {
    android {
        namespace?.let {
            this.namespace = it
        }

        compileSdkVersion(libs.version("compileSdk").toInt())

        defaultConfig {
            minSdk = libs.version("minSdk").toInt()
            targetSdk = libs.version("targetSdk").toInt()
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
            isCoreLibraryDesugaringEnabled = true
        }

        configurations.all {
            exclude(module = "protobuf-javalite")
        }

        dependencies {
            add("coreLibraryDesugaring", libs.library("android-desugarJdkLibs"))
        }
    }
}

fun Project.setupProtobuf() {
    protobuf {
        val protocClassifier = if (isArmProcessor) ":osx-x86_64" else ""
        val protobufVersion = libs.version("protobuf") + protocClassifier
        val grpcVersion = libs.version("grpc") + protocClassifier
        val grpcKotlinVersion = libs.version("grpc_kotlin")

        protoc {
            artifact = "com.google.protobuf:protoc:$protobufVersion"
        }

        plugins {
            register("java") {
                artifact = "io.grpc:protoc-gen-grpc-java:$grpcVersion"
            }
            register("grpc") {
                artifact = "io.grpc:protoc-gen-grpc-java:$grpcVersion"
            }
            register("grpc-kotlin") {
                artifact = "io.grpc:protoc-gen-grpc-kotlin:$grpcKotlinVersion:jdk8@jar"
            }
        }

        generateProtoTasks {
            all().forEach {
                it.builtins {
                    register("kotlin") { option("lite") }
                }
                it.plugins {
                    register("java") { option("lite") }
                    register("grpc") { option("lite") }
                    register("grpc-kotlin") { option("lite") }
                }
            }
        }
    }
}
