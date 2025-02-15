package com.example.departmentalresourcemanagement.features.settings.ui.navigation

// Constants for Routes
const val SETTINGS_NAVIGATION_ROUTE_BASE = "settings_base_route"
const val SETTINGS_SCREEN_ROUTE = "settings_screen_route"

// Sealed class for Navigation Routes
sealed class SettingsNavigation(val route: String) {
    data object SettingsBase : SettingsNavigation(route = SETTINGS_NAVIGATION_ROUTE_BASE)
    data object SettingsScreen : SettingsNavigation(route = SETTINGS_SCREEN_ROUTE)
}
