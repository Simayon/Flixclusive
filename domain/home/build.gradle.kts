@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.flixclusive.library)
    alias(libs.plugins.flixclusive.hilt)
}

android {
    namespace = "com.flixclusive.domain.home"
}

dependencies {
    api(projects.data.configuration)
    api(projects.data.tmdb)
    api(projects.data.watchHistory)
    api(projects.domain.tmdb)

    implementation(projects.core.network)
}