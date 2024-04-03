package com.example.template.primitive

import com.example.template.ktx.libs
import com.example.template.ktx.plugin
import com.example.template.ktx.setupProtobuf
import org.gradle.api.Plugin
import org.gradle.api.Project

class GoogleProtoBufPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugin("protobuf").pluginId)
            }

            setupProtobuf()
        }
    }
}
