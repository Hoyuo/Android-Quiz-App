package com.example.template.tool.featuretemplate.recipe.common

fun navigationBuilder(
    featureName: String,
    resourceName: String,
    packageName: String,
): String {
    return """
        <?xml version="1.0" encoding="utf-8"?>
        <navigation xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:app="http://schemas.android.com/apk/res-auto"
            xmlns:tools="http://schemas.android.com/tools"
            android:id="@+id/nav_$resourceName"
            app:startDestination="@id/fragment_$resourceName">

            <fragment
                android:id="@+id/fragment_$resourceName"
                android:name="$packageName.${featureName}Fragment"
                android:label="@string/feature_$resourceName"
                tools:layout="@layout/fragment_$resourceName" />

            <action
                android:id="@+id/action_global_$resourceName"
                app:destination="@id/nav_$resourceName" />

        </navigation>

        """.trimIndent()
}
