package com.example.template.tool.featuretemplate.recipe.common

fun gitignoreBuilder(
    featureName: String,
    resourceName: String,
    packageName: String,
): String {
    return """
        /build

        """.trimIndent()
}
