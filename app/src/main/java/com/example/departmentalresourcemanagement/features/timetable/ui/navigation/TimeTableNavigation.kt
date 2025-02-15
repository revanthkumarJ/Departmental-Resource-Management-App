package com.example.departmentalresourcemanagement.features.timetable.ui.navigation

// Constants for Routes
const val TIMETABLE_NAVIGATION_ROUTE_BASE = "timetable_base_route"
const val TIMETABLE_SCREEN_ROUTE = "timetable_screen_route"

// Sealed class for Navigation Routes
sealed class TimeTableNavigation(val route: String) {
    data object TimeTableBase : TimeTableNavigation(route = TIMETABLE_NAVIGATION_ROUTE_BASE)
    data object TimeTableScreen : TimeTableNavigation(route = TIMETABLE_SCREEN_ROUTE)
}
