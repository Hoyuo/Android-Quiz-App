pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

// TODO Project name 을 변경하세요
rootProject.name = "Android-Template-View"

include(":tools:feature-template")

include(":app")
include(":base")
include(":share")
include(":data")
include(":data:impl")
include(":data:local")
include(":data:local:impl")
include(":data:remote")
include(":data:remote:impl")
include(":domain")
include(":presentation")
include(":feature:home")
