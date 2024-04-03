import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.example.template.buildlogic"

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(gradleKotlinDsl())
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.android.gradlePlugin)
    implementation(libs.androidx.navigation.safe.args.gradlePlugin)
    implementation(libs.hilt.android.gradlePlugin)
    implementation(libs.protobuf.gradlePlugin)
    implementation(libs.google.services.gradlePlugin)
    implementation(libs.firebase.crashlytics.gradlePlugin)
    implementation(libs.firebase.performance.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "com.example.template.primitive.android.application"
            implementationClass = "com.example.template.primitive.AndroidApplicationPlugin"
        }
        register("androidLibrary") {
            id = "com.example.template.primitive.android.library"
            implementationClass = "com.example.template.primitive.AndroidLibraryPlugin"
        }
        register("androidProguard") {
            id = "com.example.template.primitive.android.proguard"
            implementationClass = "com.example.template.primitive.AndroidProguardPlugin"
        }
        register("androidUnitTest") {
            id = "com.example.template.primitive.android.unitTest"
            implementationClass = "com.example.template.primitive.AndroidKotlinUnitTestPlugin"
        }

        // View
        register("androidView") {
            id = "com.example.template.primitive.android.view"
            implementationClass = "com.example.template.primitive.AndroidViewPlugin"
        }

        // Hilt
        register("androidHilt") {
            id = "com.example.template.primitive.android.hilt"
            implementationClass = "com.example.template.primitive.AndroidHiltPlugin"
        }

        // Navigation
        register("androidNavigation") {
            id = "com.example.template.primitive.android.navigation"
            implementationClass = "com.example.template.primitive.AndroidNavigationPlugin"
        }

        // Kotlin
        register("androidKotlinPlugin") {
            id = "com.example.template.primitive.android.kotlin"
            implementationClass = "com.example.template.primitive.AndroidKotlinPlugin"
        }
        register("androidKotlinSerializationPlugin") {
            id = "com.example.template.primitive.android.kotlin.serialization"
            implementationClass = "com.example.template.primitive.AndroidKotlinSerializationPlugin"
        }
        register("androidKotlinParcelizePlugin") {
            id = "com.example.template.primitive.android.kotlin.parcelize"
            implementationClass = "com.example.template.primitive.AndroidKotlinParcelizePlugin"
        }
        register("androidKotlinSymbolPlugin") {
            id = "com.example.template.primitive.android.kotlin.ksp"
            implementationClass = "com.example.template.primitive.AndroidKotlinSymbolPlugin"
        }

        // Firebase
        register("FirebaseCrashlytics") {
            id = "com.example.template.primitive.firebase.crashlytics"
            implementationClass = "com.example.template.primitive.FirebaseCrashlyticsPlugin"
        }
        register("FirebasePerformance") {
            id = "com.example.template.primitive.firebase.performance"
            implementationClass = "com.example.template.primitive.FirebasePerformancePlugin"
        }

        // Google
        register("GoogleProtoBuf") {
            id = "com.example.template.primitive.google.protobuf"
            implementationClass = "com.example.template.primitive.GoogleProtoBufPlugin"
        }
        register("GoogleServices") {
            id = "com.example.template.primitive.google.services"
            implementationClass = "com.example.template.primitive.GoogleServicesPlugin"
        }

        // Conventions
        register("androidFeatureView") {
            id = "com.example.template.convention.android.feature.view"
            implementationClass = "com.example.template.convention.AndroidViewFeaturePlugin"
        }
    }
}
