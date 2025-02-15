package com.example.departmentalresourcemanagement.features.home.ui.navigation


import com.example.departmentalresourcemanagement.features.home.viewmodel.HomeNavigationItems

sealed class HomeNavigation(val route: String) {
    data object HomeBase : HomeNavigation("home_base")
    data object HomeScreen : HomeNavigation("home")
}

enum class HomeDestinations {
    HOME,
    SETTINGS,
    ABOUT_US,
    APP_INFO,
    LOGOUT,
    NOTIFICATIONS,
    PROFILE,
    CR,
    FACULTY,
    HOD,
    OFFICIALS,
    Timetable
}

fun HomeNavigationItems.toDestination(): HomeDestinations {
    return when (this) {
        HomeNavigationItems.Home -> HomeDestinations.HOME
        HomeNavigationItems.CR -> HomeDestinations.CR
        HomeNavigationItems.ABOUT_US -> HomeDestinations.ABOUT_US
        HomeNavigationItems.SETTINGS -> HomeDestinations.SETTINGS
        HomeNavigationItems.APP_INFO -> HomeDestinations.APP_INFO
        HomeNavigationItems.LOGOUT -> HomeDestinations.LOGOUT
        HomeNavigationItems.HOD -> HomeDestinations.HOD
        HomeNavigationItems.FACULTY -> HomeDestinations.FACULTY
        HomeNavigationItems.OFFICIALS -> HomeDestinations.OFFICIALS
        HomeNavigationItems.Timetable -> HomeDestinations.Timetable
    }
}
