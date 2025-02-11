pluginManagement {
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

        maven { setUrl("https://artifactory-external.vkpartner.ru/artifactory/maven/") }
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://artifactory-external.vkpartner.ru/artifactory/maven/") }
    }
}

rootProject.name = "RanteksCalc"
include(":app")
 