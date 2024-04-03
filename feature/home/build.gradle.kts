plugins {
    id("com.example.template.convention.android.feature.view")
}

android.namespace = "com.example.template.feature.home"

dependencies {
    implementation(projects.base)
    implementation(projects.share)
    implementation(projects.domain)

    implementation(libs.timber)
}
