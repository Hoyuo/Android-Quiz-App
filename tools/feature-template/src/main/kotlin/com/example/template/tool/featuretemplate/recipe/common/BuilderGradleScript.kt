package com.example.template.tool.featuretemplate.recipe.common

fun gradleScriptViewBuilder(
    featureName: String,
    resourceName: String,
    packageName: String,
): String {
    return """
        plugins {
            id("com.example.template.convention.android.feature.view")
        }

        android.namespace = "com.example.template.feature.${featureName.lowercase()}"

        dependencies {
            implementation(projects.base)
            implementation(projects.share)
            implementation(projects.domain)

            implementation(libs.timber)
        }

        """.trimIndent()
}
