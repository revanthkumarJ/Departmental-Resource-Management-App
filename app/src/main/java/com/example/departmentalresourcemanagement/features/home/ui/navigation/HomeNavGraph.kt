package com.example.departmentalresourcemanagement.features.home.ui.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.departmentalresourcemanagement.RevanthNavGraph
import com.example.departmentalresourcemanagement.features.home.ui.screens.HomeContent


fun NavGraphBuilder.homeNavGraph(
    onNavigate: (HomeDestinations) -> Unit,
) {
    navigation(
        startDestination = HomeNavigation.HomeScreen.route,
        route = RevanthNavGraph.MAIN_GRAPH
    ) {
        homeRoute(
            onNavigate = onNavigate
        )
    }
}

fun NavGraphBuilder.homeRoute(
    onNavigate: (HomeDestinations) -> Unit,
) {
    composable(
        route = HomeNavigation.HomeScreen.route
    ) {
        HomeContent(
            username = "dd",
            openNotifications = {},
            onNavigate = onNavigate,
            userBitmap = null,
            modifier = Modifier
        )
    }
}

fun NavController.navigateToHomeScreen(navOptions: NavOptions? = null) {
    this.navigate(HomeNavigation.HomeScreen.toString(), navOptions)
}
