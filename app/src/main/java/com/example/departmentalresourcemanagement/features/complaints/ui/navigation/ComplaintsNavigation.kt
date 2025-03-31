package com.example.departmentalresourcemanagement.features.complaints.ui.navigation

// Constants for Routes
const val COMPLAINTS_NAVIGATION_ROUTE_BASE = "complaints_base_route"
const val COMPLAINTS_SCREEN_ROUTE = "complaints_screen_route"

// Sealed class for Navigation Routes
sealed class ComplaintsNavigation(val route: String) {
    data object ComplaintsBase : ComplaintsNavigation(route = COMPLAINTS_NAVIGATION_ROUTE_BASE)
    data object ComplaintsScreen : ComplaintsNavigation(route = COMPLAINTS_SCREEN_ROUTE)
}