package com.example.template.tool.featuretemplate.recipe.common

fun stringResourceBuilder(
    featureName: String,
    resourceName: String,
    packageName: String,
): String {
    return """
        <?xml version="1.0" encoding="utf-8"?>
        <resources>
            <string name="feature_$resourceName">$featureName</string>
        </resources>

        """.trimIndent()
}
