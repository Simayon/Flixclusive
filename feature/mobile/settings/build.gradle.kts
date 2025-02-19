@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.flixclusive.feature)
    alias(libs.plugins.flixclusive.compose)
    alias(libs.plugins.flixclusive.destinations)
}

android {
    namespace = "com.flixclusive.feature.mobile.preferences"
}

dependencies {
    implementation(projects.core.datastore)
    implementation(projects.core.ui.mobile)
    implementation(projects.data.searchHistory)
    implementation(projects.data.user)
    implementation(projects.domain.provider)

    implementation(libs.compose.adaptive)
    implementation(libs.compose.adaptive.layout)
    implementation(libs.compose.adaptive.navigation)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material3)
    implementation(libs.compose.runtime)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.palette)
}