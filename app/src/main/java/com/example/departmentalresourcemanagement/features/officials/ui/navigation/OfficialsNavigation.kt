package com.example.departmentalresourcemanagement.features.officials.ui.navigation

// Constants for Routes
const val OFFICIALS_NAVIGATION_ROUTE_BASE = "officials_base_route"
const val OFFICIALS_SCREEN_ROUTE = "officials_screen_route"

// Sealed class for Navigation Routes
sealed class OfficialsNavigation(val route: String) {
    data object OfficialsBase : OfficialsNavigation(route = OFFICIALS_NAVIGATION_ROUTE_BASE)
    data object OfficialsScreen : OfficialsNavigation(route = OFFICIALS_SCREEN_ROUTE)
}