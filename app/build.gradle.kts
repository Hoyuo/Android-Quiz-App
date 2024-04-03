@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.example.template.primitive.android.application")
    id("com.example.template.primitive.android.kotlin")
    id("com.example.template.primitive.android.kotlin.serialization")
    id("com.example.template.primitive.android.kotlin.parcelize")
    id("com.example.template.primitive.android.hilt")
    id("com.example.template.primitive.android.unitTest")
}

android {
    namespace = "com.example.template"

    buildFeatures {
        this.dataBinding = true
        this.viewBinding = true
        this.buildConfig = true
    }
}

dependencies {
    implementation(projects.base)
    implementation(projects.share)
    implementation(projects.data)
    implementation(projects.data.local)
    implementation(projects.data.remote)
    implementation(projects.domain)
    implementation(projects.presentation)

    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)

    debugImplementation(libs.flipper)
    debugImplementation(libs.flipper.soloader)
    debugImplementation(libs.flipper.network)
    debugImplementation(libs.flipper.leakcanary)

    debugImplementation(libs.leakcanary)

    implementation(libs.timber)
}
