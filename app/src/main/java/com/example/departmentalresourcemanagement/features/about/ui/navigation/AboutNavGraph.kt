package com.example.departmentalresourcemanagement.features.about.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.departmentalresourcemanagement.features.about.ui.screens.AboutScreen


fun NavController.navigateToAboutScreen() {
    navigate(AboutNavigation.AboutScreen.route)
}

fun NavGraphBuilder.aboutNavGraph(
    navigateBack: () -> Unit,
) {
    navigation(
        startDestination = AboutNavigation.AboutScreen.route,
        route =AboutNavigation.AboutBase.route,
    ) {
        aboutScreenRoute(
            navigateBack = navigateBack
        )
    }
}

fun NavGraphBuilder.aboutScreenRoute(
    navigateBack: () -> Unit,
) {
    composable(
        route = AboutNavigation.AboutScreen.route,
    ) {
        AboutScreen (navigateBack=navigateBack)
    }
}
