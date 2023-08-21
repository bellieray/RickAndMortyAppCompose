@file:Suppress("UnstableApiUsage")
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.google.com")
        }
    }
    versionCatalogs {
        create("libs") { from(files("gradle/libs.version.toml")) }
    }
}
rootProject.name = "RickyAndMortyAppCompose"
include (":app")
include (":core:common")
include (":core:data")
include (":core:domain")
include (":feature:characters")
include (":feature:detail")
include (":feature:search")
include (":core:model")
include (":core:network")
include (":core:component")
include (":feature:favorites")
include (":core:database")

include(":build-logic")
include(":build-logic")
include(":build-logic")
include(":core:ui")
include(":feature:location")
