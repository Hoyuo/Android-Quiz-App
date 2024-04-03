plugins {
    `kotlin-dsl`
    distribution
    application
}

group = "com.example.template.tool.feature-template"
version = "1.0"

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_17.toString()
        }
    }
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.reflection)
    implementation("com.github.kotlin-inquirer:kotlin-inquirer:0.1.0")
    implementation("com.squareup:kotlinpoet:1.16.0")
}

application {
    mainClass.set("com.example.template.tool.featuretemplate.GenerateAppKt")
}
