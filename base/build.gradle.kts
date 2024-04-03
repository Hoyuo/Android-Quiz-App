plugins {
    id("com.example.template.primitive.android.library")
    id("com.example.template.primitive.android.kotlin")
    id("com.example.template.primitive.android.kotlin.ksp")
    id("com.example.template.primitive.android.view")
    id("com.example.template.primitive.android.navigation")
    id("com.example.template.primitive.android.hilt")
}

android.namespace = "com.example.template.base"

dependencies {
    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp)
    implementation(platform(libs.retrofit.bom))
    implementation(libs.retrofit)
    implementation(libs.timber)
}
