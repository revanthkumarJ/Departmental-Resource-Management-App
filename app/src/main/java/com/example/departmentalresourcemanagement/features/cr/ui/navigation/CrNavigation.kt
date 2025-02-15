package com.example.departmentalresourcemanagement.features.cr.ui.navigation

// Constants for Routes
const val CR_NAVIGATION_ROUTE_BASE = "cr_base_route"
const val CR_SCREEN_ROUTE = "cr_screen_route"

// Sealed class for Navigation Routes
sealed class CrNavigation(val route: String) {
    data object CrBase : CrNavigation(route = CR_NAVIGATION_ROUTE_BASE)
    data object CrScreen : CrNavigation(route = CR_SCREEN_ROUTE)
}