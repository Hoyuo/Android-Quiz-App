plugins {
    id("com.example.template.primitive.android.library")
    id("com.example.template.primitive.android.kotlin")
    id("com.example.template.primitive.android.kotlin.serialization")
    id("com.example.template.primitive.android.hilt")
}

android.namespace = "com.example.template.data.remote"
android.buildFeatures.resValues = false

dependencies {
    implementation(projects.base)
    implementation(projects.share)
    implementation(projects.data.remote)

    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)

    implementation(platform(libs.retrofit.bom))
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.serialization)

    implementation(libs.timber)
}
