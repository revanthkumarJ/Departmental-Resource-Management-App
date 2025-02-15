package com.example.departmentalresourcemanagement.features.faculty.ui.navigation

// Constants for Routes
const val FACULTY_NAVIGATION_ROUTE_BASE = "faculty_base_route"
const val FACULTY_SCREEN_ROUTE = "faculty_screen_route"

// Sealed class for Navigation Routes
sealed class FacultyNavigation(val route: String) {
    data object FacultyBase : FacultyNavigation(route = FACULTY_NAVIGATION_ROUTE_BASE)
    data object FacultyScreen : FacultyNavigation(route = FACULTY_SCREEN_ROUTE)
}