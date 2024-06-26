package com.example.template.tool.featuretemplate.recipe.common

fun layoutXmlBuilder(
    featureName: String,
    resourceName: String,
    packageName: String,
): String {
    return """
        <?xml version="1.0" encoding="utf-8"?>
        <layout xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:app="http://schemas.android.com/apk/res-auto"
            xmlns:bind="http://schemas.android.com/apk/res-auto"
            xmlns:tools="http://schemas.android.com/tools">

            <data>

                <variable
                    name="vm"
                    type="$packageName.${featureName}ViewModel" />
            </data>

            <androidx.constraintlayout.widget.ConstraintLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent">

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    app:layout_constraintStart_toStartOf="parent"
                    app:layout_constraintEnd_toEndOf="parent"
                    app:layout_constraintTop_toTopOf="parent"
                    app:layout_constraintBottom_toBottomOf="parent"
                    android:text="@string/feature_$resourceName" />

            </androidx.constraintlayout.widget.ConstraintLayout>
        </layout>

        """.trimIndent()
}
