plugins {
    id("com.example.template.convention.android.feature.view")
}

android.namespace = "com.example.template.presentation"

dependencies {
    implementation(projects.base)
    implementation(projects.share)
    implementation(projects.domain)

    implementation(libs.timber)

// region Add dependencies for each feature module
    implementation(projects.feature.home)
// endregion feature module
}
