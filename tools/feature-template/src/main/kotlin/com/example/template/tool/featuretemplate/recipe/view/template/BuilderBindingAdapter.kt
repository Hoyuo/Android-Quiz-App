package com.example.template.tool.featuretemplate.recipe.view.template

fun bindingAdapterBuilder(
    featureName: String,
    resourceName: String,
    packageName: String,
): String {
    return """
        @file:Suppress("ktlint:standard:no-empty-file")

        package $packageName

        """.trimIndent()
}
