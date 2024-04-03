package com.example.template.primitive

import com.example.template.internal.Dimension
import com.example.template.internal.Flavors
import com.example.template.internal.Version
import com.example.template.internal.debug
import com.example.template.internal.proguardPath
import com.example.template.ktx.androidApplication
import com.example.template.ktx.setupAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
            }

            androidApplication {
                setupAndroid()

                defaultConfig {
                    // TODO applicationId 변경
                    applicationId = "com.example.template"
                    versionCode = Version.version_code
                    versionName = Version.version_name
                    vectorDrawables.useSupportLibrary = true
                }

                bundle {
                    language {
                        enableSplit = false
                    }
                }

                signingConfigs {
                    debug {
                        storeFile = file("$rootDir/settings/debug.keystore")
                    }
                }

                buildTypes {
                    debug
                    release {
                        isMinifyEnabled = true
                        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
                        proguardPath("$rootDir/app/proguard")
                    }
                }

                flavorDimensions.add(Dimension.VERSION)
                productFlavors {
                    create(Flavors.DEV) { proguardFile("debug/proguard-debug.pro") }
                    create(Flavors.STAGING)
                    create(Flavors.PRODUCTION)

                    forEach { flavor ->
                        with(flavor) {
                            dimension = Dimension.VERSION

                            if (name != Flavors.PRODUCTION) {
                                applicationIdSuffix = name
                            } else {
                                versionName = Version.production_version_name
                            }
                        }
                    }
                }

                packaging {
                    resources.excludes.add("META-INF/AL2.0")
                    resources.excludes.add("META-INF/LGPL2.1")
                }

                lint {
                    checkReleaseBuilds = false
                    abortOnError = false
                }
            }
        }
    }
}
