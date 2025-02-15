package com.example.departmentalresourcemanagement.features.cr.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.departmentalresourcemanagement.features.cr.ui.screens.CrScreen

fun NavController.navigateToCRScreen() {
    navigate(CrNavigation.CrScreen.route)
}

fun NavGraphBuilder.crNavGraph(
    navigateBack: () -> Unit,
) {
    navigation(
        startDestination = CrNavigation.CrScreen.route,
        route = CrNavigation.CrBase.route,
    ) {
        crScreenRoute(
            navigateBack = navigateBack
        )
    }
}

fun NavGraphBuilder.crScreenRoute(
    navigateBack: () -> Unit,
) {
    composable(
        route = CrNavigation.CrScreen.route,
    ) {
        CrScreen(navigateBack=navigateBack)
    }
}
