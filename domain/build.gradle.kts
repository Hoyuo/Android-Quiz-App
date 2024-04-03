plugins {
    id("com.example.template.primitive.android.library")
    id("com.example.template.primitive.android.kotlin")
    id("com.example.template.primitive.android.hilt")
}

android.namespace = "com.example.template.domain"
android.buildFeatures.resValues = false

dependencies {
    implementation(projects.base)
    implementation(projects.share)

    implementation(projects.data)
    runtimeOnly(projects.data.impl)

    implementation(libs.timber)
}
