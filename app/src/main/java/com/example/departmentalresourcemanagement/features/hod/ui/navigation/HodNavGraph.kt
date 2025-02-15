package com.example.departmentalresourcemanagement.features.hod.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.departmentalresourcemanagement.features.about.ui.navigation.AboutNavigation
import com.example.departmentalresourcemanagement.features.about.ui.screens.AboutScreen
import com.example.departmentalresourcemanagement.features.hod.ui.screens.HodScreen

fun NavController.navigateToHodScreen() {
    navigate(HodNavigation.HodScreen.route)
}

fun NavGraphBuilder.hodNavGraph(
    navigateBack: () -> Unit,
) {
    navigation(
        startDestination = HodNavigation.HodScreen.route,
        route = HodNavigation.HodBase.route,
    ) {
        hodScreenRoute(
            navigateBack = navigateBack
        )
    }
}

fun NavGraphBuilder.hodScreenRoute(
    navigateBack: () -> Unit,
) {
    composable(
        route = HodNavigation.HodScreen.route,
    ) {
        HodScreen(navigateBack)
    }
}
