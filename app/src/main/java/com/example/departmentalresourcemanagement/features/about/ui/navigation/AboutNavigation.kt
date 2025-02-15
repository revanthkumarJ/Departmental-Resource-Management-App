package com.example.departmentalresourcemanagement.features.about.ui.navigation

// Constants for Routes
const val ABOUT_NAVIGATION_ROUTE_BASE = "about_base_route"
const val ABOUT_SCREEN_ROUTE = "about_screen_route"

// Sealed class for Navigation Routes
sealed class AboutNavigation(val route: String) {
    data object AboutBase : AboutNavigation(route = ABOUT_NAVIGATION_ROUTE_BASE)
    data object AboutScreen : AboutNavigation(route = ABOUT_SCREEN_ROUTE)
}
