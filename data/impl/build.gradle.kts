plugins {
    id("com.example.template.primitive.android.library")
    id("com.example.template.primitive.android.kotlin")
    id("com.example.template.primitive.android.hilt")
}

android.namespace = "com.example.template.data"
android.buildFeatures.resValues = false

dependencies {
    implementation(projects.base)
    implementation(projects.share)
    implementation(projects.data)

    implementation(projects.data.local)
    runtimeOnly(projects.data.local.impl)

    implementation(projects.data.remote)
    runtimeOnly(projects.data.remote.impl)

    implementation(libs.timber)
}
