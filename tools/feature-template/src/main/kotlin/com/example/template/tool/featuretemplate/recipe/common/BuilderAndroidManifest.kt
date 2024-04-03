package com.example.template.tool.featuretemplate.recipe.common

fun androidManifestBuilder(
    featureName: String,
    resourceName: String,
    packageName: String,
): String {
    return """
        <?xml version="1.0" encoding="utf-8"?>
        <manifest xmlns:android="http://schemas.android.com/apk/res/android">

            <application>
                <activity
                    android:name=".${featureName}Activity"
                    android:exported="false"/>
            </application>
        </manifest>

        """.trimIndent()
}
