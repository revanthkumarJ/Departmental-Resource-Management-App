package com.example.departmentalresourcemanagement.features.home.ui.navigation

import com.example.departmentalresourcemanagement.features.home.ui.navigation.HomeRoute.HOME_NAVIGATION_ROUTE_BASE
import com.example.departmentalresourcemanagement.features.home.ui.navigation.HomeRoute.HOME_SCREEN_ROUTE
import com.example.departmentalresourcemanagement.features.home.viewmodel.HomeNavigationItems


sealed class HomeNavigation(val route: String) {
    data object HomeBase : HomeNavigation(route = HOME_NAVIGATION_ROUTE_BASE)
    data object HomeScreen : HomeNavigation(route = HOME_SCREEN_ROUTE)
}

object HomeRoute {
    const val HOME_NAVIGATION_ROUTE_BASE = "home_base_route"
    const val HOME_SCREEN_ROUTE = "home_screen_route"
}

enum class HomeDestinations {
    HOME,
    ACCOUNTS,
    LOAN_ACCOUNT,
    SAVINGS_ACCOUNT,
    RECENT_TRANSACTIONS,
    CHARGES,
    THIRD_PARTY_TRANSFER,
    SETTINGS,
    ABOUT_US,
    HELP,
    SHARE,
    APP_INFO,
    LOGOUT,
    TRANSFER,
    BENEFICIARIES,
    SURVEY,
    NOTIFICATIONS,
    PROFILE,
}

fun HomeNavigationItems.toDestination(): HomeDestinations {
    return when (this) {
        HomeNavigationItems.Home -> HomeDestinations.HOME

    }
}

//fun HomeCardItem.toDestination(): HomeDestinations {
//    return when (this) {
//        HomeCardItem.AccountCard -> HomeDestinations.SAVINGS_ACCOUNT
//        HomeCardItem.BeneficiariesCard -> HomeDestinations.BENEFICIARIES
//        HomeCardItem.ChargesCard -> HomeDestinations.CHARGES
//        HomeCardItem.LoanCard -> HomeDestinations.LOAN_ACCOUNT
//        HomeCardItem.SurveyCard -> HomeDestinations.SURVEY
//        HomeCardItem.TransferCard -> HomeDestinations.TRANSFER
//    }
//}
