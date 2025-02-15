package com.example.departmentalresourcemanagement.features.hod.ui.navigation

// Constants for Routes
const val HOD_NAVIGATION_ROUTE_BASE = "hod_base_route"
const val HOD_SCREEN_ROUTE = "hod_screen_route"

// Sealed class for Navigation Routes
sealed class HodNavigation(val route: String) {
    data object HodBase : HodNavigation(route = HOD_NAVIGATION_ROUTE_BASE)
    data object HodScreen : HodNavigation(route = HOD_SCREEN_ROUTE)
}