package com.example.template.primitive

import com.example.template.internal.proguardPath
import com.example.template.internal.release
import com.example.template.ktx.androidLibrary
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidProguardPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            androidLibrary {
                buildTypes {
                    release {
                        isMinifyEnabled = true
                        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
                        proguardPath("$projectDir/proguard")
                    }
                }
            }
        }
    }
}
