package com.example.departmentalresourcemanagement.features.crprofiles.ui.navigation

// Constants for Routes
const val CRPROFILE_NAVIGATION_ROUTE_BASE = "crprofile_base_route"
const val CRPROFILE_SCREEN_ROUTE = "crprofile_screen_route"

// Sealed class for Navigation Routes
sealed class CrProfileNavigation(val route: String) {
    data object CrProfileBase : CrProfileNavigation(route = CRPROFILE_NAVIGATION_ROUTE_BASE)
    data object CrProfileScreen : CrProfileNavigation(route = CRPROFILE_SCREEN_ROUTE)
}