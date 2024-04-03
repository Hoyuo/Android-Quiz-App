plugins {
    id("com.example.template.primitive.android.library")
    id("com.example.template.primitive.android.kotlin")
    id("com.example.template.primitive.android.kotlin.serialization")
    id("com.example.template.primitive.android.kotlin.ksp")
    id("com.example.template.primitive.android.hilt")
}

android.namespace = "com.example.template.share"
android.buildFeatures {
    dataBinding = true
    viewBinding = true
}

dependencies {
    implementation(projects.base)

    implementation(libs.androidx.constraintlayout)
    implementation(libs.bundles.navigation)

    implementation(libs.bundles.glide)
    ksp(libs.glide.compiler)
}
